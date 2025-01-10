package com.datadito.aom.mapper;



import com.datadito.aom.dto.CustomerDto;
import com.datadito.aom.model.Customer;
import com.i2i.datadito.voltdb.VoltCustomer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto customerToCustomerDto(Customer customer){
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .msisdn(customer.getMsisdn())
                .sDate(customer.getsDate())
                .TCNumber(customer.getTCNumber())
                .build();
    }

    public CustomerDto voltCustomerBalanceToCustomerDto(VoltCustomer voltCustomer){
        return CustomerDto.builder()
                .customerId(voltCustomer.getCustomerId())
                .name(voltCustomer.getName())
                .surname(voltCustomer.getSurname())
                .email(voltCustomer.getEmail())
                .msisdn(voltCustomer.getMsisdn())
                .sDate(voltCustomer.getsDate())
                .TCNumber(voltCustomer.getTCNumber())
                .build();
    }
}