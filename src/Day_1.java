import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day_1 {
	static ArrayList<Integer> calData = new ArrayList<Integer>();

	public void test() {
		for (int i : calData) {
			System.out.println(i);
		}
	}

	public int greatest() {
		return Collections.max(calData);
	}

	public int topThree() {
		int size = calData.size() - 1;
		int tt = calData.get(size) + calData.get(size - 1) + calData.get(size - 2);
		return tt;
	}

	public void load() {
		String nextLine;
		int calories = 0;

		try {
			Scanner scanner = new Scanner(new File("input1B"));
			while (scanner.hasNextLine()) {
				nextLine = scanner.nextLine();
				// System.out.println(nextLine);
				if (isInteger(nextLine)) {
					calories += Integer.parseInt(nextLine);
				} else {
					calData.add(calories);
					calories = 0;
					// scanner.nextLine();
				}
			}
			Collections.sort(calData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isInteger(String string) {
		try {
			Integer.valueOf(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
