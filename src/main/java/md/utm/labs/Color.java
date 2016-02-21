package md.utm.labs;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class Color {

	@Attribute
	private int red;

	@Attribute
	private int green;

	@Attribute
	private int blue;

	public Color(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public Color() {
		super();
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}
}
