package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Shape {

	private Point leftTop;
	private Point rightBottom;
	private Color color = new Color(0, 0, 255);
	private boolean hollow;

	public Rectangle(Point leftTop, Point rightBottom) {
		super();
		this.leftTop = leftTop;
		this.rightBottom = rightBottom;
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
		graphics.setColor(color);
		graphics.drawLine(leftTop.getX(), leftTop.getY(), rightBottom.getX(), leftTop.getY());
		graphics.drawLine(leftTop.getX(), rightBottom.getY(), rightBottom.getX(), rightBottom.getY());
		graphics.drawLine(leftTop.getX(), leftTop.getY(), leftTop.getX(), rightBottom.getY());
		graphics.drawLine(rightBottom.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY());
		if (!isHollow())
			graphics.fillRect(leftTop.getX(), leftTop.getY(), 
					rightBottom.getX() - leftTop.getX(), rightBottom.getY() - leftTop.getY());
	}
}
