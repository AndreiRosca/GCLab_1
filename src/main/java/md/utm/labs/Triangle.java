package md.utm.labs;

import java.awt.Graphics;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Triangle implements Shape {
	private static final long serialVersionUID = 1L;

	@Element
	private Color color = new Color(110, 50, 75);

	@Element
	private Point left;

	@Element
	private Point top;

	@Element
	private Point right;

	@Attribute
	private boolean hollow;

	public Triangle() {
		super();
	}

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
		g.setColor(new java.awt.Color(color.getBlue(), color.getGreen(), color.getRed()));
		g.drawLine(left.getX(), left.getY(), right.getX(), right.getY());
		g.drawLine(left.getX(), left.getY(), top.getX(), top.getY());
		g.drawLine(right.getX(), right.getY(), top.getX(), top.getY());
		if (!hollow)
			g.fillPolygon(new int[] { left.getX(), top.getX(), right.getX() },
					new int[] { left.getY(), top.getY(), right.getY() }, 3);
	}
}
