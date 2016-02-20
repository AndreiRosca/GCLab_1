package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape {

	private Point center;
	private int radius;
	private Color color = new Color(255, 0, 0);
	private boolean hollow;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setHollow(boolean hollow) {
		this.hollow = hollow;
	}
	
	public boolean isHollow() {
		return hollow;
	}

	public Point getCenter() {
		return center;
	}

	public int getRadius() {
		return radius;
	}

	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawArc(center.getX(), center.getY(), radius, radius, 0, 360);
		if (!isHollow())
			graphics.fillArc(center.getX(), center.getY(), radius, radius, 0, 360);
	}
}
