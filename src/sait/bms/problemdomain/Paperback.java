package sait.bms.problemdomain;

/**
 * 
 * Paperback is a subclass.
 *
 */
public class Paperback extends Book {
	private String authors;
	private int year;
	private String genre;

	/**
	 * constructor
	 */
	public Paperback() {

	}

	/**
	 * 
	 * @param isbn       of paperback
	 * @param callNumber of paperback
	 * @param available  of paperback
	 * @param total      of paperback
	 * @param title      of paperback
	 * @param authors    of paperback
	 * @param year       of paperback
	 * @param genre      of paperback
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title, String authors, int year,
			String genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * 
	 * @return author of paperback
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * 
	 * @param authors of paperback
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * 
	 * @return year of paperback
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year of paperback
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @return genre of paperback
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 
	 * @param genre of paperback
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Print format of paperback
	 */
	@Override
	public String getPrintFormat() {
		return super.getPrintFormat() + ";" + authors + ";" + year + ";" + genre;
	}

	/**
	 * change to String type and represent them.
	 */
	@Override
	public String toString() {
		String tempGenre = "";
		switch (genre) {
		case "A":
			tempGenre = "Adventure";
			break;
		case "D":
			tempGenre = "Drama";
			break;
		case "E":
			tempGenre = "Education";
			break;
		case "C":
			tempGenre = "Classic";
			break;
		case "F":
			tempGenre = "Fantasy";
			break;
		case "S":
			tempGenre = "Science Fiction";
			break;
		}
		String f = String.format("%-18s%s\n%-18s%d\n%-18s%s\n", "Authors:", authors, "Year:", year, "Genre:",
				tempGenre);
		return super.toString() + f;
	}
}
