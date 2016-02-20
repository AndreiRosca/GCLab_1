package md.utm.labs;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root
public class Drawing implements Serializable {

	@ElementList
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
	
	public void saveDrawing(File file) throws Exception {
		Serializer serializer = new Persister();
		serializer.write(this, file);
	}
	
	public void serializeDrawing(File file) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this);
		}
	}
	
	public static Drawing loadDrawing(File file) throws Exception {
		Drawing drawing = null;
		Serializer serializer = new Persister();
		drawing = serializer.read(Drawing.class, file);
		return drawing;
	}
	
	public static Drawing deserializeDrawing(File file) throws Exception {
		Drawing drawing = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			drawing = (Drawing) in.readObject();
		}
		return drawing;
	}
}
