import Foundation

struct StockTrade: Identifiable, Decodable {
    let id: UUID
    let stockName: String
    let tradeDate: Date
    let tradeValue: Double
    let transactionType: String // e.g., "Purchase" or "Sale"

    enum CodingKeys: String, CodingKey {
        case id = "transaction_id"
        case stockName = "stock_name"
        case tradeDate = "transaction_date"
        case tradeValue = "transaction_value"
        case transactionType = "transaction_type"
    }
} 