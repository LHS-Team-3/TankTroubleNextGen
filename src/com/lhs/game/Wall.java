package com.lhs.game;

import java.awt.geom.*;


public class Wall {
	
	public Rectangle2D bounds;
	public int x;
	public int y;
	public double w;
	public double h;
	
	public Wall(int x, int y, double w, double h) {
		
		bounds = new Rectangle2D.Double((double)x*1,(double)y*1,w*1,h*1);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}
	
	public int getRebound(double x, double y, int d) {
		
		int ans = d;
		int out = bounds.outcode(x,y);
		
		if (out==Rectangle2D.OUT_LEFT) ans = 360-d;
		if (out==Rectangle2D.OUT_BOTTOM) ans = d+90;
		if (out==Rectangle2D.OUT_RIGHT) ans = 360+d;
		if (out==Rectangle2D.OUT_TOP) ans = 360-d;
		 
		return ans;
		
	}
	
	public boolean intersects(double x, double y, int w, int h) {
		
		return bounds.intersects(x, y, w, h);
		
	}
	
}
