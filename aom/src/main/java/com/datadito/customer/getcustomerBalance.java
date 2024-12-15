package com.datadito.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class getcustomerBalance {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VoltDBService voltDBService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private NotificationService notificationService;

    public double getCustomerBalance(String msisdn) {
        return voltDBService.getCustomerBalance(msisdn);
    }
}
