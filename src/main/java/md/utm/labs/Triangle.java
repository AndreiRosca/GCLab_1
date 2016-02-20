package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle implements Shape {
	
	private Color color = new Color(0, 0, 0);
	private Point left;
	private Point top;
	private Point right;
	private boolean hollow;
	
	public Triangle(Point left, Point top, Point right) {
		this.left = left;
		this.top = top;
		this.right = right;
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

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(left.getX(), left.getY(), right.getX(), right.getY());
		g.drawLine(left.getX(), left.getY(), top.getX(), top.getY());
		g.drawLine(right.getX(), right.getY(), top.getX(), top.getY());
		if (!hollow)
			g.fillPolygon(new int [] { left.getX(), top.getX(), right.getX() }, 
					new int[] { left.getY(), top.getY(), right.getY() }, 3);
	}
}
