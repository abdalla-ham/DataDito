//package com.datadito.aom.apisignature;
//
//import com.datadito.aom.dto.PackageDto;
//import com.datadito.aom.model.Package;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/v1/api/packages")
//public class PackageController {
//    private static final Logger logger = LogManager.getLogger(PackageController.class);
//    @GetMapping("/getUserPackageByMsisdn")
//    public ResponseEntity<Package> getpackageuser(@RequestParam String msisdn) {
//        //get the msisdn and go to oracle db and fetch the package information which user uses.
//        Package pack = new Package(
//            1,
//            "name",
//            123.0,
//            100,
//            100,
//            100,
//            30
//        );
//        return ResponseEntity.ok(pack);
//    }
//
//    @GetMapping("/getPackageDetails")
//    public ResponseEntity<Package> getPackageDetails(@RequestParam String packageName) {
//        //get the package name and go to oracle and fetch the package information and put them in pack obj.
//        Package pack = new Package(
//                1,
//                packageName,
//                123.0,
//                100,
//                100,
//                100,
//                30
//        );
//        return ResponseEntity.ok(pack);
//    }
//    @GetMapping("/getAllPackages")
//    public ResponseEntity<List<PackageDto>> getAllPackages() {
//        logger.debug("Request is taken, returning dummy package list");
//
//        //remove this mock datas and fetch package details from oracle instead.
//        List<PackageDto> dummyPackages = List.of(
//                PackageDto.builder()
//                        .packageId(1)
//                        .packageName("Basic Package")
//                        .amountMinutes(100)
//                        .price(9.99)
//                        .amountData(1024)
//                        .amountSms(50)
//                        .period(30)
//                        .build(),
//                PackageDto.builder()
//                        .packageId(2)
//                        .packageName("Premium Package")
//                        .amountMinutes(500)
//                        .price(19.99)
//                        .amountData(5120)
//                        .amountSms(200)
//                        .period(30)
//                        .build()
//        );
//
//        return ResponseEntity.ok(dummyPackages);
//    }
//}
