package com.i2i.datadito;

import com.i2i.datadito.voltdb.InsertingTest;
import com.i2i.datadito.voltdb.VoltDbOperators;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChfLast2Application {
    public static void main(String[] args) {
        //InsertingTest.main(args);
        SpringApplication.run(ChfLast2Application.class, args);
    }
    @Bean
    public VoltDbOperators voltDbOperators() {return new VoltDbOperators();}}
