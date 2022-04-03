package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Easy {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(Easy.twoSum(numbers, 18)));

        //############################################################//


    }

    //==========================================================================//


    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (result.containsKey(temp)){
                return new int[]{result.get(temp), i};
            }
            result.put(numbers[i], i);
        }
        return new int[]{};
    }

    /*******************************************************************/


}
