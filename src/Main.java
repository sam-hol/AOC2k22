import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
