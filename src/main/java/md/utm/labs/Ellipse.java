package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse implements Shape {

	private Point center;
	private int majorRadius;
	private int minorRadius;
	private Color color = new Color(100, 200, 200);
	private boolean hollow;

	public Ellipse(Point center, int majorRadius, int minorRadius) {
		super();
		this.center = center;
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Point getCenter() {
		return center;
	}

	public int getMajorRadius() {
		return majorRadius;
	}

	public int getMinorRadius() {
		return minorRadius;
	}

	public Color getColor() {
		return color;
	}
	
	public boolean isHollow() {
		return hollow;
	}

	public void setHollow(boolean hollow) {
		this.hollow = hollow;
	}

	public void draw(Graphics graphics) {
		Graphics2D g2d = (Graphics2D) graphics.create();
		java.awt.Shape ellipse = new Ellipse2D.Double(center.getX(), center.getY(), majorRadius, minorRadius);
		g2d.draw(ellipse);
		if (isHollow())
			g2d.fill(ellipse);	
	}
}