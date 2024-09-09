//import javax.xml.transform.Source;
import java.util.Locale;
import java.util.Scanner;
//import java.math.MathContext;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.*;

public class Main {

    public static void main(String[] args) {

        GenerateArray randArr = new GenerateArray();

        Scanner createObj = new Scanner(System.in);
        System.out.println("Do you want to create an array?");
        String answer = (createObj.nextLine()).toLowerCase(Locale.ROOT);

        if ((answer.equals("yes"))) {
            randArr.genArr();
        } else {
            System.out.println("Goodbye then...");
            System.out.println("Until next time!");
        }
    }

    public static void everythingElse(int[] randomArray, int sum) {

        //int[][] randomArray = { {6, 1, 3, 7, 234, 5, 234, -1, -19, 10}, {256, 3, -4}};

//        Scanner indexObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter array you want to sort/search");
//
//        int index = indexObj.nextInt();  // Read user input

//        Scanner wordObj = new Scanner(System.in);
//        String targetWord = wordObj.nextLine();
//        System.out.println(targetWord.indexOf("at"));

//        for (int v : randomArray) {
//            System.out.println(v);
//        }

        for (int i = 0; i < randomArray.length - 1; i++) {
            for (int j = 0; j < (randomArray.length - 1) - i; j++) {
                if (randomArray[j] > randomArray[j+1]) {
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j+1];
                    randomArray[j+1] = temp;
                }
            }
        }

        int max = randomArray.length - 1, min = 0;

        Scanner targetObj = new Scanner(System.in);
        System.out.println("What number do you want to find?");

        int target = targetObj.nextInt();

        boolean isFound = false;

        while (randomArray[min] <= randomArray[max] && !isFound) {
            int mid = (max + min)/2;

            if (target == randomArray[mid]) {
                isFound = true;
            } else if (mid == 0) {
                break;
            }else if (target < randomArray[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        String findings = target + ((isFound) ? " was found" : (target == 2) ? " isn't in here, but it is a special number" : " was not found");
        System.out.println(findings);
    }
}