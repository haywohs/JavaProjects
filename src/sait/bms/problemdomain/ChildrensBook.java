package sait.bms.problemdomain;

/**
 * 
 * Children's book is a subclass
 *
 */
public class ChildrensBook extends Book {

	private String authors;
	private String format;

	/**
	 * 
	 * @param isbn       of children's book
	 * @param callNumber of children's book
	 * @param available  of children's book
	 * @param total      of children's book
	 * @param title      of children's book
	 * @param authors    of children's book
	 * @param format     of children's book
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors,
			String format) {
		super(isbn, callNumber, available, total, title);
		this.format = format;
		this.authors = authors;
	}

	/**
	 * 
	 * @return author of children's book
	 */
	public String getAuthor() {
		return authors;
	}

	/**
	 * 
	 * @param authors of children's book
	 */
	public void setAuthor(String authors) {
		this.authors = authors;
	}

	/**
	 * 
	 * @return format of children's book
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 
	 * @param format of children's book
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Print format of children's book
	 */
	@Override
	public String getPrintFormat() {
		return super.getPrintFormat() + ";" + authors + ";" + format;
	}

	/**
	 * change to String type and represent them.
	 */
	@Override
	public String toString() {
		String formatString = (format.equals("P")) ? "P" : (format.equals("E")) ? "E" : "C";
		String newStuff = String.format("%-18s%s\n%-18s%s\n", "Authors:", authors, "Format:", formatString);
		return super.toString() + newStuff;
	}

}
