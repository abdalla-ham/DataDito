//
//  RegisterView.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 11.01.2025.
//

import SwiftUI

struct RegisterView: View {
    @State private var name: String = ""
    @State private var surname: String = ""
    @State private var nationalID: String = ""
    @State private var phoneNumber: String = ""
    @State private var email: String = ""
    @State private var tariff: String = ""
    @State private var password: String = ""
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
                                TextField("Name:", text: $name)
                                TextField("Surname:", text: $surname)
                                TextField("National ID:", text: $nationalID)
                                TextField("Phone:", text: $phoneNumber)
                                TextField("Email:", text: $email)
                                TextField("Tariff:", text: $tariff)
                                SecureField("Password:", text: $password)
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

                        HStack(spacing: 20) {
                            Button(action: {
                                // Register function
                            }) {
                                Text("Register")
                                    .font(.headline)
                                    .foregroundColor(.white)
                                    .frame(maxWidth: .infinity)
                                    .padding()
                                    .background(Color.red)
                                    .cornerRadius(10)
                            }

                            Button(action: {
                                // GoBack function
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

struct RegisterView_Previews: PreviewProvider {
    static var previews: some View {
        RegisterView()
    }
}
