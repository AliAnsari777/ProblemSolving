package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyProblems {
    public static void main(String[] args) {

        // Two Number Sum
        int[] numbers = {5,3,-4,8,11,1,-1,6};
        System.out.println("Sum of Two Number");
        System.out.println(Arrays.toString(SumOfTwoNumber(numbers, 13)));
        System.out.println(Arrays.toString(sumTwoNumbersHashTable(numbers, 10)));

        //############################################################//

        // Time O(n) | space O(1)
        int[] array = {4, 6, 8, 2, 5, 0, 9};
        int[] subsequence = {4, 2, 9};
        System.out.println("\nValidate Subsequence Array");
        System.out.println(validateSubsequenceArray(array, subsequence));


    }

    //==========================================================================//

    // O(n log(n)) Time Complexity, O(1) Space Complexity
    static  int[] SumOfTwoNumber(int[] numbers, int target){
        Arrays.sort(numbers);
        int beggin = 0, end = numbers.length-1;

        while (beggin < end) {
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

    // O(n) Time Complexity, O(n) Space Complexity
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

    /*******************************************************************/

    static boolean validateSubsequenceArray(int[] oreginal, int[] subsequnce){
        int oreInd = 0, subInd = 0;

        while (oreInd < oreginal.length && subInd < subsequnce.length){
            if(oreginal[oreInd] == subsequnce[subInd])
                subInd++;
            oreInd++;
        }

        return subInd == subsequnce.length;
    }
}
