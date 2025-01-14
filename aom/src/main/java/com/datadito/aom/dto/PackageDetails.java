package com.datadito.aom.dto;



import lombok.Builder;

@Builder
public record PackageDetails(
        String packageName,
        Integer amountMinutes,
        Integer amountSms,
        Integer amountData
) {
}