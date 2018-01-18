package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable {
	
	private static TextLabel text;
	private ProgressInterfaceCoby progress;
	private ArrayList<MoveInterfaceCoby> array;
	private ButtonInterfaceCoby[] buttons;
	private int roundNumber = 1;
	private boolean acceptingInput;
	private int sequenceNumber = 3;
	private int lastselectedbutton;
	private Color[] colors;
	private static TextLabel stuff;
	
	public GameScreen(int width, int height) {
		super(width, height);
		Thread app= new Thread(this);
		app.start();
	}
	public void run() {
		 text.setText("");
	     nextRound();
		
	}
	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		array.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(array.size());
		changeText("Simon's Turn");
		text.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceNumber = 0;
		
	}

	private void playSequence() {
		ButtonInterfaceCoby b = null;
		for(int i = 0; i < array.size(); i++) {
			if(b != null) {
				b.dim();
				b = array.get(i).getTheButton();
				b.highlight();
				
				try {
	                Thread.sleep((int)(1000*roundNumber));
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
				b.dim();
			}
		}
		
		
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceCoby b:buttons) {
			viewObjects.add(b);
		}
		progress = getProgress();
		text= new TextLabel(10,10,200,200,"");
		array= new ArrayList<MoveInterfaceCoby>();
		lastselectedbutton=-1;
		array.add(randomMove());
		array.add(randomMove());
		for(int i = 0; i < sequenceNumber; i++) {
			array.add(randomMove());
		}
		roundNumber=0;
		progress.setRound(roundNumber);
		stuff = new TextLabel(500, 500, 300, 80, "Round Number: 1 Sequence Number: 3");
		viewObjects.add(progress);
		viewObjects.add(stuff);
		viewObjects.add(text);
		

	}
	private MoveInterfaceCoby randomMove() {
		int randomidx= (int)(Math.random()*buttons.length);
		while(randomidx==lastselectedbutton) {
			randomidx=(int)(Math.random()*buttons.length);
		}
		return getMove(randomidx);
	}
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceCoby getMove(int randomidx) {
		return new MoveCoby(buttons[randomidx]);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	private ProgressInterfaceCoby getProgress() {
		return new ProgressCoby(100, 100, 200, 200);
	}

	private void addButtons() {
		
		colors = new Color[4];
		colors[0] = Color.BLUE;
		colors[1] = Color.GREEN;
		colors[2] = Color.BLACK;
		colors[3] = Color.RED;
		buttons= new ButtonInterfaceCoby[4];
		
		for(int i=0;i<2;i++) {
			final ButtonInterfaceCoby b=getAButton(i*100+50,100,80,80);
			b.setColor(colors[i]);
		//	b.setX(100);
			//b.setY((i*100)+100);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread blink= new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try{
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == array.get(sequenceNumber).getTheButton()) {
		    		    	sequenceNumber++;
		    		    }
		    		    else {
		    		    	progress.gameOver();
		    		    }
		    		    if(sequenceNumber == array.size()){
		    		        Thread nextRound = new Thread(GameScreen.this);
		    		        nextRound.start();
		    		    }
							
					}
				}
			});
			buttons[i]=b;
		}
		for(int i=2;i<4;i++) {
			final ButtonInterfaceCoby b=getAButton((i-2)*100+50,300,80,80);
			b.setColor(colors[i]);
		//	b.setX(100);
			//b.setY((i*100)+100);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread blink= new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try{
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == array.get(sequenceNumber).getTheButton()) {
		    		    	sequenceNumber++;
		    		    }
		    		    else {
		    		    	progress.gameOver();
		    		    }
		    		    if(sequenceNumber == array.size()){
		    		        Thread nextRound = new Thread(GameScreen.this);
		    		        nextRound.start();
		    		    }
							
					}
				}
			});
			buttons[i]=b;
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	 * @param j 
	 * @param i 
	*/

	private ButtonInterfaceCoby getAButton(int x, int y,int w,int h) {
		return new ButtonCoby(x, y, w, h, "",null);	
	}

	

	
	public static TextLabel getLabel() {
		return text;
	}
	

	private void changeText(String string) {
		text.setText(string);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	}

	

}