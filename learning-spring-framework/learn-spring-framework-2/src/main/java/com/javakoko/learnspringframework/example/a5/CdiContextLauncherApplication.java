package com.javakoko.learnspringframework.example.a5;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


// CDI is implemented in Spring, It has corresponding Spring implementation
// CDI                 -->      Spring
// @Component 	--> @Named
// @Autowired		--> @Inject


//@Component
@Named
class BusinessServices {
	
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}
	
//	@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter injection performed...");
		this.dataService = dataService;
	}
	
	
}

//@Component
@Named
class DataService {
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class);
									
	// Print out bean definitions
	Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
	
	context.close();

	}

}
