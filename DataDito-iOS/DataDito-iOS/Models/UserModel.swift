//
//  UserModel.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 11.01.2025.
//

struct UserModel: Codable {
    let name: String
    let surname: String
    let nationalID: Int 
    let phoneNumber: String
    let email: String
    let tariff: String
    let password: String
}
