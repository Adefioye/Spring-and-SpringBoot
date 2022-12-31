package com.javakoko.learnspringframework.example.a4;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
	}
	
	// PostConstruct annotation is used to run a piece of code after initializing all dependencies of a class
	@PostConstruct
	public void initialize() {
		someDependency.doSomething();
	}
	
	//PreDestroy annotation is used to run a piece just before the bean is taken away from the context
	@PreDestroy
	public void cleanUp() {
		System.out.println("Cleaning up resources");
	}
}


@Component
class SomeDependency {

	public void doSomething() {
		System.out.println("Run after initializing dependencies!");
		
	}
	
	
}

@Configuration
@ComponentScan
public class PostConstructContextLauncherApplication {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(PostConstructContextLauncherApplication.class);
									
	// Print out bean definitions
	Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
	
	context.close();

	}

}
