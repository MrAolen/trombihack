package com.ekino.trombihack;

import com.ekino.trombihack.user.User;
import com.ekino.trombihack.userService.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.ekino.trombihack.bot"})
public class TrombihackApplication {
	public static void main(String[] args) {

		UserService.run();

		User test = UserService.searchByUsername("Ruben");

		SpringApplication.run(TrombihackApplication.class, args);
	}
}
