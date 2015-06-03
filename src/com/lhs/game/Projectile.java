package com.lhs.game;

import javafx.scene.image.Image;

public class Projectile extends Actor {
	
	public double x;
	public double y;
	public int w;
	public int h;
	public String name;
	public Bullet type;
	public int direction;
	public Image image;
	public int life;
	
	public Projectile(String name, double x, double y) {
		
		this.name = name;
		this.x = x;
		this.y = y;
		this.w = 10;
		this.h = 10;
		this.image = new Image("/com/lhs/resource/bullet.png");
		this.type = new Bullet();
		this.life = 0;
		
	}
	
	public void move(double m) {
		
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
	
	public void tick() {
		
		move(type.speed);
		//if (life==1000) this.
		
	}
	
}
