package com.datadito.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class resetPassword {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VoltDBService voltDBService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private NotificationService notificationService;

    public void resetPassword(String email, String newPassword) {
        Customer customer = customerRepository.findByMsisdn(email);
        customer.setPassword(newPassword);
        customerRepository.save(customer);

        notificationService.sendPasswordResetNotification(email, newPassword);
    }
}
