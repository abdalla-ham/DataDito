//package com.datadito.aom.apisignature;
//
//
//import com.datadito.aom.mock.LoginData;
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
//@RequestMapping("/v1/api/auth")
//public class ApiControllerLogin {
//
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginData loginData) {
//        String msisdn = loginData.msisdn();
//        String password = loginData.password();
//        // take msisdn and password and send it to oracldb to check if the user exists or not.
//        try {
////            String signature = ApiSignatureUtilLogin.generateSignature(secretKey, msisdn, password);
//            return ResponseEntity.ok().body("Login successful" + msisdn + ":" + password);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Failed to generate signature: " + e.getMessage());
//        }
//    }
//
////    @PostMapping("/register")
////    public ResponseEntity<String> register(@RequestBody LoginData loginData) {
////        String msisdn = loginData.msisdn();
////        String password = loginData.password();
////        // take msisdn and password and send it to oracldb to check if the user exists or not.
////        try {
//////            String signature = ApiSignatureUtilLogin.generateSignature(secretKey, msisdn, password);
////            return ResponseEntity.ok("saved");
////        } catch (Exception e) {
////            return ResponseEntity.internalServerError().body("Failed to generate signature: " + e.getMessage());
////        }
////    }
//
////    @PostMapping("/verifyLogin")
////    public ResponseEntity<String> verifyLogin(@RequestBody Map<String, String> loginData) {
////        String msisdn = loginData.get("msisdn");
////        String password = loginData.get("password");
////        String clientSignature = loginData.get("signature");
////
////        boolean isValid = ApiSignatureUtilLogin.verifySignature(secretKey, msisdn, password, clientSignature);
////        if (isValid) {
////            return ResponseEntity.ok("Signature verified successfully.");
////        } else {
////            return ResponseEntity.badRequest().body("Invalid signature.");
////        }
////    }
//
//}
//
