package md.utm.labs;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Drawing implements Serializable {

	private List<Shape> shapes = new ArrayList<Shape>();
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void draw(Graphics graphics) {
		for (Shape shape : shapes)
			shape.draw(graphics);
	}
	
	public int getNumberOfShapes() {
		return shapes.size();
	}
	
	public void saveDrawing(File file) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this);
		}
	}
	
	public static Drawing loadDrawing(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		Drawing drawing = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			drawing = (Drawing) in.readObject();
		}
		return drawing;
	}
}
