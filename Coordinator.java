package jrJava.barbarianAttack3_linkedList;

import java.awt.Graphics2D;
import resources.DrawingBoard;

public class Coordinator {
	
	public static final String R_PATH = "jrJava/barbarianAttack_Images_and_Sounds/";
	public static boolean gameOver;
	
	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(0, 0, 1350, 700);
		Graphics2D g = (Graphics2D) board.getCanvas();
		
		Bow bow = new Bow(1163, 523, 0.3);
		board.addMouseListener(bow);
		board.addMouseMotionListener(bow);
		
		board.setBackgroundImage(R_PATH + "bg.png");
		
		while(!gameOver) {
			board.clear();
			
			BarbarianManager.move();
			ArrowManager.move();
			
			bow.draw(g);
			BarbarianManager.draw(g);
			ArrowManager.draw(g); 
			board.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
		}
		board.setBackgroundImage(R_PATH + "bg_gameOver.png");
	}
	
	}
