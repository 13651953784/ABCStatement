package com.abcsh.exercise.statement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@MapperScan("com.abcsh.exercise.statement.mapper")
public class StatementApplication {

	public static void main(String[] args) {


		SpringApplication.run(StatementApplication.class, args);
	}

}
