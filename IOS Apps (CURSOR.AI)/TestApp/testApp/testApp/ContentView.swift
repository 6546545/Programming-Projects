//
//  ContentView.swift
//  testApp
//
//  Created by Andrew Gould on 12/29/24.
//

import SwiftUI

struct ContentView: View {
    @StateObject private var viewModel = CongressTradesViewModel()
    @State private var searchText = ""

    var body: some View {
        NavigationView {
            VStack {
                SearchBar(text: $searchText)
                List {
                    ForEach(viewModel.congressMembers.filter {
                        searchText.isEmpty ? true : $0.representative.localizedCaseInsensitiveContains(searchText)
                    }) { member in
                        NavigationLink(destination: MemberDetailView(member: member)) {
                            VStack(alignment: .leading) {
                                Text(member.representative)
                                    .font(.headline)
                                Text("Party: \(member.party)")
                                    .font(.subheadline)
                            }
                        }
                    }
                }
                .navigationTitle("Congress Members")
            }
        }
        .onAppear {
            viewModel.fetchCongressMembers()
        }
    }
}

struct PartyButton: View {
    let title: String
    let isSelected: Bool
    let action: () -> Void

    var body: some View {
        Button(action: action) {
            Text(title)
                .padding()
                .background(isSelected ? Color.blue.opacity(0.2) : Color.clear)
                .cornerRadius(8)
                .overlay(
                    RoundedRectangle(cornerRadius: 8)
                        .stroke(isSelected ? Color.blue : Color.gray, lineWidth: 1)
                )
        }
        .buttonStyle(PlainButtonStyle())
    }
}

struct SearchBar: UIViewRepresentable {
    @Binding var text: String

    class Coordinator: NSObject, UISearchBarDelegate {
        @Binding var text: String

        init(text: Binding<String>) {
            _text = text
        }

        func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
            text = searchText
        }
    }

    func makeCoordinator() -> Coordinator {
        return Coordinator(text: $text)
    }

    func makeUIView(context: Context) -> UISearchBar {
        let searchBar = UISearchBar(frame: .zero)
        searchBar.delegate = context.coordinator
        return searchBar
    }

    func updateUIView(_ uiView: UISearchBar, context: Context) {
        uiView.text = text
    }
}

#Preview {
    ContentView()
}
