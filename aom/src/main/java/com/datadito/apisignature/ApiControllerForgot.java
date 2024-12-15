package com.datadito.apisignature;

import com.datadito.apisignature.ApiSignatureUtilForgot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/forgetPassword")
public class ApiControllerForgot {

    @Value("${api.secret-key}")
    private String secretKey;

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        String tcNumber = requestData.get("TCNumber");

        try {
            String signature = ApiSignatureUtilForgot.generateSignature(secretKey, email, tcNumber);
            return ResponseEntity.ok().header("X-Signature", signature).body("Password reset request received successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to generate signature: " + e.getMessage());
        }
    }

    @PostMapping("/verifyReset")
    public ResponseEntity<String> verifyResetRequest(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        String tcNumber = requestData.get("TCNumber");
        String clientSignature = requestData.get("signature");

        boolean isValid = ApiSignatureUtilForgot.verifySignature(secretKey, email, tcNumber, clientSignature);
        if (isValid) {
            return ResponseEntity.ok("Signature verified successfully. Proceed with password reset.");
        } else {
            return ResponseEntity.badRequest().body("Invalid signature.");
        }
    }
}
