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

        int[] one = {10 ,5, 8, 15, 9, 12};
        int[] two = {2, 7, 3, 19, 20, 17};

        System.out.println("\nSmallest Difference: ");
        int[] smallest = smallestDifference(one, two);
        for (int a : smallest)
            System.out.print(a + " ");

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

    // Time = O(n log(n) + m log(m)) | space O(1)
    static int[] smallestDifference(int[] one, int[] two){
        int[] result = new int[2];
        int current = Integer.MAX_VALUE, smallest = Integer.MAX_VALUE, oneIndex = 0, twoIndex = 0;

        Arrays.sort(one);
        Arrays.sort(two);

        while (oneIndex < one.length && twoIndex < two.length){
            int firstNum = one[oneIndex];
            int secondNum = two[twoIndex];

            if( firstNum < secondNum ){
                current = secondNum - firstNum;
                oneIndex++;
            }else if (secondNum < firstNum){
                current = firstNum - secondNum;
                twoIndex++;
            }else{
                return new int[]{firstNum, secondNum};
            }

            if (current < smallest){
                smallest = current;
                result[0] = firstNum;
                result[1] = secondNum;
            }
        }
        return result;
    }
}
