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
                if (word.charAt(i) != abbr.charAt(j))
                    return false;
                i++;
                j++;
            } else {
                if (abbr.charAt(j) == '0')
                    return false; // leading zero not allowed

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

    /*******************************************************************/

    private int diameter;
    public int diameterOfBinaryTree(Medium.TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(Medium.TreeNode node) {
        if(node == null)
            return 0;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }

    /*******************************************************************/

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
    all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    * */

    // my code
    public boolean isPalindrome(String s) {

        Math.pow(0, 0);
//        if(s.isBlank())
//            return true;

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int start = 0, end = s.length() - 1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Leetcode solution
    public boolean isPalindrome2(String s) {
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }

        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();
        return filteredString.equals(reversedString);

        // or
//        s.chars()
//         .filter(c -> Character.isLetterOrDigit(c))
//         .mapToObj(c -> Character.toLowerCase((char) c))
//         .forEach(builder::append);
//        return builder.toString().equals(builder.reverse().toString());

    }

    /*******************************************************************/

//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = 0, idx2 = 0;
        int[] copy = new int[m];

        for(int i = 0; i < m; i++) {
            copy[i] = nums1[i];
        }

        for(int i = 0; i < m+n; i++) {
            if(idx2 >= n || (idx1 < m && copy[idx1] < nums2[idx2])) {
                nums1[i] = copy[idx1++];
            } else {
                nums1[i] = nums2[idx2++];
            }
        }
    }
}
