import java.util.ArrayList;

public class LeetCode {
    public static void main(String[] args) {

        // Single Number
        int[] singleNumber = {1, 5, 4, 7, 5, 4, 1, 7, 2};
        System.out.println("Single Number: " + LeetCode.singleNumber(singleNumber));

        //############################################################//

        // Happy Number
        System.out.println("Happy Number: " + LeetCode.happyNumber(19));
    }

//==========================================================================//

    // This is "Single Number" Problem
    // Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    static int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove((Integer) nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    /*******************************************************************/

    // This is "Happy Number" Problem
    // Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat
    // the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not
    // include 1. Those numbers for which this process ends in 1 are happy numbers.
    static boolean happyNumber(int num) {
        int result = 0;

        while (num != 0) {
            int digit = num % 10;
            result += digit * digit;
            num /= 10;
        }

        if (result == 1 || result == 7) {
            return true;
        } else {
            if (result < 10 || result == 0)
                return false;
            else
                return happyNumber(result);
        }
    }

}
