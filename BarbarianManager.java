package jrJava.barbarianAttack3_linkedList;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BarbarianManager {

	private static MyArrayList<Barbarian> barbarians;
	// private static LinkedList<Barbarian> barbarians;
	private static Image[][] imagePairs;
	
	static {
		barbarians = new MyArrayList<Barbarian>();
		
		imagePairs = new Image[6][];
		for(int i=0; i<imagePairs.length; i++) imagePairs[i] = new Image[2];
		
		imagePairs[0][0] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot1_image1.png").getImage();
		imagePairs[0][1] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot1_image2.png").getImage();
		imagePairs[1][0] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot2_image1.png").getImage();
		imagePairs[1][1] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot2_image2.png").getImage();
		imagePairs[2][0] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot3_image1.png").getImage();
		imagePairs[2][1] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot3_image2.png").getImage();
		imagePairs[3][0] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot4_image1.png").getImage();
		imagePairs[3][1] = new ImageIcon(Coordinator.R_PATH + "barbarian_robot4_image2.png").getImage();
		
		imagePairs[4][0] = new ImageIcon(Coordinator.R_PATH + "dragon1_image1.png").getImage();
		imagePairs[4][1] = new ImageIcon(Coordinator.R_PATH + "dragon1_image2.png").getImage();
		imagePairs[5][0] = new ImageIcon(Coordinator.R_PATH + "dragon2_image1.png").getImage();
		imagePairs[5][1] = new ImageIcon(Coordinator.R_PATH + "dragon2_image2.png").getImage();
	}
	
	
	private static void launchBarbarian() {
		if(Math.random()>0.05) return;

		if(Math.random()>0.333) {
			barbarians.add(new RunningBarbarian(imagePairs[(int)(Math.random()*4)], 
					                            -imagePairs[0][0].getWidth(null), 600, 
					                            (int)(Math.random()*4 + 1)));
		}
		else {
			barbarians.add(new FlyingBarbarian(imagePairs[(int)(Math.random()*2)+4], 
					                            -imagePairs[5][0].getWidth(null), 
					                            (int)(Math.random()*400 + 100), 
					                            (int)(Math.random()*5 + 2), 50));
		}
	}
	
	
	public static void move() {
		launchBarbarian();
		for(int i=0; i<barbarians.size(); i++) barbarians.get(i).move();
	}
	
	public static void draw(Graphics2D g) {
		for(int i=0; i<barbarians.size(); i++) barbarians.get(i).draw(g);
	}
	
	public static boolean isHit(Arrow arrow) {
		for(int i=0; i<barbarians.size(); i++) {
			if(barbarians.get(i).isHit(arrow)) {
				barbarians.remove(i);
				return true;
			}
		}
		return false;
	}
	 
}





