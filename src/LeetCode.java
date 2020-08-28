import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

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

        //############################################################//

        // Reverse Integer
//        System.out.println("Reverse Integer: " + LeetCode.reverse(7841));

        //############################################################//

        // Reverse Bits
//        System.out.println("Reverse Bits: " + LeetCode.reverseBits(43261596));

        //############################################################//

        // Two Sum
//        int[] twoSum = {5, 8, 7, 6, 2, 4};
//        int[] result = LeetCode.twoSum(twoSum, 9);
//
//        if (result != null)
//            System.out.println("Two Sum: " + result[0] + ", " + result[1]);
//        else
//            System.out.println("Two Sum: This array doesn't have target number!" );

        //############################################################//

        // Valid Parentheses
//        String parenthese = "({)[]";
//        System.out.println("Valid Parentheses: " + LeetCode.validParentheses(parenthese));

        //############################################################//

        // Palindrome
//        System.out.println("Is Palindrome: " + LeetCode.isPalindrome(787));

        //############################################################//

        // Longest Common Prefix
        String[] values = {"flower","flow","flight"};
        System.out.println("Longest Common Prefix: " + LeetCode.longestCommonPrefix(values));
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

    /*******************************************************************/

    // This is "Reverse Integer" Problem
    // Given a 32-bit signed integer, reverse digits of an integer.
    // Input: -123
    // Output: -321
    // Input: 120
    // Output: 21
    static int reverse(int x) {
        if(x == 0){
            return 0;
        }

        long result = 0;
        boolean neg = false;

        if(x<0){
            neg = true;
            x = Math.abs(x);
        }

        while(x != 0){
            result = result * 10 + (x%10);
            x /= 10;
        }

        if(neg){
            result *= -1;
        }

        if(result > Integer.MAX_VALUE || result <= Integer.MIN_VALUE){
            return 0;
        }

        return (int)result;
    }

    /*******************************************************************/

    // This is "Reverse Bits" Problem
    // Reverse bits of a given 32 bits unsigned integer.
    // you need treat n as an unsigned value
    static int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /*******************************************************************/

    // This is "Two Sum" Problem
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> list = new HashMap<>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res = target - nums[i];
            if(list.containsKey(res)){
                return new int[]{list.get(res), i};
            }
            list.put(nums[i], i);
        }
        return null;
    }

    /*******************************************************************/

    // This is "Valid Parentheses" Problem
    // An input string is valid if:
    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    static boolean validParentheses(String s) {
        Stack<Character> check = new Stack<>();
        char temp;

        for(int i = 0; i<s.length(); i++){
            temp = s.charAt(i);
            if( temp == '(' || temp == '{' || temp == '['){
                check.push(temp);
            }else{
                if(check.empty())
                    return false;

                temp = check.pop();
                if(  ( temp == '(' && s.charAt(i) != ')' ) ||
                        ( temp == '{' && s.charAt(i) != '}' ) ||
                        ( temp == '[' && s.charAt(i) != ']' ) )
                    return false;

            }
        }
        if(check.empty())
            return true;
        else
            return false;
    }

    /*******************************************************************/

    // This is "Palindrome Number" Problem
    // Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward
    static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int temp = x, rev = 0;
        while(temp > 0){
            rev = rev * 10 + (temp%10);
            temp /= 10;
        }

        if(rev == x)
            return true;
        else
            return false;
    }

    /*******************************************************************/

    // This is "Longest Common Prefix" Problem
    // find the longest common prefix string amongst an array of strings.
    //If there is no common prefix, return an empty string "".
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
