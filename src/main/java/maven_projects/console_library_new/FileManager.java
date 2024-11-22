package maven_projects.console_library_new;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

	public static void saveBooks(String filePath, ArrayList<Book> books) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath, true))) {
			oos.writeObject(books);
			System.out.println("The books was saved");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static ArrayList<Book> getBooks(String filePath) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			ArrayList<Book> readedBooks = (ArrayList<Book>) ois.readObject();
			if (readedBooks == null) {
				System.out.println("There is no saved books");
				return new ArrayList<Book>();
			}
			System.out.println("There is books in your computer");
			return readedBooks;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ArrayList<Book>();
		}
	}
}