package com.lhs.game;

import java.util.*;

public class World {
	
	public ArrayList<Actor> actors;
	public ArrayList<Wall> walls;
	public int h;
	public int w;
	
	public World(int h, int w) {
		
		this.actors = new ArrayList<Actor>();
		this.walls = new ArrayList<Wall>();
		this.h = h;
		this.w = w;
		
		//generate map
		MazeGenerator gen = new MazeGenerator(h,w);
		gen.display();
		walls = gen.walls;
		
	}
	
	public void tick() {
		
		for (int i = 0; i<walls.size(); i++) {
			Wall w = walls.get(i);
			for (int j = 0; j<actors.size(); j++) {
				if (actors.get(j) instanceof Projectile) {
					Projectile p = (Projectile)actors.get(j);
					if (w.intersects(p.x,p.y,p.w,p.h)) p.direction = w.getRebound(p.x, p.y, p.direction);
					actors.add(j, p);
				}
			}
		}
		
		for (int i = 0; i<actors.size(); i++) { Actor a = actors.get(i); a.move(1); actors.add(i, a); }
		
	}
	
}
