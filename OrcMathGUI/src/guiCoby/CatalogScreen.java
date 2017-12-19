package guiCoby;

import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField title;
	private TextField author;
	private TextField genre;
	private TextField count;
	private TextField price;
	private Button button;
	
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
		viewObjects.add(count);
		price = new TextField(40, 280, 200, 30, "Enter text","Price");
		viewObjects.add(price);
		button = new Button(40, 320, 40, 40, "Press", null);
		viewObjects.add(button);
	}

}
