package guiCoby;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Player extends Component {

	int number;
	//String imgAddress;
	String firstName;
	String lastName;
	String team;
	
	public Player(String firstName, String lastName, String team, int number) {
		super(40, 40, 120, 120);
		//addSequence("resources/spritesheet.png", 150, 0, 0, 120, 120, 4);
		//Thread animation = new Thread(this);
		//animation.start();
		//update();
		this.number = number;
		this.firstName = firstName;
		//this.imgAddress = imgAddress;
		this.lastName = lastName;
		this.team = team;
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//super.update(g);
	}

	public String toString() {
		return firstName + ", " + lastName + ", " + team + ", " + number;
	}
	
}
