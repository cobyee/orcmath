package guiCoby;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button{

	private String string1;
	private String string2;
	private Color c;
	
	public CustomButton(int x, int y) {
		super(x, y, 20, 20, "", null);
	}

	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(string1,20,20);
		g.drawString(string2,20,20);
		g.drawRect(50,50,40,40);
	}
	
	public void updateString1(String string) {
		string1=string;
	}

	public void updateString2(String string) {
		string2=string;
	}

	public void setIconColor(Color color) {
		c=color;
	}
}
