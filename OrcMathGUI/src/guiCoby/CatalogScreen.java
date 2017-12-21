package guiCoby;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{

	private TextField firstName;
	private TextField lastName;
	private TextField team;
	private TextField number;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton openedButton;
	private TextArea text;
	private CatalogMaker catalog;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		firstName = new TextField(40, 40, 200, 30, "Enter text","First Name");
		viewObjects.add(firstName);
		lastName = new TextField(40, 100, 200, 30, "Enter text","Last Name");
		viewObjects.add(lastName);
		team = new TextField(40, 160, 200, 30, "Enter text","Team");
		viewObjects.add(team);
		number = new TextField(40, 220, 200, 30, "Enter text","Number");
		number.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(number);
		text = new TextArea(40, 340, 500, 200,"This is where text goes");
		viewObjects.add(text);
		addButton = new Button(300, 40, 60, 30, "Add item", new Action() {
			public void act() {
				addClicked();
			}
		});
		viewObjects.add(addButton);
		saveButton = new Button(300,100,60,30,"Save", new Action() {
			
			public void act() {
				saveProgress();
			}
		});
		viewObjects.add(saveButton);
		deleteButton = new Button(300,160,60,30,"Delete", new Action() {
			
			public void act() {
				deleteProgress();
			}
		});
		viewObjects.add(deleteButton);
		openedButton = new FileOpenButton(300, 220, 60, 30, null, this);
		viewObjects.add(openedButton);
		catalog = new CatalogMaker();
	}

	protected void deleteProgress() {
		text.setText("Your progress has been deleted");
	}

	protected void saveProgress() {
		text.setText("Your progress has been saved");
	}

	protected void addClicked() {
		Player p = new Player(firstName.getText(),lastName.getText(),team.getText(),Integer.parseInt(number.getText()));
		text.setText(text.getText()+"\n"+p);
		catalog.add(p);
		firstName.setText("");
		lastName.setText("");
		team.setText("");
		number.setText("");
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
