package com.datadito.aom.mock;

import java.util.Date;

public record RegisterData (
        String name,
        String surname,
        String msisdn,
        String email,
        String password,
        String tcNumber,
        String packageName,
        Date sdate

){
}
