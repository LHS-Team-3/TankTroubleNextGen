package com.lhs.game;

import javafx.scene.image.Image;

public class Tank extends Actor {
	
	public Bullet shot;
	public double x;
	public double y;
	public int direction; //0-359, describes direction in terms of degrees, straight up is 0, straight right is 90
	public Image image;
	
	//TODO: make actual tank class (must get input for movement)
	
	
	public Tank(Image image) {
		
		this.direction = 90;
		this.x = 0;
		this.y = 0;
		this.image = image;
		
	}
	
	public void move(double m) {
		
		double dX = 0;
		double dY = 0;
		if (direction>359) direction -= 360;
		System.out.println(direction);
		
		if (direction==0 || direction==180 ) dX = 0;
		else if (direction<=90) dX = Math.sin(Math.toRadians(direction));
		else if (direction<180) dX = Math.sin(Math.toRadians(direction-90));
		else if (direction<=270)dX = Math.sin(Math.toRadians(180-direction));
		else dX = -Math.sin(Math.toRadians(360-direction));
		
		if (direction==90 || direction==270 ) dY = 0;
		else if (direction<90) dY = Math.cos(Math.toRadians(direction));
		else if (direction<=180) dY = Math.cos(Math.toRadians(direction-90));
		else if (direction<270)dY = Math.cos(Math.toRadians(180-direction));
		else dY = -Math.cos(Math.toRadians(direction-360));
		
		if (canMove(m)) { x += m*dX; y += m*dY; }
		
	}
	
	public boolean canMove(double m) {
		
		return true; //TODO: make collision detector
		
	}
	
	public void tick() {
		
		//TODO: if corresponding keys are pressed, move
		
	}
	public Projectile fire(){
		Projectile bob = new Projectile("Bob",x, y);
		bob.direction = direction;
		bob.move(10);
		return bob;
	}
	
}
