import javax.xml.transform.Source;
import java.util.Scanner;
import java.math.MathContext;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class GenerateArray {

    public static void genArr() {
        //Define length of array
        Scanner lenObj = new Scanner(System.in);
        System.out.println("How many numbers would you like in the array?");
        int arrLen = lenObj.nextInt(), sum = 0;
        int[] randomArray = new int[arrLen];

        //Request for number generation range: range = {min =< x =< max}
        Scanner rangeObj = new Scanner(System.in);
        rangeObj.useDelimiter("[\\s,\r\n]+");    //Ignores commas and spaces or whatever found in input
        System.out.println("What is the range (Min Max) of the array?");

        int arrMin = rangeObj.nextInt(), arrMax = rangeObj.nextInt(), counter = 0;

        //Generate random numbers within range and place into new array
        for (int v : randomArray){
            int randomNum = ThreadLocalRandom.current().nextInt(arrMin, arrMax + 1);
            randomArray[counter] = randomNum;
            counter++;
            sum += randomNum;
        }

        float avg = (float) sum/randomArray.length;
        //System.out.println("The average of this array is: " + avg);

        Main.sortArray(randomArray, avg);
    }
}
