package com._520it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan("com._520it.mapper")
public class HistoryplatformAdminserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryplatformAdminserverApplication.class, args);
	}

}
