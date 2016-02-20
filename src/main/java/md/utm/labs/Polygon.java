package md.utm.labs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape {

	private Point center;
	private int radius;
	private int numberOfPoints;
	private Color color = new Color(0, 0, 0);
	private boolean hollow;

	public Polygon(Point center, int radius, int numberOfPoints) {
		super();
		this.center = center;
		this.radius = radius;
		this.numberOfPoints = numberOfPoints;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}

	public Color getColor() {
		return color;
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

	@Override
	public void draw(Graphics g) {
		final double ANGLE_PER_POINT = 360.0 / numberOfPoints;
		double angle = 0;
		List<Point> points = new ArrayList<Point>(numberOfPoints);
		for (int point = 0; point < numberOfPoints; ++point, angle += ANGLE_PER_POINT) {
			int x = (int) (center.getX() + radius * Math.cos(angle * Math.PI / 180));
			int y = (int) (center.getY() + radius * Math.sin(angle * Math.PI / 180));
			points.add(new Point(x, y));
		}
		g.setColor(color);
		int[] xPoints = getXPoints(points);
		int[] yPoints = getYPoints(points);
		g.drawPolygon(xPoints, yPoints, numberOfPoints);
	}
	
	private int[] getXPoints(List<Point> points) {
		int[] xPoints = new int[points.size()];
		for (int i = 0; i < xPoints.length; ++i)
			xPoints[i] = points.get(i).getX();
		return xPoints;
	}
	
	private int[] getYPoints(List<Point> points) {
		int[] yPoints = new int[points.size()];
		for (int i = 0; i < yPoints.length; ++i)
			yPoints[i] = points.get(i).getY();
		return yPoints;
	}
}
