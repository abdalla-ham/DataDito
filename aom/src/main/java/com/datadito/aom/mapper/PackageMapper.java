package com.datadito.aom.mapper;


import com.datadito.aom.dto.PackageDto;
import com.datadito.aom.model.Package;
import com.i2i.datadito.voltdb.VoltPackage;
import org.springframework.stereotype.Component;

@Component
public class PackageMapper {

    public PackageDto voltPackageToPackageDto(VoltPackage packageModel){
        return PackageDto.builder()
                .packageId(packageModel.getPackageId())
                .packageName(packageModel.getPackageName())
                .amountMinutes(packageModel.getAmountMinutes())
                .price(packageModel.getPrice())
                .amountData(packageModel.getAmountData())
                .amountSms(packageModel.getAmountSms())
                .period(packageModel.getPeriod())
                .build();
    }

    public PackageDto packageToPackageDto(Package packageModel){
        return PackageDto.builder()
                .packageId(packageModel.getPackageId())
                .packageName(packageModel.getPackageName())
                .amountMinutes(packageModel.getAmountMinutes())
                .price(packageModel.getPrice())
                .amountData(packageModel.getAmountData())
                .amountSms(packageModel.getAmountSms())
                .period(packageModel.getPeriod())
                .build();
    }

}