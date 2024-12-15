package com.datadito.apisignature;

import com.datadito.apisignature.ApiSignatureUtilLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/auth")
public class ApiControllerLogin {

    @Value("${api.secret-key}")
    private String secretKey;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String msisdn = loginData.get("msisdn");
        String password = loginData.get("password");

        try {
            String signature = ApiSignatureUtilLogin.generateSignature(secretKey, msisdn, password);
            return ResponseEntity.ok().header("X-Signature", signature).body("Login successful");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to generate signature: " + e.getMessage());
        }
    }

    @PostMapping("/verifyLogin")
    public ResponseEntity<String> verifyLogin(@RequestBody Map<String, String> loginData) {
        String msisdn = loginData.get("msisdn");
        String password = loginData.get("password");
        String clientSignature = loginData.get("signature");

        boolean isValid = ApiSignatureUtilLogin.verifySignature(secretKey, msisdn, password, clientSignature);
        if (isValid) {
            return ResponseEntity.ok("Signature verified successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid signature.");
        }
    }
}
