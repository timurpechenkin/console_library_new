package maven_projects.console_library_new;

import java.util.*;
import com.google.gson.Gson;

public class BookManager {
	private ArrayList<Book> books;

	public BookManager(ArrayList<Book> books) {
		this.books = books;
	}

	public void get(String supplement) {
		ArrayList<Book> expectedBooks = new ArrayList<>();
		for (Book book : books) {
			expectedBooks.add(book);
		}
		Book[] expectedBooksArray = new Book[expectedBooks.size()];
		for (int i = 0; i<expectedBooks.size(); i++) {
			expectedBooksArray[i]=expectedBooks.get(i);
		}
		Gson gson = new Gson();
		String res = gson.toJson(expectedBooksArray);
		System.out.println(res);

//        for(Book book: books){
//            if(book.getName().equals(supplement[0])) expectedBooks.add(book);
//        }
//        if(expectedBooks.isEmpty()){
//            System.out.println("There is no such books");
//        }
//        else {
//            for (Book book: expectedBooks) System.out.println(book.toString());
//        }
	}

	public void post(String supplement) {
		Gson gson = new Gson();
		Book book = gson.fromJson(supplement, Book.class);
		books.add(book);
		System.out.println("The book was added");
	}

//    public void delete(){
//        System.out.print("delete a book command");
//    }
//
//    public void put(){
//        System.out.print("edit a book command");
//    }

}
