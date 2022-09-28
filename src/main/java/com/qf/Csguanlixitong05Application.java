package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qf.mapper")
@SpringBootApplication
public class Csguanlixitong05Application {

	public static void main(String[] args) {
		SpringApplication.run(Csguanlixitong05Application.class, args);
	}

}
