import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int day = 0;
		day = choose_Day();

		switch (day) {
			case 1:
				Day_1 today = new Day_1();
				today.load();
				// today.test();
				System.out.println(today.greatest());
				System.out.println(today.topThree());
				break;

			case 2:
				Day_2 d2 = new Day_2();
				d2.load();
				//d2.test();
				d2.gameSolution();
				d2.topSecretPlan();
				break;

			case 3:
				Day_3 d3 = new Day_3();
				d3.load();
				d3.sumPriority();
				d3.sumPrioritPart2();
				break;

			case 4:
				Day_4 d4 = new Day_4();
				d4.load();
				//d4.test();
				d4.splitList();
				d4.part1();
				d4.part2();

		}

	}

	public static int choose_Day() {
		int day = 0;
		boolean again = true;
		Scanner input = new Scanner(System.in);
		while (again) {
			try {
				again = false;
				System.out.println("Select day (1-25 only):> ");
				day = Integer.parseInt(input.nextLine());
				while (day < 1 || day > 25) {
					System.out.println("Enter a number from 1 to 25 only, try again:> ");
					day = Integer.parseInt(input.nextLine());
				}
			} catch (Exception e) {
				System.out.println("Error, only integers are accepted.");
				again = true;
				System.out.println("\n");
			}
		}
		return day;
	}

}
