package md.utm.labs;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {
	
	private Drawing drawing = new Drawing();

	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 750);
		setTitle("GC Lab. 1");
		createMenu();
		setVisible(true);
		add(new CustomPanel());
	}

	public void createMenu() {
		final JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		openMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showOpenDialog(menuBar);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					drawing = Drawing.loadDrawing(chosenFile);
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showSaveDialog(menuBar);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					drawing.saveDrawing(chosenFile);
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
		fileMenu.add(saveMenuItem);
		JMenuItem drawMenuItem = new JMenuItem("Draw");
		drawMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.createShapes();
				SwingUtilities.updateComponentTreeUI(MainWindow.this);
			}
		});
		fileMenu.add(drawMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}
	
	public MainWindow(Drawing drawing) {
		this();
		this.drawing = drawing;
	}

	public void createShapes() {
		drawing.addShape(new Triangle(new Point(50, 150), new Point(150, 50), new Point(250, 150)));
		drawing.addShape(new Circle(new Point(600, 25), 150));
		drawing.addShape(new HalfCircle(new Point(50, 200), 200));
		drawing.addShape(new Line(new Point(350, 230), new Point(550, 300)));
		drawing.addShape(new Rectangle(new Point(600, 225), new Point(800, 350)));
		drawing.addShape(new Cuboid(new Point(50, 500), new Point(250, 625)));
		drawing.addShape(new Ellipse(new Point(350, 425), 250, 200));
		drawing.addShape(new HalfEllipse(new Point(650, 425), 250, 200));
		drawing.addShape(new Polygon(new Point(410, 120), 100, 16));
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//MainWindow frame = new MainWindow(Drawing.loadDrawing("image.ros"));
		MainWindow frame = new MainWindow();
		//frame.drawing.saveDrawing("image.ros");
	}
	
	private class CustomPanel extends JPanel {
		public CustomPanel() {
			setSize(MainWindow.this.getSize());
		}
		
		@Override
		public void paintComponent(Graphics graphics) {
			drawing.draw(graphics);
			/*
			drawTriangle(g);
			drawCircle(g);
			drawHalfCircle(g);
			drawLine(g);
			drawRectangle(g);
			drawParalelipiped(g);
			g.setColor(new Color(100, 200, 200));
			Graphics2D g2d = (Graphics2D) g.create();
			Shape ellipse = new Ellipse2D.Double(450, 450, 300, 200);
			g2d.draw(ellipse);
			g2d.fill(ellipse);
			*/
		}

		/*
		public void drawParalelipiped(Graphics g) {
			g.setColor(new Color(200, 200, 120));
			g.drawLine(50, 500, 300, 500);
			g.drawLine(50, 625, 300, 625);
			g.drawLine(50, 500, 50, 625);
			g.drawLine(300, 500, 300, 625);
			
			g.drawLine(100, 450, 350, 450);
			g.drawLine(50, 500, 100, 450);
			g.drawLine(300, 500, 350, 450);
			g.drawLine(300, 625, 350, 575);
			g.drawLine(350, 575, 350, 450);
			Graphics2D g2d = (Graphics2D) g.create();
			Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
					new float[] {9}, 0);
			g2d.setStroke(dashed);
			g2d.drawLine(100, 450, 100, 575);
			g2d.drawLine(100, 575, 350, 575);
			g2d.drawLine(50, 625, 100, 575);
		}
		*/

		/*
		public void drawRectangle(Graphics g) {
			g.setColor(new Color(0, 255, 255));
			g.drawLine(600, 225, 800, 225);
			g.drawLine(600, 350, 800, 350);
			g.drawLine(600, 225, 600, 350);
			g.drawLine(800, 225, 800, 350);
			g.fillRect(600, 225, 200, 125);
		}
		*/

		/*
		public void drawLine(Graphics g) {
			g.setColor(new Color(255, 0, 255));
			g.drawLine(350, 250, 550, 300);
		}
		*/

		/*
		public void drawHalfCircle(Graphics g) {
			g.setColor(new Color(255, 255, 0));
			g.drawArc(50, 200, 200, 200, 0, 180);
			g.fillArc(50, 200, 200, 200, 0, 180);
		}
		*/

		/*
		public void drawCircle(Graphics g) {
			g.setColor(new Color(0, 0, 255));
			g.drawArc(600,  25, 150, 150, 0, 360);
			g.fillArc(600, 25, 150, 150, 0, 360);
		}
		*/

		/*
		public void drawTriangle(Graphics g) {
			g.setColor(new Color(255, 0, 0));
			g.fillPolygon(new int [] { 50, 250, 150 }, new int[] { 150, 150, 50 }, 3);
			g.drawLine(50, 150, 250, 150);
			g.drawLine(50, 150, 150, 50);
			g.drawLine(250, 150, 150, 50);
		}
		*/
	}
}
