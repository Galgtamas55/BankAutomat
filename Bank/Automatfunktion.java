package bankautomat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Automatfunktion implements EntryMethodes {
	private static String name;
	private static String password;
	private static String types;
	private static String entry;

	@Override
	public int enter(Scanner scan) {
		name = JOptionPane.showInputDialog("Welcome the bank application please give your name:");
		password = JOptionPane.showInputDialog("Please give your password: ");
		types = JOptionPane.showInputDialog("Please enter your bank type");
		entry = JOptionPane.showInputDialog(
				"Hello Mr/Mrs " + name + " Welcome to the " + types + " bank.\r\nPlease enter the amount:");
		int amount = Integer.parseInt(entry);
		JOptionPane.showMessageDialog(null, "This is your specified amount: " + amount + "Ft");
		return amount;
	}

	void App() {
		Scanner scan = new Scanner(System.in);
		int amount = enter(scan);
		List<Integer> money = numberMoney();
		moneyCalculator(amount, money);
		scan.close();
	}

	private static void moneyCalculator(int amount, List<Integer> money) {
		int secondHand = amount;
		int[] piece = new int[money.size()];
		for (int i = 0; i < money.size(); i++) {
			piece[i] = secondHand / money.get(i);
			secondHand = secondHand % money.get(i);
		}
		jOptional(piece);
	}

	private static void jOptional(int[] piece) {
		JOptionPane.showMessageDialog(null,
				"The 1 is:20_000, 2 is:10_000, 3 is:5_000, 4 is:2_000, 5 is:1_000,6 is:500,\r\n7 is:200, 8 is:100, 9 is:50, 10 is:20, 11 is:10, 12 is: 5");
		JOptionPane.showMessageDialog(null, Arrays.toString(piece) + " This is a machine return payment modifyre ");
		JOptionPane.showMessageDialog(null, "Thank you for using this application. Have a nice day.");
		System.exit(0);
	}

	private static List<Integer> numberMoney() {
		return List.of(20_000, 10_000, 5_000, 2_000, 1_000, 500, 200, 10, 50, 20, 10, 5);
	}
}
