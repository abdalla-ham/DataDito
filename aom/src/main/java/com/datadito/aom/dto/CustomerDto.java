package com.datadito.aom.dto;



import lombok.Builder;

import java.util.Date;

@Builder
public record CustomerDto(
        Integer customerId,
        String msisdn,
        String name,
        String surname,
        String email,
        String TCNumber,
        Date sDate
) { }