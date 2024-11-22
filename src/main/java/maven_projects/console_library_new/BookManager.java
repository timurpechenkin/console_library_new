package maven_projects.console_library_new;

import java.util.*;

import com.google.gson.Gson;

public class BookManager {
	private ArrayList<Book> books;

	public BookManager(ArrayList<Book> books) {
		this.books = books;
	}

	public void get(String supplement) {
		try {
			BookFilter bookFilter = new BookFilter(supplement);
			ArrayList<Book> expectedBooks = new ArrayList<>();
			for (Book book : books) {
				if (bookFilter.fits(book))
					expectedBooks.add(book);
			}
			if (expectedBooks.isEmpty())
				System.out.println("There is no books with this parameters");
			else {
				Book[] expectedBooksArray = new Book[expectedBooks.size()];
				for (int i = 0; i < expectedBooks.size(); i++) {
					expectedBooksArray[i] = expectedBooks.get(i);
				}
				ResultBooks resultBooks = new ResultBooks(expectedBooksArray);
				Gson gson = new Gson();
				String result = gson.toJson(resultBooks);
				System.out.println(result);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void post(String supplement) {
		Gson gson = new Gson();
		try {
			Book book = gson.fromJson(supplement, Book.class);
			books.add(book);
			System.out.println("The book was added");
		} catch (Exception ex) {
			System.out.println("Command`s supplement is not a JSON");
		}
	}

//    public void delete(){
//        System.out.print("delete a book command");
//    }
//
//    public void put(){
//        System.out.print("edit a book command");
//    }

}
