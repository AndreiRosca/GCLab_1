package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape {

	private Point start;
	private Point end;
	private Color color = new Color(0, 0, 0);

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
	}
}
