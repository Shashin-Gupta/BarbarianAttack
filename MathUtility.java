package jrJava.barbarianAttack3_linkedList;

public class MathUtility {

	public static void translate(Point[] points, Point ref) {
		for(int i=0; i<points.length; i++) {
			points[i].x += ref.x;
			points[i].y += ref.y;
		}
	}
	
	
	public static void scaleAndRotate(Point point, Point ref, double scale, double radian) {
		double x1 = point.x - ref.x;
		double y1 = point.y - ref.y;
		
		double x2 = x1*Math.cos(radian) - y1*Math.sin(radian);
		double y2 = x1*Math.sin(radian) + y1*Math.cos(radian);
		
		point.x = scale*x2 + ref.x;
		point.y = scale*y2 + ref.y;
	}
	
}

















