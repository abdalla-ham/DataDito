package com.i2i.datadito.voltdb;


public record VoltPackageDetails(
        int period,
        int amountMinutes,
        int amountSms,
        int amountData
) {
    @Override
    public int period() {
        return period;
    }

    @Override
    public int amountMinutes() {
        return amountMinutes;
    }

    @Override
    public int amountSms() {
        return amountSms;
    }

    @Override
    public int amountData() {
        return amountData;
    }
}
