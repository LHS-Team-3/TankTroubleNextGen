package com.lhs.game;

public abstract class Actor {
	
	public int direction;
	public abstract void tick();
	public abstract void move(double m);
	
}