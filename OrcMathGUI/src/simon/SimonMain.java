package simon;


import guiTeacher.GUIApplication;

public class SimonMain extends GUIApplication {

	
	public SimonMain(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		SimonMain game = new SimonMain(800, 550);
		Thread go = new Thread(game);
		go.start();
	}
	
	
	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		
		simonGame screen = new simonGame(getWidth(), getHeight());
		setScreen(screen);

	}

}