package jrJava.barbarianAttack3_linkedList;

import java.awt.Image;

public class RunningBarbarian extends Barbarian {

	public RunningBarbarian(Image[] images, int x, int y, int vx) {
		super(images, x, y, vx);
	}
	
	
	public void move() {
		x += vx;
		if(x>1100) Coordinator.gameOver = true;
	}
}
