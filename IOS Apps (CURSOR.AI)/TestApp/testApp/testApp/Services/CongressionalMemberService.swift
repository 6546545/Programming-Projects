import Foundation

class CongressionalMemberService {
    private let baseURL = "https://house-stock-watcher-data.s3-us-west-2.amazonaws.com/data/all_transactions.json"

    func fetchCongressMembers(completion: @escaping (Result<[CongressMember], Error>) -> Void) {
        guard let url = URL(string: baseURL) else {
            completion(.failure(NSError(domain: "Invalid URL", code: 0, userInfo: nil)))
            return
        }

        URLSession.shared.dataTask(with: url) { data, response, error in
            if let error = error {
                completion(.failure(error))
                return
            }

            guard let data = data else {
                completion(.failure(NSError(domain: "No data", code: 0, userInfo: nil)))
                return
            }

            do {
                let decoder = JSONDecoder()
                decoder.dateDecodingStrategy = .iso8601
                let members = try decoder.decode([CongressMember].self, from: data)
                completion(.success(members))
            } catch {
                completion(.failure(error))
            }
        }.resume()
    }
} 