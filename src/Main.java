import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int day;
		Scanner input = new Scanner(System.in);
		int answer = 1;
		String temp;

		while(answer == 1) {
			answer = 0;
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
					d4.splitList();
					d4.part1();
					d4.part2();
					break;

				case 5:
					break;

				case 6:
					break;

				case 7:
					break;

				case 8:
					break;

				case 9:
					break;

				case 10:
					break;

				case 11:
					break;

				case 12:
					break;

				case 13:
					break;

				case 14:
					break;

				case 15:
					break;

				case 16:
					break;

				case 17:
					break;

				case 18:
					break;

				case 19:
					break;

				case 20:
					break;

				case 21:
					break;

				case 22:
					break;

				case 23:
					break;

				case 24:
					break;

				case 25:
					break;

			}
			while (answer != 1 && answer != 2) {
				System.out.println("\n\nGo again? y/N");
				temp = input.nextLine();
				answer = 3;
				if (temp.equals("n") || temp.equals("N")) answer = 2;
				if (temp.equals("y") || temp.equals("Y")) answer = 1;
				if (temp.equals("")) answer = 2;
			}
		}
	}

	public static int choose_Day() {
		int day = 0;
		boolean again = true;
		Scanner input = new Scanner(System.in);
		while (again) {
			try {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				again = false;
				System.out.println("\n\nSelect day (1-25 only):> ");
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
