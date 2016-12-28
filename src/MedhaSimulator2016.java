import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.Item;
import rooms.Bedroom;
import rooms.Classroom;
import rooms.EastCampus;
import rooms.NoyceEntrance;
import rooms.Room;

public class MedhaSimulator2016 {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("Welcome to Medha Simulator 2016!");
		System.out.println("Your goal is to get to 207 on time.");
		System.out.println();
		
		Room[] rooms = new Room[]{ new Bedroom(), new EastCampus(), new NoyceEntrance(), new Classroom() };
		List<Item> inventory = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int round = 1;
		boolean justEntered;
		
		for(Room r : rooms) {
			justEntered = true;
			while(!r.shouldLeave()) {
				System.out.println(fmtRound(round) + " =====");
				if(justEntered) {
					System.out.println(r.getFlavor());
					System.out.println("Welcome to == " + r.getName() + " ==");
				}

				System.out.print("> ");
				String cmd = in.nextLine();
				System.out.println();

				System.out.println(r.processCommand(cmd.toLowerCase(), inventory));
				round++;
				justEntered = false;
			}
		}
		
		System.out.println("The end!");
		
		in.close();
	}
	
	private static String fmtRound(int round) {
		if(round < 10) {
			return "00" + round;
		} else if(round < 100) {
			return "0" + round;
		} else {
			return Integer.toString(round);
		}
	}
}
