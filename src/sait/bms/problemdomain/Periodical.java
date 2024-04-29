package sait.bms.problemdomain;

/**
 * 
 * Periodical is a subclass.
 *
 */
public class Periodical extends Book {
	private String frequency;

	/**
	 * constructor
	 */
	public Periodical() {

	}

	/**
	 * 
	 * @param isbn       of periodical
	 * @param callNumber of periodical
	 * @param available  of periodical
	 * @param total      of periodical
	 * @param title      of periodical
	 * @param frequency  of periodical
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, String frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * 
	 * @return frequency of periodical
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * 
	 * @param frequency of periodical
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * Print format of periodical
	 */
	@Override
	public String getPrintFormat() {
		return super.getPrintFormat() + ";" + frequency;
	}

	/**
	 * change to String type and represent them.
	 */
	@Override
	public String toString() {
		String tempFrequency = "";
		switch (frequency) {
		case "D":
			tempFrequency = "Daily";
			break;
		case "W":
			tempFrequency = "Weekly";
			break;
		case "M":
			tempFrequency = "Monthly";
			break;
		case "B":
			tempFrequency = "Bi-Monthly";
			break;
		case "Q":
			tempFrequency = "Quarterly";
			break;
		}
		String f = String.format("%-18s%s\n", "Frenquency:", tempFrequency);
		return super.toString() + f;
	}
}
