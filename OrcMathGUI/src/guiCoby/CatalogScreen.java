package guiCoby;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{

	private TextField title;
	private TextField author;
	private TextField genre;
	private TextField count;
	private TextField price;
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
		title = new TextField(40, 40, 200, 30, "Enter text","Title");
		viewObjects.add(title);
		author = new TextField(40, 100, 200, 30, "Enter text","Author");
		viewObjects.add(author);
		genre = new TextField(40, 160, 200, 30, "Enter text","Genre");
		viewObjects.add(genre);
		count = new TextField(40, 220, 200, 30, "Enter text","Page Count");
		count.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(count);
		price = new TextField(40, 280, 200, 30, "Enter text","Price");
		price.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(price);
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
		Book b = new Book(Integer.parseInt(price.getText()),Integer.parseInt(count.getText()),title.getText(),author.getText(),genre.getText());
		text.setText(text.getText()+"\n"+b);
		catalog.add(b);
		title.setText("");
		author.setText("");
		genre.setText("");
		count.setText("");
		price.setText("");
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
