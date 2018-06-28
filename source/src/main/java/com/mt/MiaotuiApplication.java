package com.mt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mt.mapper")
public class MiaotuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaotuiApplication.class, args);
	}
}
