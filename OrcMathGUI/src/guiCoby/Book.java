package guiCoby;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Book extends Component {

	public Book() {
		super(40, 40, 150, 100);
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		g.drawRect(0, 0, getWidth(), getHeight());
	}

}
