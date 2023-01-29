package com.rodrigofujioka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAppConfig.class, args);
    }


}