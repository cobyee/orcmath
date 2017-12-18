package guiCoby;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private static ArrayList<Book> books;
	public static Scanner in;
	private static boolean done = false;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CatalogMaker maker = new CatalogMaker();
		while(!done) {
			String newName = getName();
			String newAuthor = getAuthor();
			String newGenre = getGenre();
			int newCount = getCount();
			int newPrice = getPrice();
			Book newOne = new Book(newPrice, newCount, newName, newAuthor, newGenre);
			books.add(1,newOne);
			System.out.println(maker.getCSVContent());
			System.out.println("Are you done adding?");
			if(in.nextLine().equals("yes")) {
				break;
			}
		}
	}
	
	public static String getName() {
		System.out.println("What is the name of the book you want to add?");
		return in.nextLine();
	}

	private static int getPrice() {
		System.out.println("How much does this book cost?");
		return Integer.valueOf(in.nextLine());
	}

	private static int getCount() {
		System.out.println("How many pages does this book have?");
		return Integer.valueOf(in.nextLine());
	}

	private static String getGenre() {
		System.out.println("What is the genre of this book?");
		return in.nextLine();
	}

	private static String getAuthor() {
		System.out.println("Who wrote this book?");
		return in.nextLine();
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
