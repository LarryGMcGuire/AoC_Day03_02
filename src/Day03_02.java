    import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Day03_02 {

    // Advent of Code 2022 Day 3   Part 2
    //  Read about the problem here  https://adventofcode.com/2022/day/3#part2

    public static void main(String[] args) throws IOException, FileNotFoundException{
        Path current = Paths.get(".");
        String s = current.toAbsolutePath().toString();
        System.out.println("Path" + s);

        File inputTxt = new File("src/2022/day01/input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputTxt));
        String firstRuck, secondRuck, thirdRuck;
        String x, y;
        String[] split;

        ArrayList<String> xyzList = new ArrayList<>();
        int pointsValue = 0;

        while ((firstRuck = input.readLine()) != null){
            secondRuck = input.readLine();
            thirdRuck = input.readLine();
            System.out.println(" ");
            System.out.println("First Ruck : " +firstRuck);
            System.out.println("Second Ruck : " +secondRuck);
            System.out.println("Third Ruck : " + thirdRuck);


            int points = 0;
            // Look through the first Rucksack.  Does anything also appear in the second rucksack?
            for (int j=0; j<firstRuck.length() && points ==0 ; j++) {
                char c = firstRuck.charAt(j);
                //Is this in the second rucksack?
                for (int k=0; k<secondRuck.length(); k++) {
                    if (c == secondRuck.charAt(k)) {
                        System.out.println("We have a match in the second rucksack! " + c);

                        // Is it in the third rucksack?
                        for (int m=0; m<thirdRuck.length(); m++) {
                            if (c == thirdRuck.charAt(m)) {
                                System.out.println("We have a match in the Third rucksack! " + c);

                                // What is that match worth?

                                int castAscii = (int) c;
                                if (castAscii >= 97 && castAscii <= 122) {
                                    points = castAscii - 96;
                                } else {
                                    points = castAscii - 38;
                                }
                                System.out.println("    castAScii value: " + castAscii);
                                System.out.println("    points value: " + points);
                                pointsValue += points;
                                System.out.println("     running total points value: " + pointsValue);

                                break;
                            }
                        }
                        break;
                    }
                }

            }

        }
        input.close();




        System.out.println("  POINTS VALUE = " + pointsValue);

    }

}
