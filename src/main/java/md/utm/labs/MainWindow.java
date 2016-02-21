package md.utm.labs;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {
	
	private Drawing drawing = new Drawing();

	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 750);
		setTitle("GC Lab. 1");
		createMenu();
		add(new CustomPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		JFrame frame = new MainWindow();
	}
	
	private JMenuItem createOpenMenuItem(final JMenuBar menuBar) {
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener((ActionEvent actionEvent) -> {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showOpenDialog(menuBar);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					drawing = Drawing.loadDrawing(chosenFile);
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured while reading the image", "Error", 0);
					throw new RuntimeException(e);
				}
		});
		return openMenuItem;
	}
	
	private JMenuItem createSaveMenuItem(final JMenuBar menuBar) {
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener((ActionEvent actionEvent) -> {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showSaveDialog(menuBar);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					drawing.saveDrawing(chosenFile);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured while saving the image", "Error", 0);
					throw new RuntimeException(e);
				}
		});
		return saveMenuItem;
	}
	
	private JMenuItem createDrawMenuItem(final JMenuBar menuBar) {
		JMenuItem drawMenuItem = new JMenuItem("Draw");
		drawMenuItem.addActionListener((actionListener) -> {
				MainWindow.this.createShapes();
				SwingUtilities.updateComponentTreeUI(MainWindow.this);
		});
		return drawMenuItem;
	}
	
	private JMenuItem createExitMenuItem() {
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener((actionListener) -> System.exit(0));
		return exitMenuItem;
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(createOpenMenuItem(menuBar));
		fileMenu.add(createSaveMenuItem(menuBar));
		fileMenu.add(createDrawMenuItem(menuBar));
		fileMenu.add(createExitMenuItem());
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}
	
	public MainWindow(Drawing drawing) {
		this();
		this.drawing = drawing;
	}

	private void createShapes() {
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
	
	private class CustomPanel extends JPanel {
		public CustomPanel() {
			setSize(MainWindow.this.getSize());
		}
		
		@Override
		public void paintComponent(Graphics graphics) {
			drawing.draw(graphics);
		}
	}
}
