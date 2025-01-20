import Foundation

struct CongressMember: Identifiable, Decodable {
    let id: UUID
    let name: String
    let disclosureYear: Int
    let disclosureDate: String
    let transactionDate: String
    let owner: String?
    let ticker: String
    let assetDescription: String
    let typeOfTransaction: String
    let amount: String
    let representative: String
    let district: String
    let state: String
    let ptrLink: String
    let capGainsOver200USD: Bool
    let industry: String?
    let sector: String?
    let party: String

    enum CodingKeys: String, CodingKey {
        case id = "transaction_id"
        case name = "name"
        case disclosureYear = "disclosure_year"
        case disclosureDate = "disclosure_date"
        case transactionDate = "transaction_date"
        case owner = "owner"
        case ticker = "ticker"
        case assetDescription = "asset_description"
        case typeOfTransaction = "type"
        case amount = "amount"
        case representative = "representative"
        case district = "district"
        case state = "state"
        case ptrLink = "ptr_link"
        case capGainsOver200USD = "cap_gains_over_200_usd"
        case industry = "industry"
        case sector = "sector"
        case party = "party"
    }
} 
