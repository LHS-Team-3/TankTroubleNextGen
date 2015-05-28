package com.lhs.game;

public class Projectile extends Actor {
	
	public double x;
	public double y;
	public int w;
	public int h;
	public String name;
	public Bullet type;
	public int direction;
	
	public Projectile(String name, double x, double y) {
		
		this.name = name;
		this.x = x;
		this.y = y;
		
	}
	
	public void move(double m) {
		
		direction = rebound();
		
		m = type.speed;
		
		double dX = 0;
		double dY = 0;
		
		if (direction==0 || direction==180 ) dX = 0;
		else if (direction<=90) dX = Math.sin(Math.toRadians(direction));
		else if (direction<180) dX = Math.sin(Math.toRadians(direction-90));
		else if (direction<=270)dX = Math.sin(Math.toRadians(180-direction));
		else dX = Math.sin(Math.toRadians(270-direction));
		
		if (direction==90 || direction==270 ) dY = 0;
		else if (direction<90) dY = Math.cos(Math.toRadians(direction));
		else if (direction<=180) dY = Math.cos(Math.toRadians(direction-90));
		else if (direction<270)dY = Math.cos(Math.toRadians(180-direction));
		else dY = Math.cos(Math.toRadians(270-direction));
		
		x += m*dX; y += m*dY;
		
	}
	
	public int rebound() {
		
		//TODO: if colliding, find surface and get angle of rebound
		
		return direction;
		
	}
	
	public void tick() {
		
		move(1);
		
	}
	
}
