package guiCoby;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Book extends Component {

	int price;
	int pageCount;
	//String imgAddress;
	String title;
	String author;
	String genre;
	
	public Book(int price, int pageCount, String title, String author, String genre) {
		super(40, 40, 120, 120);
		//addSequence("resources/spritesheet.png", 150, 0, 0, 120, 120, 4);
		//Thread animation = new Thread(this);
		//animation.start();
		//update();
		this.price = price;
		this.pageCount = pageCount;
		//this.imgAddress = imgAddress;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//super.update(g);
	}

	public String toString() {
		return title + ", " + author + ", " + genre + ", " + pageCount + ", " + price;
	}
	
}
