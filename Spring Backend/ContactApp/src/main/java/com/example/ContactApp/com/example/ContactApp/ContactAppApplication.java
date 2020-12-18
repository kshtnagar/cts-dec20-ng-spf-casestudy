package com.example.ContactApp.com.example.ContactApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ContactAppApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ContactAppApplication.class, args);
		
	}

}
