package md.utm.labs;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Cuboid implements Shape {

	@Element
	private Point leftTop;

	@Element
	private Point rightBottom;

	@Element
	private Color color = new Color(200, 200, 120);

	public Cuboid(Point leftTop, Point rightBottom) {
		super();
		this.leftTop = leftTop;
		this.rightBottom = rightBottom;
	}

	public void setLeftTop(Point leftTop) {
		this.leftTop = leftTop;
	}

	public void setRightBottom(Point rightBottom) {
		this.rightBottom = rightBottom;
	}

	public Cuboid() {
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

	public Point getRightBottom() {
		return rightBottom;
	}

	public void draw(Graphics graphics) {
		graphics.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
		graphics.drawLine(leftTop.getX(), leftTop.getY(), rightBottom.getX(), leftTop.getY());
		graphics.drawLine(leftTop.getX(), rightBottom.getY(), rightBottom.getX(), rightBottom.getY());
		graphics.drawLine(leftTop.getX(), leftTop.getY(), leftTop.getX(), rightBottom.getY());
		graphics.drawLine(rightBottom.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY());
		graphics.drawLine(leftTop.getX() + 50, leftTop.getY() - 50, rightBottom.getX() + 50, leftTop.getY() - 50);
		graphics.drawLine(leftTop.getX(), leftTop.getY(), leftTop.getX() + 50, leftTop.getY() - 50);
		graphics.drawLine(rightBottom.getX(), leftTop.getY(), rightBottom.getX() + 50, leftTop.getY() - 50);
		graphics.drawLine(rightBottom.getX(), rightBottom.getY(), rightBottom.getX() + 50, rightBottom.getY() - 50);
		graphics.drawLine(rightBottom.getX() + 50, rightBottom.getY() - 50, rightBottom.getX() + 50,
				leftTop.getY() - 50);
		Graphics2D g2d = (Graphics2D) graphics.create();
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
		g2d.setStroke(dashed);
		g2d.drawLine(leftTop.getX() + 50, leftTop.getY() - 50, leftTop.getX() + 50, rightBottom.getY() - 50);
		g2d.drawLine(leftTop.getX() + 50, rightBottom.getY() - 50, rightBottom.getX() + 50, rightBottom.getY() - 50);
		g2d.drawLine(leftTop.getX(), rightBottom.getY(), leftTop.getX() + 50, rightBottom.getY() - 50);
	}
}
