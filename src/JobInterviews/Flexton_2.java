package JobInterviews;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flexton_2 {
    public static void main(String[] args) {

        // Find the longest Palindrome
        String res = Flexton_2.longestPalindrome("ugrecero");
        System.out.println("Palindrome: ");
        System.out.println(res);

        //############################################################//

        int[] numbers = {2,4,3,1,5,9,0};
        int[] sum = Flexton_2.sumPair(numbers, 4);
        System.out.println("Sum pairs of numbers: ");
        if(sum != null)
            System.out.println("Two number sum is: " + sum[0] + ", " + sum[1]);
        else
            System.out.println("No value pair");
    }

    //==========================================================================//

    // find the longest palindrome in a text
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // odd-numbered length ie "racecar" case
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    // Return the number of index from center that match on either side
    public static int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*******************************************************************/

// 1. find two numbers in an array that their sum is equal to the specific given value
    public static int[] sumPair(int[] numbers, int k){
        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];
        int temp, value;

        for(int i : numbers)
            list.add(i);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            temp = iterator.next();
            iterator.remove();
            value = k - temp;

            if(list.contains(value)){
                result[0] = temp;
                result[1] = value;
                return result;
            }
        }
        return null;
    }
}
