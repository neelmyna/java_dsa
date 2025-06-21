package person;

import java.util.Scanner;

public class PersonDemo {
	
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	private static int runMenu(int choice) {
		
		System.out.print("1:Insert 2:Search 3:Update 4:Delete 5:ListAll 6:Exit \n Your Choice please: ");
		switch(choice) {
		case 1 : PersonService.createPerson(); break;
		case 2 : PersonService.readPerson(); break;
		case 3 : PersonService.updatePerson(); break;
		case 4 : PersonService.deletePerson(); break;
		case 5 : PersonService.listAllPersons(); break;
		case 6 : choice = 0;
		default: System.out.println("Invalid choice enetered");
		}
		return choice;
	}
	
	private static void startApp() {
		int choice = 0;
		do {
			choice = runMenu(choice);
		}while(choice != 0);
	}
	
	public static void main(String[] args) {
		startApp();
	}
}
