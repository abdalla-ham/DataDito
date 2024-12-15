package com.datadito.apisignature;

import com.datadito.apisignature.ApiSignatureUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignatureController {

    @PostMapping("/verifySignature")
    public ResponseEntity<String> verifySignature(
            @RequestParam("payload") String payload,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("msisdn") String msisdn,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("tcNumber") String tcNumber,
            @RequestParam("packageName") String packageName,
            @RequestParam("clientSignature") String clientSignature) {
        
        String secretKey = "your-secret-key-here"; // This should be securely managed and not hard-coded

        boolean isSignatureValid = ApiSignatureUtil.verifySignature(
            secretKey, payload, timestamp, name, surname, msisdn, email, password, tcNumber, packageName, clientSignature
        );

        if (isSignatureValid) {
            return ResponseEntity.ok("Signature is valid.");
        } else {
            return ResponseEntity.badRequest().body("Invalid signature.");
        }
    }

    @GetMapping("/generateSignature")
    public ResponseEntity<String> generateSignature(
            @RequestParam("payload") String payload,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("msisdn") String msisdn,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("tcNumber") String tcNumber,
            @RequestParam("packageName") String packageName) {

        String secretKey = "your-secret-key-here"; // This should be securely managed and not hard-coded

        String signature = ApiSignatureUtil.generateSignature(
            secretKey, payload, timestamp, name, surname, msisdn, email, password, tcNumber, packageName
        );

        return ResponseEntity.ok(signature);
    }
}

