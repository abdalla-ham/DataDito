package com.datadito.aom.controller;

import com.datadito.aom.service.BalanceService;
import com.i2i.datadito.voltdb.VoltCustomerBalance;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.voltdb.client.ProcCallException;

import java.io.IOException;


/**
 * Controller class for Balance related operations
 */
@RestController
@RequestMapping("/v1/api/balance")
public class BalanceController {

    private final BalanceService balanceService;
    private static final Logger logger = LogManager.getLogger(BalanceController.class);

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/remainingBalance")
    public ResponseEntity<VoltCustomerBalance> getRemainingCustomerBalanceByMsisdn(@RequestParam String msisdn) throws IOException, InterruptedException, ProcCallException {
        logger.debug("Request is taken, getting remaining customer balance for MSISDN: " + msisdn);
        return ResponseEntity.ok(balanceService.getRemainingCustomerBalance(msisdn));
    }
}