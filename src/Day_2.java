import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_2 {
    static ArrayList<Character> them = new ArrayList<Character>();
    static ArrayList<Character> me = new ArrayList<Character>();
    static ArrayList<Integer> themInt = new ArrayList<Integer>();
    static ArrayList<Integer> meInt = new ArrayList<Integer>();

    public int matchResult(int them, int me) {
        //0 = Draw, 1 = I win, 2 = They win
        switch(them) {
            case 1:
                if(me == 2) return 1;
                if(me == 3) return 2;
                break;
            case 2:
                if(me == 1) return 2;
                if(me == 3) return 1;
                break;
            case 3:
                if(me == 1) return 1;
                if(me == 2) return 2;
                break;
        }
        return 0;
    }

    public void topSecretPlan() {
        //X = I lose, Y = Draw, Z = I win
        //1 = ROCK, 2 = PAPER, 3 = SCISSORS

        int myScore = 0, theirScore = 0;
        for (int i = 0; i < themInt.size(); i++) {
            switch(me.get(i)){
                case 'X':
                    if(themInt.get(i) == 1) {
                        theirScore += 6 + 1;
                        myScore += 3;
                    }
                    if(themInt.get(i) == 2) {
                        theirScore += 6 + 2;
                        myScore += 1;
                    }
                    if(themInt.get(i) == 3) {
                        theirScore += 6 + 3;
                        myScore += 2;
                    }
                    break;
                case 'Y':
                    theirScore += themInt.get(i) + 3;
                    myScore += themInt.get(i) + 3;
                    break;
                case 'Z':
                    if(themInt.get(i) == 1) {
                        theirScore += 1;
                        myScore += 8;
                    }
                    if(themInt.get(i) == 2) {
                        theirScore += 2;
                        myScore += 9;
                    }
                    if(themInt.get(i) == 3) {
                        theirScore += 3;
                        myScore += 7;
                    }
                    break;
            }
        }
        System.out.println("\n*****AFTER FOLLOWING TOP SECRET PLAN*****");
        System.out.println("ME: " + myScore + " || THEM: " + theirScore);
    }

    public void gameSolution() {
        int myScore = 0, theirScore = 0, result = 0;
        for (int i = 0; i < themInt.size(); i++) {
            result = matchResult(themInt.get(i), meInt.get(i));
            switch (result) {
                case 0:
                    theirScore += themInt.get(i) + 3;
                    myScore += meInt.get(i) + 3;
                    break;
                case 1:
                    theirScore += themInt.get(i);
                    myScore += meInt.get(i) + 6;
                    break;
                case 2:
                    theirScore += themInt.get(i) + 6;
                    myScore += meInt.get(i);
                    break;
            }
        }
        System.out.println("ME: " + myScore + " || THEM: " + theirScore);
    }



    public void test() {
        int i = 0;
        for(char c : them) {
            System.out.println("THEM: " + c + " & ME: " +  me.get(i));
            i++;
        }
    }

    public void load() throws FileNotFoundException {
        String line;
        Scanner input = new Scanner(new File("input2"));
        char[] round = new char[2];

        while (input.hasNextLine()){
            line = input.nextLine();
            round[0] = line.charAt(0);
            round[1] = line.charAt(2);
            them.add(round[0]);
            me.add(round[1]);
            switch(line.charAt(0)) {
                case 'A': themInt.add(1);
                    break;
                case 'B': themInt.add(2);
                    break;
                case 'C': themInt.add(3);
                    break;
            }
            switch(line.charAt(2)) {
                case 'X': meInt.add(1);
                    break;
                case 'Y': meInt.add(2);
                    break;
                case 'Z': meInt.add(3);
                    break;
            }
        }
    }
}
