package guiCoby;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class CatalogMaker {

	private static ArrayList<Player> players;
	public static Scanner in;
	private static boolean done = false;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CatalogMaker maker = new CatalogMaker();
		while(!done) {
			Player player = ask();
			add(player);
			System.out.println(maker.getCSVContent());
			System.out.println("Are you done adding?");
			if(in.nextLine().equals("yes")) {
				save("catalog.csv");
				break;
			}
		}
	}
	
	public static Player ask() {
		String firstName;
		String lastName;
		int number;
		String team;
		firstName = getFirstName();
		lastName = getLastName();
		team = getTeam();
		number = getNumber();
		Player b = new Player(firstName, lastName, team, number);
		return b;
	}
	
	public static void add(Player b) {
		players.add(b);
	}
	
	public static String getFirstName() {
		System.out.println("What is the first name of the player you want to add?");
		return in.nextLine();
	}

	private static String getLastName() {
		System.out.println("What is this player's last name?");
		return in.nextLine();
	}

	private static int getNumber() {
		System.out.println("What is the number of this player?");
		return Integer.valueOf(in.nextLine());
	}

	private static String getTeam() {
		System.out.println("Which team is this player on?");
		return in.nextLine();
	}

	public CatalogMaker() {
		players = new ArrayList<Player>();
		players.add(new Player("Lebron","James","Cavaliers",6));
		players.add(new Player("Carmelo","Anthony","Thunder",7));
		players.add(new Player("Stephen","Curry","Warriors",30));
		players.add(new Player("Kevin","Durant","Warriors",35));
	}
	
	public String getCSVContent() {
		String data = "";
		for(Player b: players) {
			data += b + "\n";
		}
		return data;
	}
	
	public static void save(String fileName) {

		try{    
			FileWriter fw=new FileWriter("PlayerList.csv");
			for(Player p: players){
				fw.write(p+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"PlayerList.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	
}
