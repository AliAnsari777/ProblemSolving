package Meta.LeetCode;

import java.util.PriorityQueue;

public class Easy {

    public static void main(String[] args) {

        System.out.println(Easy.validWordAbbreviation("substitution", "s10n"));

        //############################################################//

        System.out.println(Easy.validPalindrome("abca"));
    }


    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // pointer for word
        int j = 0; // pointer for abbr

        while (i < word.length() && j < abbr.length()) {
            if (Character.isLetter(abbr.charAt(j))) {
                // Match letter
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            } else {
                if (abbr.charAt(j) == '0') return false; // leading zero not allowed

                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // skip characters in word
            }
        }

        return i == word.length() && j == abbr.length();
    }




    /*******************************************************************/

    // Given a string s, return true if the s can be palindrome after deleting at most one character from it.
    public static boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, false);
    }

    private static boolean isValid(String s, int left, int right, boolean deleted) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (deleted)
                    return false;

                return isValid(s, left + 1, right, true) || isValid(s, left, right - 1, true);
            }
            left++;
            right--;
        }
        return true;
    }
}
