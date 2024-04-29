package sait.bms.managers;

/**
 * Manage a list of books
 */
import sait.bms.problemdomain.*;

import java.io.*;

import java.net.URL;
import java.util.*;

public class BookManager {
	private ArrayList<Book> books;

	/**
	 * constructor
	 */
	public BookManager() {
		this.books = new ArrayList<Book>();
	}

	/**
	 * Read file from resource
	 */
	public void readFile() {
		this.books.clear(); // reset ArrayList before reading the file;

		File file = new File("./res/books.txt");

		try {
			Scanner input = new Scanner(file);
			input.useDelimiter(";|\n|\r\n");
			while (input.hasNext()) {
				long ISBN = input.nextLong();
				String callNumber = input.next();
				int available = input.nextInt();
				int total = input.nextInt();
				String title = input.next();

				long lastDigit = ISBN % 10L;
				if (lastDigit == 0 || lastDigit == 1) {
					String author = input.next();
					String format = input.next();
					ChildrensBook children = new ChildrensBook(ISBN, callNumber, available, total, title, author,
							format);
					this.books.add(children);
				} else if (lastDigit == 2 || lastDigit == 3) {
					String publisher = input.next();
					String diet = input.next();
					CookBook cook = new CookBook(ISBN, callNumber, available, total, title, publisher, diet);
					this.books.add(cook);
				} else if (lastDigit >= 4 && lastDigit <= 7) {
					String author = input.next();
					int year = input.nextInt();
					String genre = input.next();
					Paperback paper = new Paperback(ISBN, callNumber, available, total, title, author, year, genre);
					this.books.add(paper);
				} else if (lastDigit == 8 || lastDigit == 9) {
					String frequency = input.next();
					Periodical period = new Periodical(ISBN, callNumber, available, total, title, frequency);
					this.books.add(period);
				}
			}

		} catch (FileNotFoundException e) {
			// do nothing
		}

	}

	/**
	 * Write data in the file.
	 */
	// when the program exits, things from ArrayList send into books.txt
	public void writeFile() {

		File file = new File("./res/books.txt");

		try {
			/*
			 * want to save the changes that were made by users and save books which are in
			 * this.books(ArrayList) back to the file.
			 */
			PrintWriter output = new PrintWriter(file);
			for (int i = 0; i < this.books.size(); i++) {
				output.println(this.books.get(i).getPrintFormat());
			}
			output.close();
		} catch (FileNotFoundException e) {
			// do nothing
		}
	}

	/**
	 * 
	 * @param ISBN of books
	 * @return boolean value to know book's available
	 */
	public boolean checkout(long ISBN) {
		for (int i = 0; i < this.books.size(); i++) {
			Book b = this.books.get(i);
			if (b.getISBN() == ISBN) {
				if (b.getAvailable() > 0) {
					b.setAvailable(b.getAvailable() - 1);
					System.out.println(b);
					System.out.printf("The book \"%s\" has been checked out.\n", b.getTitle());
					System.out.printf("It can be located using a call number: %s\n", b.getCallNumber());
					return true;
				}
			}
		}
		System.out.println("Sorry, it is unavailable.\n");
		return false;
	}

	/**
	 * 
	 * @param searchTerm search the related title
	 */
	public void findBooks(String searchTerm) {
		boolean flag = true;
		for (int i = 0; i < this.books.size(); i++) {
			Book b = this.books.get(i);
			if (b.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
				System.out.println(b);
				flag = false;
				continue;
			}
			if (i == (this.books.size() - 1) && flag) {
				System.out.println("\nSorry, no related book.\n");
			}
		}
	}

	/**
	 * 
	 * @param typeOfBook type of book
	 * @param filter     4 different type books
	 */
	public void displayBooks(int typeOfBook, String filter) {
		for (int i = 0; i < this.books.size(); i++) {
			Book b = this.books.get(i);
			if (typeOfBook == 1 && b instanceof ChildrensBook) {
				ChildrensBook child = (ChildrensBook) b;
				if (child.getFormat().equals(filter)) {
					System.out.println(child);
				}

			} else if (typeOfBook == 2 && b instanceof CookBook) {
				CookBook cook = (CookBook) b;
				if (cook.getDiet().equals(filter)) {
					System.out.println(cook);
				}

			} else if (typeOfBook == 3 && b instanceof Paperback) {
				Paperback paper = (Paperback) b;
				if (paper.getGenre().equals(filter)) {
					System.out.println(paper);
				}

			} else if (typeOfBook == 4 && b instanceof Periodical) {
				Periodical period = (Periodical) b;
				if (period.getFrequency().equals(filter)) {
					System.out.println(period);
				}

			}
		}
	}

	/**
	 * 
	 * @param numberOfBooks how many books random to show
	 */
	public void produceBooks(int numberOfBooks) {
		Collections.shuffle(this.books);
		for (int i = 0; i < numberOfBooks && i < this.books.size(); i++) {
			System.out.println(this.books.get(i));
		}
	}

}
