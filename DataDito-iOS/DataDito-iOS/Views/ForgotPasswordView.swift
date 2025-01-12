//
//  ForgotPasswordView.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 11.01.2025.
//

import SwiftUI

struct ForgotPasswordView: View {
    @State private var nationalID: String = ""
    @State private var email: String = ""
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        NavigationView {
            ZStack {
                Color.pink.opacity(0.1)
                    .ignoresSafeArea()

                VStack {
                    Image("Logo-3-2")
                        .resizable()
                        .scaledToFit()
                        .frame(height: 80)
                        .padding()
                        .offset(y: 10)
                        .zIndex(10)

                    VStack {
                        VStack(spacing: 15) {
                            Group {
                                TextField("National ID:", text: $nationalID)
                                TextField("Email:", text: $email)
                            }
                            .padding(12)
                            .background(Color.white)
                            .cornerRadius(10)
                            .overlay(
                                RoundedRectangle(cornerRadius: 10)
                                    .stroke(Color.black, lineWidth: 1)
                            )
                            .padding(.horizontal, 40)
                        }
                        .padding(.vertical, 20)
                        .padding(.top, 40)
                        .padding(.bottom, 50)

                        Button(action: {
                            // Send recovery email function
                        }) {
                            Text("Send recovery email")
                                .font(.headline)
                                .foregroundColor(.white)
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.red)
                                .cornerRadius(10)
                        }
                        .padding(.horizontal, 40)
                        .padding(.bottom, 20)

                        Button(action: {
                            presentationMode.wrappedValue.dismiss()
                        }) {
                            Text("Go Back")
                                .font(.headline)
                                .foregroundColor(.white)
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.red)
                                .cornerRadius(10)
                        }
                        .padding(.horizontal, 40)
                        .padding(.bottom, 20)
                    }
                    .background(Color.white)
                    .cornerRadius(15)
                    .overlay(
                        RoundedRectangle(cornerRadius: 15)
                            .stroke(Color.black, lineWidth: 2)
                    )
                    .padding(.horizontal, 22)
                    .offset(y: -50)
                }
            }
            .navigationBarHidden(true)
        }
    }
}

struct ForgotPasswordView_Previews: PreviewProvider {
    static var previews: some View {
        ForgotPasswordView()
    }
}
