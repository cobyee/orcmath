package guiCoby;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		CatalogScreen screen = new CatalogScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		CatalogMakerGUI sample = new CatalogMakerGUI(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

}
