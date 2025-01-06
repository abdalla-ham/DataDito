package org.datadito.tgf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RandomTransactionGenerator getHazelcastTGFOperation() {
        return new RandomTransactionGenerator();
    }
}
