package md.utm.labs;

import java.awt.Graphics;
import java.io.Serializable;

public interface Shape extends Serializable {
	void draw(Graphics g);
}
