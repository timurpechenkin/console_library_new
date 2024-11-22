package maven_projects.console_library_new;

import java.util.*;

public class App {
	public static void main(String[] args) {
		final String filePath = "books_list.dat";
		
		System.out.print("Welcome to the Library!\nYou can enter \"HELP\" to get the list of commands\n");
		ArrayList<Book> books = FileManager.getBooks(filePath);
		BookManager bookManager = new BookManager(books);
		
		String userInput;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Enter a command: ");
			userInput = scan.nextLine();
			executeCommand(userInput, bookManager);
		} while (!userInput.equals("STOP"));
		
		FileManager.saveBooks(filePath, books);
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
						"List of commands:\nGET ?name=...&author=...&pagescount=...&pagesless=...&pagesmore=...\nHELP\nPOST {\"Name\":\"...\", \"Author\":\"...\", \"PagesCount\":...}\nSTOP");
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