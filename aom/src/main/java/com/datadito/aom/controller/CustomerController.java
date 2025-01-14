package com.datadito.aom.controller;


import com.datadito.aom.dto.CustomerDto;
import com.datadito.aom.service.CustomerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.voltdb.client.ProcCallException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Controller class for Customer related operations
 */
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomerByMsisdn")
    public ResponseEntity<CustomerDto> getCustomerByMsisdn(@RequestParam String msisdn) throws IOException, InterruptedException, ProcCallException {
        logger.debug("Request is taken, getting customer by MSISDN: " + msisdn);
        return ResponseEntity.ok(customerService.getCustomerByMsisdn(msisdn));
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() throws SQLException, ClassNotFoundException {
        logger.debug("Request is taken, getting all customers");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}

