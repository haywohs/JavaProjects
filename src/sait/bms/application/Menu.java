package sait.bms.application;

/**
 * Print the application menu
 */
import java.util.*;

import sait.bms.managers.BookManager;

public class Menu {

	public static void main(String[] args) {

		BookManager bookManage = new BookManager();
		bookManage.readFile();
		boolean repeat = true;
		while (repeat) {
			System.out.print("Welcome in ABC Book Company: How May We Assist You?\n" + "1\tCheckout Book\n"
					+ "2\tFind Books by Title\n" + "3\tDisplay Books by Type\n" + "4\tProduce Random Book List\n"
					+ "5\tSave & Exit\n");
			System.out.print("\nEnter option: ");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();

			switch (num) {
			case 1:
				System.out.print("\nEnter ISBN of book: ");
				long isbn = in.nextLong();
				bookManage.checkout(isbn);
				break;
			case 2:
				System.out.print("\nEnter title to search for: ");
				String title = in.next();
				System.out.println("\nMatching books:");
				bookManage.findBooks(title);
				break;
			case 3:
				System.out.print("\n#\tType\n1\tChildren's Books\n2\tCookbooks\n3\tPaperbacks\n4\tPeriodicals\n");
				System.out.print("\nEnter type of book: ");
				int type = in.nextInt();
				if (type == 1) {
					System.out.print(
							"\nEnter a format(P for Picture book, E for Early Readers, or C for Chapter book.): ");
					String format = in.next();
					System.out.println("\nMatching books:");
					bookManage.displayBooks(type, format);
					break;
				} else if (type == 2) {
					System.out.print(
							"\nEnter a diet(D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None.): ");
					String diet = in.next();
					System.out.println("\nMatching books:");
					bookManage.displayBooks(type, diet);
					break;
				} else if (type == 3) {
					System.out.print(
							"\nEnter a genre(A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction.): ");
					String genre = in.next();
					System.out.println("\nMatching books:");
					bookManage.displayBooks(type, genre);
					break;
				} else {
					System.out.print(
							"\nEnter a frenquency(D for Daily, W for Weekly, M for Monthly, B for Bimonthly, and Q for Quarterly.): ");
					String frequency = in.next();
					System.out.println("\nMatching books:");
					bookManage.displayBooks(type, frequency);
					break;
				}
			case 4:
				System.out.print("\nEnter number of books: ");
				int numberofBooks = in.nextInt();
				System.out.println("\nRandom books:");
				bookManage.produceBooks(numberofBooks);
				break;
			case 5:
				System.out.print("\nYou are leaving system now, bye!");
				bookManage.writeFile();
				repeat = false;
			}
		}
	}
}
