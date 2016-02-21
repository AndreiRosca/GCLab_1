package md.utm.labs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Ellipse implements Shape {

	@Element
	private Point center;

	@Element
	private int majorRadius;

	@Element
	private int minorRadius;

	@Element
	private Color color = new Color(100, 200, 200);

	@Element
	private boolean hollow = true;

	public Ellipse(Point center, int majorRadius, int minorRadius) {
		super();
		this.center = center;
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setMajorRadius(int majorRadius) {
		this.majorRadius = majorRadius;
	}

	public void setMinorRadius(int minorRadius) {
		this.minorRadius = minorRadius;
	}

	public Ellipse() {
		super();
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
		graphics.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
		Graphics2D g2d = (Graphics2D) graphics.create();
		java.awt.Shape ellipse = new Ellipse2D.Double(center.getX(), center.getY(), majorRadius, minorRadius);
		g2d.draw(ellipse);
		if (!isHollow())
			g2d.fill(ellipse);
	}
}