import java.util.ArrayList;
import java.util.Arrays;

public class StoreArray {
    public static ArrayList<int[]> myArrays = new ArrayList<int[]>();
    public static ArrayList<Float> myAverages = new ArrayList<Float>();


    public static void storeArr(int[] newArray, float arrAvg) {
        myArrays.add(newArray);

        myAverages.add(arrAvg);

        System.out.println("New array stored!");
        System.out.println(myArrays.size());
        System.out.println(Arrays.toString(myArrays.getFirst()));

        Main.guessArr(myArrays.indexOf(newArray));
    }
}
