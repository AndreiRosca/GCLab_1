package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

public class HalfEllipse implements Shape {

	private Point center;
	private int majorRadius;
	private int minorRadius;
	private Color color = new Color(12, 45, 90);
	private boolean hollow;
	
	public HalfEllipse(Point center, int majorRadius, int minorRadius) {
		super();
		this.center = center;
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
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
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isHollow() {
		return hollow;
	}

	public void setHollow(boolean hollow) {
		this.hollow = hollow;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		Graphics2D g2d = (Graphics2D) g.create();
		Arc2D.Double halfEllipse = 
				new Arc2D.Double(center.getX(), center.getY(), majorRadius, minorRadius, 0, 180, Arc2D.OPEN);
		g2d.draw(halfEllipse);
		if (!isHollow())
			g2d.fill(halfEllipse);
	}
}
