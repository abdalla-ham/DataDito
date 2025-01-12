//
//  UserViewModel.swift
//  DataDito-iOS
//
//  Created by Ahmet Purtuloğlu on 11.01.2025.
//

import Foundation
import Combine

class UserViewModel: ObservableObject {
    
    @Published var user: UserModel?
    
    private var cancellables = Set<AnyCancellable>()
    
    private let dataService = UserDataServices()
    
    init() {
        addSubscribers()
    }
    
    func addSubscribers() {
       // dataService.$willFavoritesCampaigns
         //   .sink { [weak self] willFavoritesCampaigns in
           //     self?.willFavoritesCampaigns = willFavoritesCampaigns
             //   self?.fetchFavoriteCampaignDetails()
            //}
            //.store(in: &cancellables)
    }
}
