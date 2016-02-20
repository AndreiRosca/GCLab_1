package md.utm.labs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class HalfEllipse implements Shape {

	@Element
	private Color color = new Color(12, 45, 90);
	
	@Element
	private Point center;

	@Element
	private int majorRadius;

	@Element
	private int minorRadius;

	@Element
	private boolean hollow;

	public HalfEllipse(Point center, int majorRadius, int minorRadius) {
		super();
		this.center = center;
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public HalfEllipse() {
		super();
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

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setMajorRadius(int majorRadius) {
		this.majorRadius = majorRadius;
	}

	public void setMinorRadius(int minorRadius) {
		this.minorRadius = minorRadius;
	}

	public void setHollow(boolean hollow) {
		this.hollow = hollow;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
		Graphics2D g2d = (Graphics2D) g.create();
		Arc2D.Double halfEllipse = new Arc2D.Double(center.getX(), center.getY(), majorRadius, minorRadius, 0, 180,
				Arc2D.OPEN);
		g2d.draw(halfEllipse);
		if (!isHollow())
			g2d.fill(halfEllipse);
	}
}
