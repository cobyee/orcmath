package simon;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressCoby extends Component implements ProgressInterfaceCoby{

	private int roundNum;
	private int sequenceNum;
	private boolean loss;
	
	public ProgressCoby(int x, int y, int w, int h) {
		super(40, 300, 250, 250);
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.drawString("Round: ", 50, 50);
		g.drawString("Current sequence length: ", 100, 50);
		if(loss) {
			g.drawString("You Lose", 150, 50);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void gameOver() {
		loss = true;
		update();
	}

	@Override
	public void setRound(int x) {
		roundNum = x;
		update();
	}

	@Override
	public void setSequenceSize(int x) {
		sequenceNum = x;
		update();
	}

}
