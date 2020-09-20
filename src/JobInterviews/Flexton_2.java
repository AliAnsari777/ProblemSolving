package JobInterviews;

public class Flexton_2 {
    public static void main(String[] args) {

        // Find the longest Palindrome
        String res = Flexton_2.longestPalindrome("ugrecero");
        System.out.println(res);

        //############################################################//


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


}
