package maven_projects.console_library_new;

public class Book {
	private String Name;
	private String Author;
	private int PagesCount;
	
	public Book(String name, String author, int pagesCount) {
		this.Name = name;
		this.Author = author;
		this.PagesCount = pagesCount;
	}

	public String toString() {
		return Name + ", " + Author + ", c." + PagesCount;
	}

	public String getAuthor() {
		return Author;
	}

	public String getName() {
		return Name;
	}

	public int getPagesCount() {
		return PagesCount;
	}

	public void setAuthor(String newAuthor) {
		Author = newAuthor;
	}

	public void setName(String newGenre) {
		Name = newGenre;
	}

	public void setPagesCount(int newPagesCount) {
		PagesCount = newPagesCount;
	}
}
