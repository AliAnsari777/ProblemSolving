import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Practice2 {
    public static void main(String[] args) {

        int[] list = {3,5,1,1,3,4,2,1,5,3};
        System.out.println("\nFind a number which is in majority of array");
        System.out.println(average(list));

        //############################################################//


    }

    //==========================================================================//

    // find a number which is in majority of array
    static int average(int[] arr){
        HashMap<Integer, Integer> mylist = new HashMap<>();
        for (int value : arr) {
            if (mylist.containsKey(value)) {
                mylist.put(value, mylist.get(value) + 1);
            } else {
                mylist.put(value, 1);
            }
        }
        return Collections.max(mylist.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /*******************************************************************/

}
