package com.javakoko.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.javakoko.learnspringframework.game")
public class GamingApplicationLauncher {

	public static void main(String[] args) {
		
	var context = new AnnotationConfigApplicationContext(GamingApplicationLauncher.class);
									
	context.getBean(GameConsole.class).up();
	
	context.getBean(GameRunner.class).run();
	
	context.close();

	}

}
