package com.ekino.trombihack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot"})
public class TrombihackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrombihackApplication.class, args);
	}
}
