package com.javalec.java_ps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//java annotation
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);	//container		
		
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		
		/* In ApplicationConfig.java,
		 we have two bean annotations with ID; Properties and adminConfig
		 we use adminConfig only in this step ctx.getBean()
		 */
		
		
		System.out.println();
		System.out.println("admin ID: " + connection.getAdminId());
		System.out.println("admin PASSWORD: " + connection.getAdminPw());
		System.out.println("sub-admin ID: " + connection.getSubAdminId());
		System.out.println("sub-admin PASSWORD: " + connection.getSubAdminPw());
		
		ctx.close();
	}

}
