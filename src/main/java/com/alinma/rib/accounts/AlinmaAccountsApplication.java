package com.alinma.rib.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alinma.rib")
public class AlinmaAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlinmaAccountsApplication.class, args);
    }

}
