package com.javakoko.learnspringframework.example.a3;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	
}

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);
									
	// Print out bean definitions
//	Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
//	
	
	System.out.println("Instantiation of normal singleton class...");
	System.out.println(context.getBean(NormalClass.class));
	System.out.println(context.getBean(NormalClass.class));
	System.out.println(context.getBean(NormalClass.class));
	
	
	System.out.println("Instantiation of prototype class...");
	System.out.println(context.getBean(PrototypeClass.class));
	System.out.println(context.getBean(PrototypeClass.class));
	System.out.println(context.getBean(PrototypeClass.class));
	System.out.println(context.getBean(PrototypeClass.class));
	
	context.close();
	
	}

}
