import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome!");

        mainMenu();
    }

    public static void sortArray(int[] randomArray, float avg) {
        for (int i = 0; i < randomArray.length - 1; i++) {
            for (int j = 0; j < (randomArray.length - 1) - i; j++) {
                if (randomArray[j] > randomArray[j+1]) {
                    int temp = randomArray[j];
                    randomArray[j] = randomArray[j+1];
                    randomArray[j+1] = temp;
                }
            }
        }

        StoreArray.storeArr(randomArray, avg);
    }

    public static void mainMenu() {
        Scanner againObj = new Scanner(System.in);
        System.out.println("Do you want to create a new array?");
        String answer = (againObj.nextLine()).toLowerCase(Locale.ROOT);

        if (answer.equals("yes")) {
            GenerateArray.genArr();
        } else if (answer.equals("no") && !StoreArray.myArrays.isEmpty()) {
            Scanner pastObj = new Scanner(System.in);
            System.out.println("Do you want to guess at one of the arrays again?");
            String guessAns = (pastObj.nextLine()).toLowerCase(Locale.ROOT);

            if (guessAns.equals("yes")) {
                Scanner selectObj = new Scanner(System.in);
                System.out.println("Which array would you like to guess at again?");
                System.out.println("Select an array index between 0 and " + (StoreArray.myArrays.size() - 1));

                int selectAns = selectObj.nextInt();

                guessArr(selectAns);
            } else {
                System.out.println("Goodbye then :)");
                System.out.println("Until next time!");
            }
        } else {
            System.out.println("Somethings off...");
            System.out.println("Goodbye then :)");
            System.out.println("Until next time!");
        }
    }

    public static void guessArr(int arrayListIndex) {

        if (arrayListIndex < 0 || arrayListIndex >= StoreArray.myArrays.size()) {
            System.out.println("Invalid index. Exiting... :(");
            return;
        }

        System.out.println("The average of the array is: " + StoreArray.myAverages.get(arrayListIndex));

        int max = StoreArray.myArrays.get(arrayListIndex).length - 1, min = 0;

        Scanner targetObj = new Scanner(System.in);
        System.out.println("What number do you want to find?");

        int target = targetObj.nextInt();

        boolean isFound = false;

        //Binary search through selected array for wanted target
        while (StoreArray.myArrays.get(arrayListIndex)[min] <= StoreArray.myArrays.get(arrayListIndex)[max] && !isFound) {
            int mid = (max + min)/2;

            if (target == StoreArray.myArrays.get(arrayListIndex)[mid]) {
                isFound = true;
            } else if (mid == 0) {
                break;
            }else if (target < StoreArray.myArrays.get(arrayListIndex)[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        String findings = target + ((isFound) ? " was found" : (target == 2) ? " isn't in here, but it is a special number" : " wasn't found... :( Better luck next time!");
        System.out.println(findings);

        mainMenu();
    }
}