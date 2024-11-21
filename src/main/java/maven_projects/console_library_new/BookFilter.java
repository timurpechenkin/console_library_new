package maven_projects.console_library_new;

public class BookFilter {
	private String name;
	private String author;
	private int pagesCount;
	private int pagesMore;
	private int pagesLess;

	public BookFilter(String supliment) throws Exception {
		String parameter;
		String value;
		int equalIndex;
		int questionIndex = supliment.indexOf('?');
		String[] parametersAndValues = supliment.substring(questionIndex + 1).split("&");
		for (String str : parametersAndValues) {
			equalIndex = str.indexOf('=');
			if (equalIndex < 1)
				throw new Exception("Query string is incorrect! There is no value");
			parameter = str.substring(0, equalIndex);
			value = str.substring(equalIndex + 1);
			switch (parameter) {
			case "name":
				name = value;
				break;
			case "author":
				author = value;
				break;
			case "pagescount":
				if (isInteger(value)) {
					pagesCount = Integer.parseInt(value);
				} else
					throw new Exception("Query string is incorrect! \"" + value + "\" is not integer");
				break;
			case "pagesmore":
				if (isInteger(value)) {
					pagesMore = Integer.parseInt(value);
				} else
					throw new Exception("Query string is incorrect! \"" + value + "\" is not integer");
				break;
			case "pagesless":
				if (isInteger(value)) {
					pagesLess = Integer.parseInt(value);
				} else
					throw new Exception("Query string is incorrect! \"" + value + "\" is not integer");
				break;
			default:
				throw new Exception("Query string is incorrect! There is no \"" + parameter + "\" parameter");
			}
		}
	}

	private boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				// В строке найден недопустимый символ.
				return false;
			}
		}

		// Если мы здесь, значит, строка содержит только цифры. 🎉
		return true;
	}

	public boolean fits(Book book) {
		boolean nameFilter = false;
		boolean authorFilter = false;
		boolean pagesCountFilter = false;
		boolean pagesLessFilter = false;
		boolean pagesMoreFilter = false;

		if (name == null || name.equals(book.getName()))
			nameFilter = true;
		if (author == null || author.equals(book.getAuthor()))
			authorFilter = true;
		if (pagesCount == 0 || pagesCount == book.getPagesCount())
			pagesCountFilter = true;
		if (pagesLess == 0 || pagesLess > book.getPagesCount())
			pagesLessFilter = true;
		if (pagesMore == 0 || pagesMore < book.getPagesCount())
			pagesMoreFilter = true;

		return nameFilter && authorFilter && pagesCountFilter && pagesLessFilter && pagesMoreFilter;
	}

	public void showValues() {
		System.out.println("Name: " + name + " Author: " + author + " pagesCount: " + pagesCount + " pagesMore: "
				+ pagesMore + " pagesLess: " + pagesLess);
	}
}
