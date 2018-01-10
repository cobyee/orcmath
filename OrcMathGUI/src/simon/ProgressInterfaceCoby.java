package simon;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceCoby extends Visible{

	public static void increaseRound() {
	}

	public void gameOver();
	
	public void setRound(int x);
	
	public void setSequenceSize(int x);
}
