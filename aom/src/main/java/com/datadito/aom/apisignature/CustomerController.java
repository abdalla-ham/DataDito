//package com.datadito.aom.apisignature;
//
//import com.datadito.aom.model.Customer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@RestController
//@RequestMapping("/v1/api/customer")
//public class CustomerController {
//
//    @GetMapping("/getCustomerByMsisdn")
//    public ResponseEntity<Customer> getcustomer(@RequestParam String msisdn){
//        //go to oracle db with coming msisdn value and get the user informations
//        Customer customer = new Customer(
//                1,
//                "1234",
//                "name",
//                "surname",
//                "email@test.com",
//                "12345",
//                "1233444444",
//                new Date()
//        );
//
//        return ResponseEntity.ok(customer);
//    }
//}
