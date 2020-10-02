package com.codegym.cms;

import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.impl.SimpleCustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

//	@Bean
//	public CustomerService customerService(){
//		return new SimpleCustomerServiceImpl();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
