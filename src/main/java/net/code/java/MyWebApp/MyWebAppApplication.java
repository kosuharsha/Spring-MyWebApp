package net.code.java.MyWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class MyWebAppApplication {

	@RequestMapping("/")
	String home() {
		return "<html><body><h1>Hellow World Spring Boot!</h1></body></html>";
	}
	
	@RequestMapping("/new")
	String newForm()
	{
		return "<h2>Create a New Thing</h2>";
	}
	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}

}
