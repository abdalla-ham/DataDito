package com.datadito.aom.controller;


import com.datadito.aom.request.ForgetPasswordRequest;
import com.datadito.aom.service.ForgetPasswordService;
import jakarta.validation.Valid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for ForgetPassword related operations
 */
@RestController
@RequestMapping("/v1/api/forgetPassword")
public class ForgetPasswordController {

    private final ForgetPasswordService forgetPasswordService;
    private static final Logger logger = LogManager.getLogger(ForgetPasswordController.class);

    public ForgetPasswordController(ForgetPasswordService forgetPasswordService) {
        this.forgetPasswordService = forgetPasswordService;
    }

    @PostMapping("/reset")
    public ResponseEntity<ResponseEntity<String>> resetPassword(@Valid @RequestBody ForgetPasswordRequest forgetPasswordRequest) {
        logger.debug("Request is taken, resetting password for email: " + forgetPasswordRequest.email());
        return ResponseEntity.ok(forgetPasswordService.forgetPassword(forgetPasswordRequest));
    }
}