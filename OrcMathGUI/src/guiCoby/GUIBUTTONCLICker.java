package guiCoby;

import guiTeacher.GUIApplication;

public class GUIBUTTONCLICker extends GUIApplication {

	public GUIBUTTONCLICker(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		ButtonClicker screen = new ButtonClicker(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIBUTTONCLICker sample = new GUIBUTTONCLICker(1000,1000);
		Thread go = new Thread(sample);
		go.start();
	}

}
