package com.Decroly.Mange_Bandas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;



@SpringBootApplication
@ConfigurationPropertiesScan
public class MangeBandasApplication {

	//http://localhost:8080/v3/api-docs
	//http://localhost:8080/swagger-ui/index.html

	public static void main(String[] args) {
		SpringApplication.run(MangeBandasApplication.class, args);
	}

}
