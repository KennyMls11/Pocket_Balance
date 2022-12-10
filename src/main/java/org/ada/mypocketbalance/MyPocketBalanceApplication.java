package org.ada.mypocketbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class MyPocketBalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPocketBalanceApplication.class, args);
	}

}
