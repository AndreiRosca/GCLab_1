package md.utm.labs;

import java.awt.Graphics;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Circle implements Shape {
	private static final long serialVersionUID = 1L;

	@Element
	private Point center;

	@Element
	private int radius;

	@Element
	private Color color = new Color(255, 0, 0);

	@Attribute
	private boolean hollow;

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setRadius(int radius) {
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
		graphics.setColor(new java.awt.Color(color.getBlue(), color.getGreen(), color.getRed()));
		graphics.drawArc(center.getX(), center.getY(), radius, radius, 0, 360);
		if (!isHollow())
			graphics.fillArc(center.getX(), center.getY(), radius, radius, 0, 360);
	}
}
