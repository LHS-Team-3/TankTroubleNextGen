package com.lhs.game;

import java.util.HashMap;

public class World {
	
	public HashMap<Actor, String> actors;
	public HashMap<Wall, String> walls;
	public int h;
	public int w;
	
	public World(int h, int w) {
		
		this.actors = new HashMap<Actor, String>();
		this.walls = new HashMap<Wall, String>();
		this.h = h;
		this.w = w;
		
		//TODO: Generate map
		
	}
	
}
