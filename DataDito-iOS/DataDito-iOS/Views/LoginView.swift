//
//  LoginView.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 9.12.2024.
//

import SwiftUI

struct LoginView: View {
    @State private var phoneNumber: String = ""
    @State private var password: String = ""
    @State private var rememberMe: Bool = false

    var body: some View {
        NavigationView {
            ZStack {
                Color.pink.opacity(0.1)
                    .ignoresSafeArea()

                VStack(spacing: 20) {
                    VStack {
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
                    .padding(.top, 50)

                    Image("Logo-3-2")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 80, height: 100)
                        .zIndex(10)

                    VStack {
                        VStack(spacing: 20) {
                            TextField("Phone Number", text: $phoneNumber)
                                .padding()
                                .background(Color.white)
                                .cornerRadius(10)
                                .overlay(
                                    RoundedRectangle(cornerRadius: 10)
                                        .stroke(Color.black, lineWidth: 1)
                                )
                                .padding(.horizontal, 40)

                            SecureField("Password", text: $password)
                                .padding()
                                .background(Color.white)
                                .cornerRadius(10)
                                .overlay(
                                    RoundedRectangle(cornerRadius: 10)
                                        .stroke(Color.black, lineWidth: 1)
                                )
                                .padding(.horizontal, 40)
                                .padding(.top, 20)

                            HStack {
                                Toggle("Remember me", isOn: $rememberMe)
                                    .labelsHidden()
                                Text("Remember me")
                                    .font(.body)
                            }
                        }
                        .padding(.bottom, 20)
                        .padding(.top, 80)

                        VStack(spacing: 10) {
                            NavigationLink(destination: ForgotPasswordView()) {
                                Text("Forgot Password")
                                    .foregroundStyle(.black)
                                    .frame(width: 150)
                                    .font(.body)
                                    .padding(.vertical, 5)
                                    .padding(.horizontal, 20)
                                    .overlay(
                                        RoundedRectangle(cornerRadius: 10)
                                            .stroke(Color.black, lineWidth: 1)
                                    )
                            }

                            NavigationLink(destination: RegisterView()) {
                                Text("Register")
                                    .foregroundStyle(.black)
                                    .frame(width: 150)
                                    .font(.body)
                                    .padding(.vertical, 5)
                                    .padding(.horizontal, 20)
                                    .overlay(
                                        RoundedRectangle(cornerRadius: 10)
                                            .stroke(Color.black, lineWidth: 1)
                                    )
                            }

                            NavigationLink(destination: RemainingUsageView()) {
                                Text("Login")
                                    .font(.body)
                                    .foregroundColor(.white)
                                    .frame(maxWidth: .infinity)
                                    .padding()
                                    .background(Color.red)
                                    .cornerRadius(10)
                            }
                            .padding(.horizontal, 40)
                            .padding(.top, 20)
                            .padding(.bottom, 50)
                        }
                    }
                    .background(Color.white)
                    .cornerRadius(35)
                    .overlay(
                        RoundedRectangle(cornerRadius: 35)
                            .stroke(Color.black, lineWidth: 2)
                    )
                    .padding(.horizontal, 25)
                    .offset(y: -70)
                }
            }
            .navigationBarHidden(true)
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
