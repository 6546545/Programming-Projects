import SwiftUI

struct StockTradeHistoryView: View {
    let stockName: String
    let trades: [StockTrade]

    var body: some View {
        VStack {
            Text("Trade History for \(stockName)")
                .font(.headline)
                .padding()

            LineGraph(
                dataPoints: trades.map { CGFloat($0.tradeValue) },
                dates: trades.map { formattedDate(from: $0.tradeDate) },
                strokeColor: .blue,
                lineWidth: 2,
                currentValue: trades.last?.tradeValue ?? 0
            )
            .frame(height: 300)
            .padding()
        }
        .navigationTitle(stockName)
    }

    private func formattedDate(from date: Date) -> String {
        let formatter = DateFormatter()
        formatter.dateStyle = .short // Adjust to your preferred date style
        return formatter.string(from: date)
    }
}

struct LineGraph: View {
    var dataPoints: [CGFloat]
    var dates: [String]
    var strokeColor: Color
    var lineWidth: CGFloat
    var currentValue: CGFloat

    var body: some View {
        GeometryReader { geometry in
            VStack {
                ZStack {
                    // Draw grid lines
                    Path { path in
                        let stepY = geometry.size.height / 5
                        for i in 0...5 {
                            let y = stepY * CGFloat(i)
                            path.move(to: CGPoint(x: 0, y: y))
                            path.addLine(to: CGPoint(x: geometry.size.width, y: y))
                        }
                    }
                    .stroke(Color.gray.opacity(0.3), lineWidth: 1)

                    // Draw the line graph
                    Path { path in
                        guard dataPoints.count > 1 else { return }

                        let stepX = geometry.size.width / CGFloat(dataPoints.count - 1)
                        let maxY = dataPoints.max() ?? 1
                        let scaleY = geometry.size.height / maxY

                        path.move(to: CGPoint(x: 0, y: geometry.size.height - dataPoints[0] * scaleY))

                        for index in 1..<dataPoints.count {
                            let point = CGPoint(x: CGFloat(index) * stepX, y: geometry.size.height - dataPoints[index] * scaleY)
                            path.addLine(to: point)
                        }
                    }
                    .stroke(strokeColor, lineWidth: lineWidth)

                    // Draw the current value marker
                    if let currentIndex = dataPoints.firstIndex(of: currentValue) {
                        let stepX = geometry.size.width / CGFloat(dataPoints.count - 1)
                        let maxY = dataPoints.max() ?? 1
                        let scaleY = geometry.size.height / maxY
                        let currentPoint = CGPoint(x: CGFloat(currentIndex) * stepX, y: geometry.size.height - currentValue * scaleY)

                        Circle()
                            .fill(Color.red)
                            .frame(width: 8, height: 8)
                            .position(currentPoint)
                    }
                }

                // Draw the X-axis labels
                HStack {
                    ForEach(dates, id: \.self) { date in
                        Text(date)
                            .font(.caption)
                            .frame(maxWidth: .infinity)
                    }
                }
            }
        }
    }
} 
