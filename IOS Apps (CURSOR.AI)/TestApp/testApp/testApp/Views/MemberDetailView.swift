import SwiftUI

struct MemberDetailView: View {
    let member: CongressMember

    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            Text(member.name)
                .font(.largeTitle)
                .padding(.bottom, 10)
            Text("Party: \(member.party)")
            Text("State: \(member.state)")
            Text("Transaction: \(member.typeOfTransaction) \(member.assetDescription)")
            Text("Amount: \(member.amount)")
            Text("Disclosure Date: \(formattedDate(from: member.disclosureDate))")
            Text("Transaction Date: \(formattedDate(from: member.transactionDate))")
            if let industry = member.industry {
                Text("Industry: \(industry)")
            }
            if let sector = member.sector {
                Text("Sector: \(sector)")
            }
            Spacer()
        }
        .padding()
        .navigationTitle("Member Details")
    }

    private func formattedDate(from dateString: String) -> String {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd" // Adjust to match your date format
        if let date = formatter.date(from: dateString) {
            formatter.dateStyle = .medium
            return formatter.string(from: date)
        }
        return dateString
    }
} 