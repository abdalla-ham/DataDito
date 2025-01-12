//
//  RemainingUsageView.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 9.12.2024.
//

import SwiftUI

struct RemainingUsageView: View {
    var body: some View {
        NavigationView {
            ZStack {
                Color.pink.opacity(0.1)
                    .ignoresSafeArea()

                VStack(spacing: 20) {
                    VStack{
                        Image("datadito")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 350, height: 80)
                    }
                    .background(Color.white)
                    .cornerRadius(50)
                    .overlay(
                        RoundedRectangle(cornerRadius: 50).stroke(lineWidth: 2)
                    )
                    
                    VStack {
                        VStack(alignment: .leading) {
                            Text("Data | 9.1")
                                .font(.headline)
                                .padding(.leading, 20)
                                .padding(.top, 40)
                            ProgressBar(progress: 0.91, color: .red)
                                .frame(height: 10)
                                .padding(.horizontal, 20)

                            Text("15/12/2024")
                                .font(.subheadline)
                                .offset(x: 200)
                                .padding(.top, 2)

                            Text("Minutes | 30")
                                .font(.headline)
                                .padding(.leading, 20)
                                .padding(.top, 10)
                            ProgressBar(progress: 0.50, color: .red)
                                .frame(height: 10)
                                .padding(.horizontal, 20)

                            Text("15/12/2024")
                                .font(.subheadline)
                                .offset(x: 200)
                                .padding(.top, 2)

                            Text("SMS | 200")
                                .font(.headline)
                                .padding(.leading, 20)
                                .padding(.top, 10)
                            ProgressBar(progress: 0.75, color: .red)
                                .frame(height: 10)
                                .padding(.horizontal, 20)

                            Text("15/12/2024")
                                .font(.subheadline)
                                .offset(x: 200)
                                .padding(.top, 2)

                            Button(action: {
                                // Logout function
                            }) {
                                Text("Logout")
                                    .font(.headline)
                                    .foregroundColor(.black)
                                    .padding()
                                    .background(Color.white)
                                    .cornerRadius(10)
                                    .overlay(
                                        RoundedRectangle(cornerRadius: 10)
                                            .stroke(Color.black, lineWidth: 1)
                                    )
                                    .offset(x: 90)
                                    .padding(20)
                                    .padding(.top, 50)
                            }
                        }
                        .background(Color.pink.opacity(0.1))
                        .cornerRadius(35)
                        .padding(.horizontal)
                        .padding(.vertical, 20)
                        .padding(.horizontal, 10)
                    }
                    .background(Color.white)
                    .cornerRadius(35)
                    .overlay(
                        RoundedRectangle(cornerRadius: 35)
                            .stroke(Color.black, lineWidth: 2)
                    )
                    .padding(.horizontal, 25)
                }
            }
            .navigationBarHidden(true)
        }
    }
}

struct RemainingUsagePreviews: PreviewProvider {
    static var previews: some View {
        RemainingUsageView()
    }
}

struct ProgressBar: View {
    var progress: CGFloat
    var color: Color

    var body: some View {
        GeometryReader { geometry in
            ZStack(alignment: .leading) {
                Rectangle()
                    .frame(height: geometry.size.height)
                    .cornerRadius(geometry.size.height / 2)
                    .foregroundColor(Color.white)

                Rectangle()
                    .frame(width: geometry.size.width * progress, height: geometry.size.height)
                    .cornerRadius(geometry.size.height / 2)
                    .foregroundColor(color)
            }
        }
    }
}
