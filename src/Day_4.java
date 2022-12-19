import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day_4 {
    static ArrayList<String> initList = new ArrayList<String>();
    static ArrayList<ArrayList<Integer>> rangeList = new ArrayList<ArrayList<Integer>>();

    public void part1() {
        int overlap = 0;
        ArrayList<Integer> temp1, temp2;

        for (ArrayList<Integer> l : rangeList) {
            for(int i : l){

            }
        }
    }

    public void splitList() {
        ArrayList<Integer> tempRange;
        String[] tempList;
        String[] tempList2;
        String temp;

        for(String s : initList) {
            tempRange = new ArrayList<Integer>();

            tempList = s.split(",");

            tempList2 = tempList[0].split("-");
            tempRange.add(Integer.parseInt(tempList2[0]));
            tempRange.add(Integer.parseInt(tempList2[1]));

            tempList2 = tempList[1].split("-");
            tempRange.add(Integer.parseInt(tempList2[0]));
            tempRange.add(Integer.parseInt(tempList2[1]));

            rangeList.add(tempRange);
        }
    }

    public void load() throws FileNotFoundException {
        String fname = "input4.txt";
        LoadUtil loader = new LoadUtil();

        initList.addAll(loader.load(fname));
    }

    public void test() {
        for (String s : initList) {
            System.out.println(s);
        }
        System.out.println("THERE ARE: " + initList.size() + " ITEMS.");
    }



}
