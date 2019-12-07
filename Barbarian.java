package jrJava.barbarianAttack3_linkedList;

import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Barbarian {

	protected int x, y;
	protected int vx;
	protected Image[] images; 
	protected int width, height;
	protected int drawCount; 
	protected static int drawCycle = 6;
	
	
	public Barbarian(Image[] images, int x, int y, int vx) {
		this.images = images;
		this.x = x;
		this.y = y;
		this.vx = vx;
		
		width = images[0].getWidth(null);
		height = images[0].getHeight(null);
	}
	
	
	public abstract void move();
	
	public void draw(Graphics2D g) {
		//if(drawCount%drawCycle<drawCycle/2) g.drawImage(images[0], x, y, null);
		//else g.drawImage(images[1], x, y, null);
		g.drawImage(images[drawCount%drawCycle<drawCycle/2? 0:1], x, y, null);
		drawCount++;
	}
	
	
	public boolean isHit(Arrow arrow) {
		double ax = arrow.getX();
		double ay = arrow.getY();
		return ax>=x+width/4 && ax<=x+width*3/4 && ay>=y+height/4 && ay<=y+height*3/4;
	}
	
}











