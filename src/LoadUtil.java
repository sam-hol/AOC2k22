import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadUtil
{
    public ArrayList<String> load(String fname) throws FileNotFoundException {
        ArrayList<String> tempList = new ArrayList<String>();
        Scanner input = new Scanner(new File(fname));

        while(input.hasNextLine()) {
            tempList.add(input.nextLine());
        }
        return tempList;
    }

}
