package sait.bms.problemdomain;

/**
 * ISBN, Call number, Available, Total and Title
 * 
 * Book is a superclas.
 */

public abstract class Book {
	private long isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	public Book() {

	}

	/**
	 * 
	 * @param isbn       of book
	 * @param callNumber of book
	 * @param available  of book
	 * @param total      of book
	 * @param title      of book name
	 */
	public Book(long isbn, String callNumber, int available, int total, String title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * 
	 * @return isbn of book
	 */
	public long getISBN() {
		return isbn;
	}

	/**
	 * 
	 * @param isbn of book
	 */
	public void setISBN(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * 
	 * @return call Number of book
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * 
	 * @param callNumber of book
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * 
	 * @return available books
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * 
	 * @param available books
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * 
	 * @return total of books
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total of books
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 
	 * @return title of book name
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title of book name
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return PrintFormat of books
	 */
	public String getPrintFormat() {
		return this.isbn + ";" + this.callNumber + ";" + this.available + ";" + this.total + ";" + this.title;
	}

	/**
	 * change to String type and represent them.
	 */
	public String toString() {
		return String.format("%-18s%s\n%-18s%s\n%-18s%d\n%-18s%d\n%-18s%s\n", "ISBN:", this.isbn, "Call Number:",
				this.callNumber, "Available:", this.available, "Total:", this.total, "Title:", this.title);
	}
}
