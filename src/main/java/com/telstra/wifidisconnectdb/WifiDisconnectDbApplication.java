package com.telstra.wifidisconnectdb;

import com.telstra.wifidisconnectdb.dao.WifiDisconnect;
import com.telstra.wifidisconnectdb.repository.WifiDisconnectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WifiDisconnectDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WifiDisconnectDbApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(WifiDisconnectRepository wifiDisconnectRepository){
//		return args -> {
//			WifiDisconnect wd = new WifiDisconnect(
//					3,
//					"DELETE",
//					"1",
//					"1",
//					"1",
//					"wifi_dc",
//					"123",
//					"123",
//					"123",
//					"213"
//			);
//			wifiDisconnectRepository.save(wd);
//		};
//	}
}
