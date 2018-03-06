package com.ekino.trombihack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.ekino.trombihack"})
public class TrombihackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrombihackApplication.class, args);
	}
}
