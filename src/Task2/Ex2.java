package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("task1.txt"));

            Map<String, Integer> statistics = new TreeMap<>();
            //int max = 1;
            while (sc.hasNext()) {
                String word = sc.useDelimiter("\\s+").next();
                Integer count = statistics.get(word);

                if (count == null) {
                    count = 0;
                }
                statistics.put(word, ++count);
            }
            System.out.println(statistics);
            //Collections.max(statistics.entrySet(), Comparator.comparing(Map.Entry::getValue));

//                if (count >= max) {
//                    max = count;
//                }
            int max = Collections.max(statistics.values());
            for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
                Integer value = entry.getValue();
                if (value == max) {
                    System.out.println("Наибольшее число повторений: " + entry.getKey() + "=" + entry.getValue());
                } else {
                    System.out.println("Наибольшее число повторений: " + Collections.max(statistics.entrySet(), Comparator.comparing(Map.Entry::getValue)));
                } }

                    //System.out.println("Max: " + max);
                    //System.out.println("Наибольшее число повторений: " + Collections.max(statistics.entrySet(), Comparator.comparing(Map.Entry::getValue)));


                } catch(FileNotFoundException sc){
                    System.out.println("File Not found");
                }

            }
        }
