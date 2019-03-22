package com.city.management.collection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.city.management.collection.mapper")
public class CollectionnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionnApplication.class, args);
	}

}
