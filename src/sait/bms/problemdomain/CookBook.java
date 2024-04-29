package sait.bms.problemdomain;

/**
 * 
 * CookBook is a subclass.
 *
 */
public class CookBook extends Book {
	private String publisher;
	private String diet;

	/**
	 * 
	 * @param isbn       of cook book
	 * @param callNumber of cook book
	 * @param available  of cook book
	 * @param total      of cook book
	 * @param title      of cook book name
	 * @param publisher  of cook book
	 * @param diet       of cook book
	 */
	public CookBook(long isbn, String callNumber, int available, int total, String title, String publisher,
			String diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * 
	 * @return publisher of cook book
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 
	 * @param publisher of cook book
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 
	 * @return diet of cook book
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * 
	 * @param diet of cook book
	 */
	public void setDiet(String diet) {
		this.diet = diet;
	}

	/**
	 * Print format of cook book
	 */
	@Override
	public String getPrintFormat() {
		return super.getPrintFormat() + ";" + publisher + ";" + diet;
	}

	/**
	 * change to String type and represent them.
	 */
	@Override
	public String toString() {
		switch (diet) {
		case "D":
			diet = "D";
			break;
		case "V":
			diet = "V";
			break;
		case "G":
			diet = "G";
			break;
		case "N":
			diet = "N";
			break;
		}

		String newStuff = String.format("%-18s%s\n%-18s%s\n", "Publisher:", publisher, "Diet:", diet);
		return super.toString() + newStuff;
	}
}
