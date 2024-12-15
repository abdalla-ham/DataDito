package com.datadito.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VoltDBService voltDBService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private NotificationService notificationService;

    

    public void createCustomerAccount(Customer customer) {
        // Send MSISDN to Hazelcast for processing
        hazelcastInstance.getMap("msisdn").put(customer.getMsisdn(), "Processing");

        // Save customer in Oracle DB
        customerRepository.save(customer);
    }

    
}

