package com.kms.self203.backend203self;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;

@SpringBootApplication
public class Backend203SelfApplication {

	private static final Logger logger = LogManager.getLogger(Backend203SelfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Backend203SelfApplication.class, args);
		logger.info("Application Start");
		logger.trace("Application Start");
		logger.error("Application Start");
	}
}
