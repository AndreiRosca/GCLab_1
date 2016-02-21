package md.utm.labs;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private MainWindowMenu mainMenu = new MainWindowMenu(this);
	private Drawing drawing = new Drawing();

	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 750);
		setTitle("GC Lab. 1");
		add(new CustomPanel());
		setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		new MainWindow();
	}

	public MainWindow(Drawing drawing) {
		this();
		this.drawing = drawing;
	}

	public void createShapes() {
		drawing.clear();
		drawing.addShape(new Triangle(new Point(75, 150), new Point(175, 50), new Point(275, 150)));
		drawing.addShape(new Circle(new Point(700, 25), 150));
		drawing.addShape(new HalfCircle(new Point(75, 250), 200));
		drawing.addShape(new Line(new Point(375, 280), new Point(575, 350)));
		drawing.addShape(new Rectangle(new Point(680, 250), new Point(880, 350)));
		drawing.addShape(new Cuboid(new Point(50, 500), new Point(250, 625)));
		drawing.addShape(new Ellipse(new Point(350, 425), 250, 200));
		drawing.addShape(new HalfEllipse(new Point(650, 425), 250, 200));
		drawing.addShape(new Polygon(new Point(465, 120), 100, 16));
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public Drawing getDrawing() {
		return drawing;
	}

	private class CustomPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public CustomPanel() {
			setSize(MainWindow.this.getSize());
		}

		@Override
		public void paintComponent(Graphics graphics) {
			drawing.draw(graphics);
		}
	}
}
