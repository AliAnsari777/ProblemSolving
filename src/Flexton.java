public class Flexton {
    public static void main(String[] args) {

        Flexton obj = new Flexton();

        String res = obj.longestPalindrome("ugrecero");
        System.out.println(res);
        //############################################################//

        int[] numbers = {2,4,3,1,5,9,0};
        int[] zerOne = {1,1,0,0,1,0,1};


    }

    //==========================================================================//

    // find the longest palindrome in a text
    public String longestPalindrome(String s) {
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
    public int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*******************************************************************/

}
