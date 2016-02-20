package md.utm.labs;

import java.awt.Graphics;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Rectangle implements Shape {

	@Element
	private Point leftTop;
	
	@Element
	private Point rightBottom;
	
	@Element
	private Color color = new Color(0, 0, 255);
	
	@Element
	private boolean hollow;

	public Rectangle(Point leftTop, Point rightBottom) {
		super();
		this.leftTop = leftTop;
		this.rightBottom = rightBottom;
	}

	public Rectangle() {
		super();
	}



	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getLeftTop() {
		return leftTop;
	}

	public void setLeftTop(Point leftTop) {
		this.leftTop = leftTop;
	}

	public Point getRightBottom() {
		return rightBottom;
	}

	public void setRightBottom(Point rightBottom) {
		this.rightBottom = rightBottom;
	}

	public void setHollow(boolean hollow) {
		this.hollow = hollow;
	}

	public boolean isHollow() {
		return hollow;
	}

	public void draw(Graphics graphics) {
		graphics.setColor(new java.awt.Color(color.getBlue(), color.getGreen(), color.getRed()));
		graphics.drawLine(leftTop.getX(), leftTop.getY(), rightBottom.getX(), leftTop.getY());
		graphics.drawLine(leftTop.getX(), rightBottom.getY(), rightBottom.getX(), rightBottom.getY());
		graphics.drawLine(leftTop.getX(), leftTop.getY(), leftTop.getX(), rightBottom.getY());
		graphics.drawLine(rightBottom.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY());
		if (!isHollow())
			graphics.fillRect(leftTop.getX(), leftTop.getY(), 
					rightBottom.getX() - leftTop.getX(), rightBottom.getY() - leftTop.getY());
	}
}
