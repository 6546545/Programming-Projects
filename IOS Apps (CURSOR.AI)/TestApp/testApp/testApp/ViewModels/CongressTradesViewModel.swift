import SwiftUI
import Combine

class CongressTradesViewModel: ObservableObject {
    @Published var congressMembers: [CongressMember] = []
    private let memberService = CongressionalMemberService()

    func fetchCongressMembers() {
        memberService.fetchCongressMembers { [weak self] result in
            DispatchQueue.main.async {
                switch result {
                case .success(let members):
                    self?.congressMembers = members
                case .failure(let error):
                    print("Error fetching members: \(error)")
                    // Handle error (e.g., show an alert)
                }
            }
        }
    }
} 