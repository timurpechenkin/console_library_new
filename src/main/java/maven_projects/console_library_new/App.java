package maven_projects.console_library_new;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		BookManager bookManager = new BookManager(books);
		System.out.print("Welcome to the Library!\nYou can enter <<HELP>> to get the list of commands\n");
		String userInput;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Enter a command: ");
			userInput = scan.nextLine();
			executeCommand(userInput, bookManager);
		} while (!userInput.equals("STOP"));

		scan.close();

		
		
		System.out.print("The the Library was closed");
	}

	static void executeCommand(String userInput, BookManager bookManager) {
		if (userInput == null)
			return;
		userInput = userInput.trim();
		int spaceIndex = userInput.indexOf(" ");
		if (spaceIndex == -1) {
			switch (userInput) {
			case "HELP":
				System.out.println(
						"List of commands:\nGET{\"Name\":\"xxx\"}\nHELP\nPOST {\"Name\":\"xxx\", \"Author\":\"xxx\", \"PagesCount\":xxx}\nSTOP");
				break;
			case "STOP":
				System.out.println("The session was stopped");
				break;
			default:
				System.out.println("There is no such command");
			}
		} else {
			String supplement = userInput.substring(spaceIndex + 1, userInput.length());
			String command = userInput.substring(0, spaceIndex);
			switch (command) {
			case "GET":
				bookManager.get(supplement);
				break;
			case "POST":
				bookManager.post(supplement);
				break;
			default:
				System.out.println("There is no such command");
			}
		}
	}
}