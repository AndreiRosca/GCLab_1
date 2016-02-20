package md.utm.labs;

import java.awt.Graphics;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Line implements Shape {

	@Element
	private Point start;

	@Element
	private Point end;

	@Element
	private Color color = new Color(0, 0, 0);

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Line() {
		super();
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
		graphics.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
		graphics.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
	}
}
