import Foundation

class HouseStockWatcherService {
    private let baseURL = "https://house-stock-watcher-data.s3-us-west-2.amazonaws.com/data/filemap.xml"

    func fetchStockTrades(for memberId: UUID, completion: @escaping (Result<[StockTrade], Error>) -> Void) {
        let urlString = "\(baseURL)/members/\(memberId)/trades.json"
        guard let url = URL(string: urlString) else {
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
                decoder.dateDecodingStrategy = .iso8601 // Adjust if the date format is different
                let trades = try decoder.decode([StockTrade].self, from: data)
                completion(.success(trades))
            } catch {
                completion(.failure(error))
            }
        }.resume()
    }
} 