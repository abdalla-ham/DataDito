//package com.datadito.apisignature;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class ApiSignatureUtil {
//
//    private static final String HMAC_SHA256 = "HmacSHA256";
//
//    // Generate API Signature
//    public static String generateSignature(String secretKey, String payload, String timestamp, String name, String surname, String msisdn, String email, String password, String tcNumber, String packageName) {
//        try {
//            // Construct the data to be signed
//            StringBuilder dataBuilder = new StringBuilder();
//            dataBuilder.append(payload)
//                       .append(timestamp)
//                       .append(name)
//                       .append(surname)
//                       .append(msisdn)
//                       .append(email)
//                       .append(password)
//                       .append(tcNumber)
//                       .append(packageName);
//            String dataToSign = dataBuilder.toString();
//
//            // Create HMAC-SHA256 instance
//            Mac mac = Mac.getInstance(HMAC_SHA256);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
//            mac.init(secretKeySpec);
//
//            // Generate HMAC
//            byte[] hmacBytes = mac.doFinal(dataToSign.getBytes(StandardCharsets.UTF_8));
//            return Base64.getEncoder().encodeToString(hmacBytes); // Encode to Base64
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating API signature", e);
//        }
//    }
//
//    // Verify API Signature
//    public static boolean verifySignature(String secretKey, String payload, String timestamp, String name, String surname, String msisdn, String email, String password, String tcNumber, String packageName, String clientSignature) {
//        String serverGeneratedSignature = generateSignature(secretKey, payload, timestamp, name, surname, msisdn, email, password, tcNumber, packageName);
//        return serverGeneratedSignature.equals(clientSignature);
//    }
//
//}
