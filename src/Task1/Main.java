package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] arg) {
        ArrayList<Word> arr = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("task1.txt"));
            while (sc.hasNextLine()) {
                String value = sc.useDelimiter("\\s+").next();
                Word word = new Word(value);
                //arr.add(sc.useDelimiter("\\s+").next());
                if (arr.contains(word)) {
                    arr.get(arr.indexOf(word)).count++;
                } else arr.add(word);
            }
            sc.close();

        } catch (FileNotFoundException sc) {
            System.out.println("File Not found");
        }
        System.out.println("Not sorted mass: " + arr);

        Collections.sort(arr, Comparator.comparingInt(o -> o.count));
        System.out.println("Sorted mass: " + arr);
        Collections.reverse(arr);


        ArrayList<Word> max = new ArrayList<>();
        int x = 0;
        int k = arr.size();
        for (int i = 0; i < k; i++) {
            Word temp = arr.get(0);
            if (x <= temp.count) {
                x = temp.count;
                arr.remove(temp);
                max.add(temp);
            } else break;
        }

        System.out.println("Maxed: " + max.toString());
        System.out.println("----------------------");
    }
}
