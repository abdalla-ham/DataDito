package org.datadito.tgf;

import com.i2i.datadito.hazelcast.HazelcastSimulatorOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/tgf")
public class TGFController {

    final private RandomTransactionGenerator randomTransactionGenerator;

    @Autowired
    public TGFController(RandomTransactionGenerator randomTransactionGenerator){
        this.randomTransactionGenerator = randomTransactionGenerator;
    }

    @GetMapping("/send-request") // This one will send it to other Endpoints InshaALLAH
    public String getSendRequest(){
        try{
            return randomTransactionGenerator.getRandomTGFTransaction();
        }catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/test-request")
    public String getTestRequest(){
        try{
            return randomTransactionGenerator.getRandomTGFTransaction();
        }catch (Exception exception){
            return null;
        }
    }

}
