package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonCoby extends Button implements ButtonInterfaceCoby{

	private Color color;
	private boolean buttonOn = false;

	public ButtonCoby(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
	}

	@Override
	public void setColor(Color c) {
		color = c;
		this.setBackground(c);
		update();
	}

	@Override
	public void highlight() {
		this.setBackground(Color.white);
	}

	@Override
	public void dim() {
		this.setBackground(color);
	}

	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(getForeground());
	}
	
}
