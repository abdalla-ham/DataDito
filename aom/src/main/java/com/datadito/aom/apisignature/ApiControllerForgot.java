//package com.datadito.aom.apisignature;
//
//import com.datadito.aom.apisignature.*;
//import com.datadito.aom.mock.ResetPassword;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/v1/api/forgetPassword")
//public class ApiControllerForgot {
//
//
//    @PostMapping("/reset")
//    public ResponseEntity<String> resetPassword(@RequestBody ResetPassword resetPassword) {
//        String email = resetPassword.email();
//        String tcNumber = resetPassword.tcNumber();
//        return ResponseEntity.ok("reset password successful for " + email + " " + tcNumber);

