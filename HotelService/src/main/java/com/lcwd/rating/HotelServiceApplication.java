package com.lcwd.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelServiceApplication {

	public static void main(String[] args) {
		System.out.println("controller");
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}

//https://github.com/mapstruct/mapstruct/issues/1270 - for resolving java: cannot find symbol symbol: method setId(java.lang.String) added lombok also