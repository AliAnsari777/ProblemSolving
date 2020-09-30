package Amazon;

import java.util.Arrays;

public class EasyProblems {
    public static void main(String[] args) {

        // Two Number Sum
        int[] numbers = {5,3,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(SumOfTwoNumber(numbers, 10)));

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


}
