package com.city.management.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages="com.city.management")
@MapperScan("com.**.mapper")
public class CollectionnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionnApplication.class, args);
	}

}
