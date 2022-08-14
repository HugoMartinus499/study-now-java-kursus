package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hej")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/fizz")
	public String fizz(@RequestParam(value = "n", defaultValue = "3") int n,
			@RequestParam(value = "max", defaultValue = "100") int max) {
		String result = "";
		for (int i = 0; i < max; i++) {
			if (i % n == 0) {
				result += "Fizz";
			} else {
				result += i;
			}
			result += "<br>";
		}

		return result;
	}

}
