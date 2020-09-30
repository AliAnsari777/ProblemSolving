package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyProblems {
    public static void main(String[] args) {

        // Two Number Sum
        int[] numbers = {5,3,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(SumOfTwoNumber(numbers, 10)));
        System.out.println(Arrays.toString(sumTwoNumbersHashTable(numbers, 10)));

        //############################################################//



    }

    //==========================================================================//

    static  int[] SumOfTwoNumber(int[] numbers, int target){
        Arrays.sort(numbers);
        int beggin = 0, end = numbers.length-1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[beggin] + numbers[end] == target){
                return new int[]{numbers[beggin], numbers[end]};
            }else if(numbers[beggin] + numbers[end] > target){
                end--;
            }else if(numbers[beggin] + numbers[end] < target){
                beggin++;
            }
        }
        return null;
    }

    /*******************************************************************/

    static int[] sumTwoNumbersHashTable(int[] numbers, int target){
        Map<Integer, Boolean> values = new HashMap<>();
        int sum;

        for(int val : numbers){
            sum = target - val;
            if (!values.containsKey(sum))
                values.put(val, true);
            else
                return new int[]{val, sum};
        }
        return new int[]{};
    }
}
