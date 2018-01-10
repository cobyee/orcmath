package simon;

import guiTeacher.GUIApplication;

public class Design extends GUIApplication{

	public static Design sample;
	public static GameScreen simon;
	
	public Design(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		sample = new Design(1000,1000);
		Thread go = new Thread(sample);
		go.start();
	}

	@Override
	public void initScreen() {
		simon = new GameScreen(getWidth(), getHeight());
		setScreen(simon);
	}

}
