package com.javakoko.learnspringframework.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	
//	@Autowired
	Dependency1 dependency1;
	
//	@Autowired
	Dependency2 dependency2;
	
	// Constructor dependency is automatically used for dependency without @Autowired annotation
	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor dependency ----)");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	
	
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter dependency - dependency #1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter dependency - dependency #2");
//		this.dependency2 = dependency2;
//	}





	public String toString() {
		return "You have " + dependency1 + " and " + dependency2;
	}

}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}



@Configuration
@ComponentScan
public class DepInjectionApplicationLauncher {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(DepInjectionApplicationLauncher.class);
	
	// Print out bean definitions
	Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
	
	System.out.println(context.getBean(YourBusinessClass.class));
	
	context.close();

	}

}
