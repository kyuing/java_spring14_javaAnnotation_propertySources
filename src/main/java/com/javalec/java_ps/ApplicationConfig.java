package com.javalec.java_ps;

import org.springframework.beans.factory.annotation.Configurable;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//@Configuration	this does not work
@Configurable

public class ApplicationConfig {
	
	//@Value references an external variable that has its value in a resource location.
	//this referencing process works like a setter.
	@Value("${admin.id}")	//parameter
	private String adminId;		//set value
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String subAdminId;
	@Value("${sub_admin.pw}")
	private String subAdminPw;
	
	@Bean
	//The same as <context:property-placeholder location = "classpath:admin.properties, classpath:sub_admin.properties"/> in xml
	public static PropertySourcesPlaceholderConfigurer Properties() {
		
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;	//this returns the external location setting values
	}
	
	@Bean				//AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
	public AdminConnection adminConfig() {
		
		//adminConnection: a new instance of AdminConnection.
		AdminConnection adminConnection = new AdminConnection();
		
		//the properties are ready to work with setters.  
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSubAdminId(subAdminId);
		adminConnection.setSubAdminPw(subAdminPw);
		
		return adminConnection; //By returning the instance adminConnection, the method adminConfig is ready to be used as an ID.
	}

}
