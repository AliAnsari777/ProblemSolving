import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Practice2 {
    public static void main(String[] args) {

        //############################################################//


    }

    //==========================================================================//

    // find a number which is in majority of array
    int average(int[] arr){
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
