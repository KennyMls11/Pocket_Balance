package org.ada.mypocketbalance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MyPocketBalanceApplication {

	private static Logger logger= LoggerFactory.getLogger(MyPocketBalanceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyPocketBalanceApplication.class, args);

			logger.debug("Debug log message");
			logger.info("Info log message");
			logger.warn("Warn log message");
		    logger.error("Error log message");
		}


	}


