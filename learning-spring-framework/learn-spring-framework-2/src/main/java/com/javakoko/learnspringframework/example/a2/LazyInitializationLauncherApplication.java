package com.javakoko.learnspringframework.example.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		// Some logic
		System.out.println("Some Initialization Logic...");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do something!");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);
									
	// Print out bean definitions
//	Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
	
	System.out.println("Context has completed initialization..........");
	
	context.getBean(ClassB.class).doSomething();
	
	context.close();

	}

}
