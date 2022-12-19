import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day_4 {
    static ArrayList<String> initList = new ArrayList<String>();
    static ArrayList<ArrayList<Range>> rList = new ArrayList<ArrayList<Range>>();
    String fname = "input4.txt";

    public void part1() {
        //First attempt: answer = 162, too low
        //Second attempt: answer = 493, too high
        //Third attempt: answer = 490, correct
        //the error was using two if statements rather than if + else if

        int overlap = 0;

        for (ArrayList<Range> r : rList) {
            //System.out.println(r.get(0).getLow() + "-" + r.get(0).getHigh() + "," + r.get(1).getLow() + "-" + r.get(1).getHigh());

            if(r.get(0).containsRange(r.get(1))) {
                overlap++;
                System.out.println(r.get(0).getLow() + "-" + r.get(0).getHigh() + "," + r.get(1).getLow() + "-" + r.get(1).getHigh());
            }
            else if(r.get(1).containsRange(r.get(0))) {
                overlap++;
                System.out.println(r.get(0).getLow() + "-" + r.get(0).getHigh() + "," + r.get(1).getLow() + "-" + r.get(1).getHigh());
            }

        }

        System.out.println("There are " + overlap + " total overlaps in PART 1.");
    }

    public void part2() {
        int overlap = 0;

        for (ArrayList<Range> r : rList) {
            //System.out.println(r.get(0).getLow() + "-" + r.get(0).getHigh() + "," + r.get(1).getLow() + "-" + r.get(1).getHigh());

            if (r.get(0).contains(r.get(1).getLow())) overlap++;
            else if (r.get(0).contains(r.get(1).getHigh())) overlap++;
            else if (r.get(1).contains(r.get(0).getLow())) overlap++;
            else if (r.get(1).contains(r.get(0).getHigh())) overlap++;

        }

        System.out.println("There are " + overlap + " total overlaps in PART 2.");
    }

    /*
    splitList takes the initial ArrayList<String> loaded from file and processes it
    into an ArrayList of ArrayList<Range>
     */
    public void splitList() {
        String[] tempList;
        String[] tempList2;
        ArrayList<Range> tempRList;
        Range tempR;

        for(String s : initList) {
            tempR = new Range();
            tempRList = new ArrayList<Range>();

            //Splits the list into two ranges
            tempList = s.split(",");
            //Splits the first range into two halves
            tempList2 = tempList[0].split("-");

            //populates the first Range var and adds it to the temp list of Ranges
            tempR.range(Integer.parseInt(tempList2[0]), Integer.parseInt(tempList2[1]));
            tempRList.add(tempR);
            tempR = new Range();

            //splits the second range into two halves
            tempList2 = tempList[1].split("-");

            //populates the second Range var and adds it to the temp list of Ranges
            tempR.range(Integer.parseInt(tempList2[0]), Integer.parseInt(tempList2[1]));
            tempRList.add(tempR);
            rList.add(tempRList);

        }
        System.out.println("rList SIZE = " + rList.size());
    }

    public void load() throws FileNotFoundException {
        LoadUtil loader = new LoadUtil();

        initList.addAll(loader.load(fname));
    }
}
