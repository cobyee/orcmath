package simon;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextBox;
import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class simonGame extends FullFunctionScreen {

	public simonGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	
	private Button redButton;
	private Button yellowButton;
	private Button greenButton;
	private Button pinkButton;
	
	
	private TextBox gameMetaText;
	private TextBox turnDescription;
	
	private long sequenceSpeed = 2000;
	
	boolean firstUpdate = true;
	
	boolean simonsTurn = true;
	
	boolean endOfGame = false;
	
	int seqPos = 0;
	String[] currentRound;

	
	
	public void buttonClick(String color) {
		System.out.println("simonsTurn is " + simonsTurn);
		if(simonsTurn == false && !endOfGame) {
			if(this.currentRound[this.seqPos] == color) {
				this.seqPos++;
			}
			else {
				System.out.println("end game");
				endOfGame = true;
				turnDescription.remove(0, turnDescription.getText().length());
				turnDescription.setAlpha(1);
				if(currentRound.length == 3) {
					turnDescription.setText("End of Game\nMax Sequence Reached: "+ 0);
				}else {
					turnDescription.setText("End of Game\nMax Sequence Reached: "+ (currentRound.length-1));
				}
				turnDescription.update();
			}
			
			if(this.seqPos == this.currentRound.length) {
				simonsTurn = true;
				
				setUpNextRound();
				displayCurrentRound();
			}
		}
		

	}
	
	
	public void setUpNextRound() {
		String[] nextRound = new String[this.currentRound.length+1];
		System.arraycopy( this.currentRound, 0, nextRound, 0, this.currentRound.length );
		
		if(nextRound.length >= 2) {
			nextRound[nextRound.length-1] = getRandMove(nextRound[nextRound.length-2]);
		}else
		{
			nextRound[nextRound.length-1] = getRandMove("None");
		}
		
		
		
		this.currentRound = nextRound;
		
		this.gameMetaText.remove(0, gameMetaText.getText().length());
		this.gameMetaText.setText(getRoundText());
		this.gameMetaText.update();

		this.seqPos = 0;
		
		
		simonTurn();
		
		
	}
	
	public void simonTurn() {
		Thread simonButtonSeq = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				turnDescription.remove(0, turnDescription.getText().length());
				turnDescription.setText("Simon's Turn!");
				turnDescription.update();
				turnDescription.setAlpha(1);
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//wait for previous moves to complete toggling buttons
				
				for(int i = 0; i < currentRound.length; i++) {
					toggleButton(currentRound[i]);
					System.out.println("button " + i +" toggled");
					
				}
				simonsTurn = false;
				
				turnDescription.remove(0, turnDescription.getText().length());
				turnDescription.setText("Your Turn!");
				turnDescription.update();
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				turnDescription.setAlpha(0);
			}
		});
	simonButtonSeq.start();
	if(sequenceSpeed > 200) {
		sequenceSpeed -= 200;
	}else {
		sequenceSpeed = 200; //minimum speed
	}
	}
	
	public void displayCurrentRound() {
		System.out.println("current round:");
		for(String s : this.currentRound) {
			System.out.println(s);		
		}
		
		
		
		
	}
	
	public void toggleButton(String s) {
		if(s == "red") {
			redButton.setBackground(Color.WHITE);
			redButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			redButton.setBackground(Color.RED);
			redButton.update();
		}
		if(s == "yellow") {
			yellowButton.setBackground(Color.WHITE);
			yellowButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			yellowButton.setBackground(Color.YELLOW);
			yellowButton.update();
		}
		if(s == "green") {
			greenButton.setBackground(Color.WHITE);
			greenButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			greenButton.setBackground(Color.GREEN);
			greenButton.update();
		
		}
		if(s=="pink") {
			pinkButton.setBackground(Color.WHITE);
			pinkButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pinkButton.setBackground(Color.PINK);
			pinkButton.update();
		}
	}


	public void fillArrayWithMoves(String[] arr) {
		if(arr.length > 0) {
			arr[0] = getRandMove("None");
		}
		for(int i = 1; i < arr.length; i++) {
			arr[i] = getRandMove(arr[i-1]);
		}
	}
	
	public String getRandMove(String prevColor) {
		while(true) {
			
			int randNum = (int)(Math.random() * 6);
			
			if(randNum == 0) {
				if(prevColor != "red") {
					return "red";
				}
			}
			if(randNum == 1) {
				if(prevColor != "yellow") {
					return "yellow";
				}
			}
			if(randNum == 2) {
				if(prevColor != "green") {
					return "green";
				}
			}	
			if(randNum == 3) {
				if(prevColor != "pink") {
					return "pink";
				}
			}
		}
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//initialize first round
		
		currentRound = new String[3];
		fillArrayWithMoves(currentRound);
		
		redButton = new Button(300, 100 ,50,50, "",Color.RED, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						redButton.setBackground(Color.WHITE);
						redButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						redButton.setBackground(Color.RED);
						redButton.update();
					}
				});
			blinker.start();
			buttonClick("red");
		
			}
		} );
		
		viewObjects.add(redButton);
		
		
		yellowButton = new Button(250, 150 ,50,50, "",Color.YELLOW, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						yellowButton.setBackground(Color.WHITE);
						yellowButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						yellowButton.setBackground(Color.YELLOW);
						yellowButton.update();
					}
				});
			blinker.start();
			buttonClick("yellow");
			
			}
		} );
		
		viewObjects.add(yellowButton);
		
		
		
		greenButton = new Button(250, 220 ,50,50, "",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						greenButton.setBackground(Color.WHITE);
						greenButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						greenButton.setBackground(Color.GREEN);
						greenButton.update();
					}
				});
			blinker.start();
			buttonClick("green");
			
			}
		} );
		
		viewObjects.add(greenButton);
		
		
		viewObjects.add(pinkButton);
		
		gameMetaText = new TextBox(300,350,175,60, getRoundText());
		viewObjects.add(gameMetaText);
		
		turnDescription = new TextBox(50, 20, 250 ,60, "");
		viewObjects.add(turnDescription);
		
	}
	
	
	public String getRoundText() {
		return "Round " + (this.currentRound.length - 2) + "\nSequence Length: "+this.currentRound.length;
	}
	
	public void update() {
		if(this.firstUpdate) {
			System.out.println("firstUPdate");
			this.firstUpdate = false;
			this.displayCurrentRound();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.simonTurn();
		}
		super.update();
	}
}