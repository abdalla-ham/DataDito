//package com.datadito.apisignature;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Map;
//
//public class ApiSignatureUtilForgot {
//
//    private static final String HMAC_SHA256 = "HmacSHA256";
//
//    // Generate API Signature for password reset
//    public static String generateSignature(String secretKey, String email, String tcNumber) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String payload = mapper.writeValueAsString(Map.of("email", email, "TCNumber", tcNumber));
//
//            // Create HMAC-SHA256 instance
//            Mac mac = Mac.getInstance(HMAC_SHA256);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
//            mac.init(secretKeySpec);
//
//            // Generate HMAC
//            byte[] hmacBytes = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
//            return Base64.getEncoder().encodeToString(hmacBytes); // Encode to Base64
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating API signature", e);
//        }
//    }
//
//    // Verify API Signature for password reset
//    public static boolean verifySignature(String secretKey, String email, String tcNumber, String clientSignature) {
//        String serverGeneratedSignature = generateSignature(secretKey, email, tcNumber);
//        return serverGeneratedSignature.equals(clientSignature);
//    }
//}
