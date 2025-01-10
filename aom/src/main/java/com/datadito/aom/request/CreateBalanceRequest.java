package com.datadito.aom.request;



import lombok.Builder;

@Builder
public record CreateBalanceRequest(
        Integer balanceId,
        Integer customerId,
        Integer packageId
) { }