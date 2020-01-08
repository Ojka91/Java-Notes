package com.servlets.servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@ServletComponentScan /*will scan Servlets annotated with @WebServlet, Filters annotated with @WebFilter
 					and Listeners annotated with @WebListener*/
@SpringBootApplication
public class ServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletsApplication.class, args);
	}


}
