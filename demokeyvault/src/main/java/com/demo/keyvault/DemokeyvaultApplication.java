package com.demo.keyvault;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
public class DemokeyvaultApplication {
//	@Value("${vault-password}")
//	private String retrievedSecret;

	public static void main(String[] args) {
//		String keyVaultUri = "https://demoazure.vault.azure.net/";



		SpringApplication.run(DemokeyvaultApplication.class, args);
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
