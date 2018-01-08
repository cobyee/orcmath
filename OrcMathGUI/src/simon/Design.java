package simon;

import guiCoby.CatalogScreen;
import guiTeacher.GUIApplication;

public class Design extends GUIApplication{

	public Design(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		GameScreen screen = new GameScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		
	}

}
