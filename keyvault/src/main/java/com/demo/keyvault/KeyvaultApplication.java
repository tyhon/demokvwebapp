package com.demo.keyvault;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@SpringBootApplication
public class KeyvaultApplication {

//	@Value("${vault-username}")
//	private String retrievedSecret;

	public static void main(String[] args) {
		SpringApplication.run(KeyvaultApplication.class, args);
	}

//	@GetMapping("get")
//	public String get() {
//		return retrievedSecret;
//	}
//
//	public void run(String... varl) throws Exception {
//
//		System.out.println(String.format("\nConnection String stored in Azure Key Vault:\n%s\n",retrievedSecret));
//	}

}
