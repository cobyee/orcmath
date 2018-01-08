package simon;

import java.awt.Color;

import guiTeacher.interfaces.Clickable;

public interface ButtonInterface extends Clickable {

	void setColor(Color color);

	void setAction(Action a);
	
}
