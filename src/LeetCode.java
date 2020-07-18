import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode {
    public static void main(String[] args) {

        // Single Number
        int[] singleNumber = {1, 5, 4, 7, 5, 4, 1, 7, 2};
        System.out.println("Single Number: " + LeetCode.singleNumber(singleNumber));

        //############################################################//

        // Happy Number
        System.out.println("Happy Number: " + LeetCode.happyNumber(19));

        //############################################################//

        // Number of Steps to Reduce a Number to Zero
        System.out.println("Number of Steps to Reduce a Number to Zero: " + LeetCode.numberOfSteps(23));

        //############################################################//

        // Max Consecutive Ones
        int[] maxConsecutiveOnes = {1, 1, 1, 0, 1, 0, 1, 1, 0};
        System.out.println("Max Consecutive Ones: " + LeetCode.findMaxConsecutiveOnes(maxConsecutiveOnes));

        //############################################################//

        // Defanging an IP Address
        System.out.println("Defanging an IP Address: " + LeetCode.defangIPaddr("255.100.50.0"));

        //############################################################//

        // First unique character in string
        System.out.println("First unique character in string: " + LeetCode.firstUniqChar("this is for test"));
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

    /*******************************************************************/

    // This is "Number of Steps to Reduce a Number to Zero" Problem
    // Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even,
    // you have to divide it by 2, otherwise, you have to subtract 1 from it.
    static int numberOfSteps (int num) {
        int temp, steps = 0;
        while(num != 0){
            temp = num % 2;
            if(temp == 0){
                num /= 2;
            }
            else{
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    /*******************************************************************/

    // This is "Max Consecutive Ones" Problem
    // Given a binary array, find the maximum number of consecutive 1s in this array.
    // The input array will only contain 0 and 1.
    // The length of input array is a positive integer and will not exceed 10,000
    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 1){
                count++;
                if(count > result){
                    result = count;
                }
            }
            else{
                count = 0;
            }
        }
        return result;
    }

    /*******************************************************************/

    // This is "Defanging an IP Address" Problem
    // Given a valid (IPv4) IP address, return a defanged version of that IP address.
    //A defanged IP address replaces every period "." with "[.]".
    static String defangIPaddr(String address) {
        String result = address.replace(".", "[.]");
        return result;
    }

    /*******************************************************************/

    // This is "First Unique Character in a String" Problem
    // Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    static int firstUniqChar(String s) {
        HashMap<Character, Integer> list = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            list.put(s.charAt(i), list.getOrDefault(s.charAt(i), 0)+1 );
        }
        for (int i = 0; i < s.length(); i++) {
            if(list.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
