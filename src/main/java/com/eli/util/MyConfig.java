package com.eli.util;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eli")
public class MyConfig {
//bean definition--methods which creates objects of the 
	//also annotated with @Bean
	@Bean(name ="scanner")
	public Scanner getScanner() {
	 return new Scanner(System.in);	
	}
	
	@Bean
	public EntityManagerFactory getEMF() {
		return Persistence.createEntityManagerFactory("vikas");
	}
	
	@Bean
	public EntityManager getEM() {
		return getEMF().createEntityManager();
	}
	@Bean
	public EntityTransaction getET() {
		return getEM().getTransaction();
	}
}
