package LeetCode;

public class Amazon {
    public static void main(String[] args) {
        System.out.println("Min Swaps");
        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(minSwaps(data));

        //############################################################//

        System.out.println("=================================================");
        System.out.println("Longest Common Subsequence");
        String str1 = "gtgtgatcg";
        String str2 = "actgattag";
        System.out.println(longestCommonSubsequence(str1, str2));

        //############################################################//

        System.out.println("=================================================");




    }

    // Given an array of 0s and 1s, find the minimum number of swaps required to make all 1s together, no matter where in the array
    // To solve this problem we used fixed sliding window
    // Time O(N), Space O(1)
    public static int minSwaps(int[] data) {
        if(data.length <= 2)
            return 0;

        int numOnes = 0;
        int maxOnes = 0;
        int tempOnes = 0;

        for (int datum : data) {
            numOnes += datum;
        }

        for(int i = 0; i < data.length; i++) {
            tempOnes += data[i];
            if(i >= numOnes - 1) {
                if(i > numOnes - 1)
                    tempOnes -= data[i - numOnes];
                maxOnes = Math.max(maxOnes, tempOnes);
            }
        }

        return numOnes - maxOnes;
    }

    /*******************************************************************/

    // Given two strings, find the length of the longest common subsequence
    // To solve this problem we used dynamic programming
    // Time O(M . N), Space O(M .N)
    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dpGrid = new int[text1.length()+1][text2.length()+1];

        for (int row = text1.length()-1; row >= 0; row--) {
            for (int col = text2.length()-1; col >= 0; col--) {
                if(text1.charAt(row) == text2.charAt(col)){
                    dpGrid[row][col] = 1 + dpGrid[row+1][col+1];
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row+1][col], dpGrid[row][col+1]);
                }
            }
        }

        return dpGrid[0][0];
    }

    /*******************************************************************/


}
