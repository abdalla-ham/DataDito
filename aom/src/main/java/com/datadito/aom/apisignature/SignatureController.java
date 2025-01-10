//package com.datadito.aom.apisignature;
//
//
//import com.datadito.aom.model.Customer;
//import com.datadito.aom.mock.RegisterData;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//
//@RestController
//@RequestMapping("/v1/api/auth")
//public class SignatureController {
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterData registerData) {
//        //take the user informations and send oracle, volt. Also take only msisdn and send it to hazelcast
//        return ResponseEntity.ok(saveuser(registerData));
//    }
//
//    public String saveuser(RegisterData registerData) {
//        String name = registerData.name();
//        String surname = registerData.surname();
//        String msisdn = registerData.msisdn();
//        String email = registerData.email();
//        String password = registerData.password();
//        String tcnumber = registerData.tcNumber();
//        String packagename = registerData.packageName();
//
//        Customer customer = new Customer(
//                1, msisdn, name, surname, email, password, tcnumber, new Date()
//        );
//        return ("customer saved " + customer );
//
//    }
//
////    @PostMapping("/register")
////    public ResponseEntity<String> verifySignature(
////            //@RequestParam("payload") String payload,
////            //@RequestParam("timestamp") String timestamp,
////            @RequestParam("name") String name,
////            @RequestParam("surname") String surname,
////            @RequestParam("msisdn") String msisdn,
////            @RequestParam("email") String email,
////            @RequestParam("password") String password,
////            @RequestParam("tcNumber") String tcNumber,
////            @RequestParam("packageName") String packageName
////            //@RequestParam("clientSignature") String clientSignature
////    ) {
////
//////        String secretKey = "your-secret-key-here"; // This should be securely managed and not hard-coded
////
//////        boolean isSignatureValid = ApiSignatureUtil.verifySignature(
//////            secretKey,
//////                payload, timestamp, name, surname, msisdn, email, password, tcNumber, packageName, clientSignature
//////        );
////
////        if (isSignatureValid) {
////            return ResponseEntity.ok("Signature is valid.");
////        } else {
////            return ResponseEntity.badRequest().body("Invalid signature.");
////        }
////    }
//
////    @GetMapping("/generateSignature")
////    public ResponseEntity<String> generateSignature(
////            @RequestParam("payload") String payload,
////            @RequestParam("timestamp") String timestamp,
////            @RequestParam("name") String name,
////            @RequestParam("surname") String surname,
////            @RequestParam("msisdn") String msisdn,
////            @RequestParam("email") String email,
////            @RequestParam("password") String password,
////            @RequestParam("tcNumber") String tcNumber,
////            @RequestParam("packageName") String packageName) {
////
////        String secretKey = "your-secret-key-here"; // This should be securely managed and not hard-coded
////
////        String signature = ApiSignatureUtil.generateSignature(
////            secretKey, payload, timestamp, name, surname, msisdn, email, password, tcNumber, packageName
////        );
////
////        return ResponseEntity.ok(signature);
////    }
//}
//
