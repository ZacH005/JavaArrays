import javax.xml.transform.Source;
import java.util.Scanner;
import java.math.MathContext;
import java.util.concurrent.ThreadLocalRandom;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] randomArray = { {6, 1, 3, 7, 234, 5, 234, -1, -19, 10}, {256, 3, -4}};

        Scanner indexObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter array you want to sort/search");
        int index = indexObj.nextInt();  // Read user input

        for (int i = 0; i < randomArray[index].length - 1; i++) {
            for (int j = 0; j < (randomArray[index].length - 1) - i; j++) {
                if (randomArray[index][j] > randomArray[index][j+1]) {
                    int temp = randomArray[index][j];
                    randomArray[index][j] = randomArray[index][j+1];
                    randomArray[index][j+1] = temp;
                }
            }
        }

        int sum = 0;

        for (int v : randomArray[index]) {
            System.out.println(v);
            sum += v;
        }

        float avg = (float) sum /randomArray[index].length;
        System.out.println("The average of this array is: " + avg);

        int max = randomArray[index].length - 1, min = 0;

        Scanner targetObj = new Scanner(System.in);
        System.out.println("What number do you want to find?");

        int target = targetObj.nextInt();

        boolean isFound = false;

        while (randomArray[index][min] <= randomArray[index][max] && !isFound) {
            int mid = (max + min)/2;

            if (target == randomArray[index][mid]) {
                isFound = true;
            } else if (target < randomArray[index][mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        String findings = target + ((isFound) ? " was found" : (target == 2) ? " isn't in here, but it is a special number" : " was not found");
        System.out.println(findings);
    }
}