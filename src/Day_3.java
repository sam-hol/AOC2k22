import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_3 {
    static ArrayList<ArrayList<Integer>> packFirst = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> packSecond = new ArrayList<ArrayList<Integer>>();
    //static ArrayList<String> listFirst = new ArrayList<String>(), listSecond = new ArrayList<String>();
    static ArrayList<ArrayList<Character>> first = new ArrayList<ArrayList<Character>>(), second = new ArrayList<ArrayList<Character>>();

    public void sumPriority() {
        int sum = 0;
        char temp = 0;
        //ArrayList<Character> tempList = new ArrayList<Character>();

        for(int i = 0; i < first.size(); i++) {
            for (char c : first.get(i)) {
                if (second.get(i).contains(c)) {
                    temp = c;
                }
            }
            sum += getPriority(temp);
        }

        /*
        for (int listLength = 0; listLength < listFirst.size(); listLength++) {
            tempList = new ArrayList<Character>();
            for (Character c : listFirst.get(listLength).toCharArray()) {
                for (Character d : listSecond.get(listLength).toCharArray()) {
                    tempList.add(d);
                }
                if (tempList.contains(c)) {
                    sum += getPriority(c);
                }
            }
        }

         */

        /*
        for (int i = 0; i < packFirst.size(); i++) {
            for (int x = 0; x < packFirst.get(i).size(); x++) {
                if (packSecond.get(i).contains(packFirst.get(i).get(x))) {
                    sum += packFirst.get(i).get(x);
                    x = packFirst.get(i).size();
                }
            }
        } */

        System.out.println(sum);
    }

    public void load() throws FileNotFoundException {
        String line;
        String[] halves;
        int mid;
        Scanner input = new Scanner(new File("inputDay3"));
        char[] round = new char[2];
        ArrayList<Integer> priosFirst = new ArrayList<Integer>();
        ArrayList<Integer> priosSecond = new ArrayList<Integer>();
        ArrayList<Character> charFirst = new ArrayList<Character>();
        ArrayList<Character> charSecond = new ArrayList<Character>();
        ArrayList<Character> common = new ArrayList<Character>();

        while (input.hasNextLine()) {
            line = input.nextLine();
            charFirst = new ArrayList<Character>();
            charSecond = new ArrayList<Character>();

            for (int x = 0; x < line.length()/2; x++) {
                charFirst.add(line.charAt(x));
                charSecond.add(line.charAt(x + (line.length()/2)));
            }

            first.add(charFirst);
            second.add(charSecond);
            //System.out.println("SIZE OF FIRST HALF " + charFirst.size());
            //System.out.println("SIZE OF SECOND HALF " + charSecond.size());
        }

        System.out.println("THERE ARE " + first.size() + " PACKS");
    }

    public int getPriority(char value) {
        String index = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < index.length(); i++) {
            if (value == index.charAt(i)) return (i + 1);
        }
        return -1;
    }
}
