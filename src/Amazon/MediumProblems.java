package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediumProblems {
    public static void main(String[] args) {

        int[] numbers = {12, 3, 1, 2, -6, 5, -8, 6};
        List<Integer> value;
        value = threeNumberSum(numbers, 0);
        System.out.println(value.toString());


        //############################################################//



    }

    //==========================================================================//



    // Three number sum
    // Time = O(n2) | space O(n)
    static List<Integer> threeNumberSum(int[] numbers, int target){
        List<Integer> result = new ArrayList<>();
        int L=0, R=0, temp;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length-2; i++) {
            L = i + 1;
            R = numbers.length-1;

            while (L < R){
                temp = numbers[i] + numbers[L] + numbers[R];
                if (temp == target) {
                    result.add(numbers[i]);
                    result.add(numbers[L]);
                    result.add(numbers[R]);
                    L++; R--;
                }else if(temp < target){
                    L++;
                }else if (temp > target){
                    R--;
                }
            }
        }
        return result;
    }

    /*******************************************************************/


}
