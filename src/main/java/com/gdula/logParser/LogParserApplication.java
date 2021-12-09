package com.gdula.logParser;

import com.gdula.logParser.controller.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogParserApplication.class, args);
		AppController appController = new AppController();
		appController.run();


	}

}
