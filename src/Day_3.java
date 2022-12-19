import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_3 {
    static ArrayList<ArrayList<Character>> first = new ArrayList<ArrayList<Character>>(), second = new ArrayList<ArrayList<Character>>();
    static ArrayList<ArrayList<Character>> rucksack = new ArrayList<ArrayList<Character>>();

    public void sumPriority() {
        int sum = 0;

        for(int i = 0; i < first.size(); i++) {
            for (char c : first.get(i)) {
                if (second.get(i).contains(c)) {
                    sum += getPriority(c);
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public void sumPrioritPart2() {
        int sum = 0;

        for (int i = 0; i < rucksack.size(); i += 3) {
            for (char c : rucksack.get(i)) {
                if (rucksack.get(i + 1).contains(c)) {
                    if (rucksack.get(i + 2).contains(c)) {
                        sum += getPriority(c);
                        break;
                    }
                }
            }
        }
        System.out.println("The triple priority is: " + sum);
    }

    public void load() throws FileNotFoundException {
        String line;
        Scanner input = new Scanner(new File("inputDay3"));
        ArrayList<Character> charFirst, charSecond, sack;

        while (input.hasNextLine()) {
            line = input.nextLine();
            charFirst = new ArrayList<Character>();
            charSecond = new ArrayList<Character>();
            sack = new ArrayList<Character>();

            for (int i = 0; i < line.length(); i++) {
                sack.add(line.charAt(i));
            }

            for (int x = 0; x < line.length()/2; x++) {
                charFirst.add(line.charAt(x));
                charSecond.add(line.charAt(x + (line.length()/2)));
            }

            first.add(charFirst);
            second.add(charSecond);
            rucksack.add(sack);
        }
        //System.out.println("THERE ARE " + first.size() + " PACKS");
    }

    public int getPriority(char value) {
        String index = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < index.length(); i++) {
            if (value == index.charAt(i)) return (i + 1);
        }
        return -1;
    }
}
