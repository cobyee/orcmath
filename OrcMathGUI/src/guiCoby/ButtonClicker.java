package guiCoby;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ButtonClicker extends FullFunctionScreen{

	private Button button;
	private TextArea text;
	private boolean clicking = false;
	private boolean started = false;
	private int count = 0;
	
	public ButtonClicker(int width,int height) {
		super(width,height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		text = new TextArea(30,30,100,100,"Score ");
		button = new Button(200,200,100,100,"Start", new Action() {
			
			public void act() {
				if(!started) {
					started = true;
					new Thread() {
						public void run() {
							try {
								button.setText("3");
								button.update();
								Thread.sleep(1000);
								button.setText("2");
								button.update();
								Thread.sleep(1000);
								button.setText("1");
								button.update();
								Thread.sleep(1000);
								button.setText("CLICK");
								button.update();
								Thread.sleep(100);
								clicking = true;
								button.setText("5");
								button.update();
								Thread.sleep(1000);
								button.setText("4");
								button.update();
								Thread.sleep(1000);
								button.setText("3");
								button.update();
								Thread.sleep(1000);
								button.setText("2");
								button.update();
								Thread.sleep(1000);
								button.setText("1");
								button.update();
								Thread.sleep(1000);
								button.setText("0");
								button.update();
								clicking = false;
								button.update();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}.start();
				} else if(clicking && started) {
					count++;
					text.setText("Score " + count);
				}
			}
		});
		viewObjects.add(button);
		viewObjects.add(text);
	}
}
