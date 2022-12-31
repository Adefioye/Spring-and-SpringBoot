package com.javakoko.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GameConsole {

	public void up() {
		System.out.println("up up");
	}

	public void down() {
		System.out.println("Going down");
	}
	
	public void left() {
		System.out.println("Go left");
	}
	
	public void right() {
		System.out.println("Go right");
	}
}
