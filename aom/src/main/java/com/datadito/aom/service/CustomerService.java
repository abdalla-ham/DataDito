package com.datadito.aom.service;



import com.datadito.aom.dto.CustomerDto;
import com.datadito.aom.mapper.CustomerMapper;
import com.datadito.aom.repository.CustomerRepository;
import com.i2i.datadito.voltdb.VoltCustomer;
import com.i2i.datadito.voltdb.VoltDbOperators;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.voltdb.client.ProcCallException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final VoltDbOperators voltdbOperator = new VoltDbOperators();
    private static final Logger logger = LogManager.getLogger(CustomerService.class);

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    /**
     * This method is used to get a customer by msisdn
     * @param msisdn
     * @return CustomerDto
     * @throws IOException
     * @throws InterruptedException
     * @throws ProcCallException
     */
    public CustomerDto getCustomerByMsisdn(String msisdn) throws IOException, InterruptedException, ProcCallException {
        logger.debug("Getting customer by MSISDN: " + msisdn);
        VoltCustomer voltCustomer = voltdbOperator.getCustomerByMsisdn(msisdn)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        logger.debug("Customer found by MSISDN: " + msisdn);
        return customerMapper.voltCustomerBalanceToCustomerDto(voltCustomer);
    }

    /**
     * This method is used to get all customers
     * @return List<CustomerDto>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<CustomerDto> getAllCustomers() throws SQLException, ClassNotFoundException {
        logger.debug("Getting all customers");
        return customerRepository.getAllCustomers()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }
}