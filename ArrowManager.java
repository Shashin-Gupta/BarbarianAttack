package jrJava.barbarianAttack3_linkedList;

import java.awt.Graphics2D;
import java.util.Iterator;

public class ArrowManager {

	private static LinkedList<Arrow> arrows = new LinkedList<Arrow>();
	
	public static void add(Arrow arrow) {
		arrows.insert(arrow);
	}
	 
	public static void move() {
		Arrow each;
		Iterator<Arrow> iter = arrows.iterator();
		while (iter.hasNext()) {
			each = iter.next();
			each.move();
			if (each.getX() < 0 || each.getY() > 650) iter.remove();
			iter.next();
		}
	}
	
	public static void draw(Graphics2D g) {
		Iterator<Arrow> iter = arrows.iterator();
		Arrow each;
		while (iter.hasNext()) { 
			each = iter.next();
			each.draw(g);
			if (each.isCollided()) iter.remove();
		}
	}
	
	
}
