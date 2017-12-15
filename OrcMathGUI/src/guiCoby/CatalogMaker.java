package guiCoby;

import java.util.ArrayList;

public class CatalogMaker {

	private ArrayList<Book> books;
	
	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		System.out.println(maker.getCSVContent());
	}

	public CatalogMaker() {
		books = new ArrayList<Book>();
		books.add(new Book(10,50,"The Book", "Coby","Horror"));
		books.add(new Book(25,60,"Winner", "Al","Comedy"));
		books.add(new Book(5,20,"Loser", "Joe","Horror"));
		books.add(new Book(30,100,"The Lockness Monster", "Sally","Non-fiction"));
	}
	
	public String getCSVContent() {
		String data = "";
		for(Book b: books) {
			data += b + "\n";
		}
		return data;
	}
	
}
