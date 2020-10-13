package GFG;

public class DynamicProgramming {
    public static void main(String[] args) {
        String one = "AGGTAB";
        String two = "GXTXAYB";

        char[] first = one.toCharArray();
        char[] second = two.toCharArray();
        int f = first.length;
        int s = second.length;

        int result = lcs(first, second, f, s);

        System.out.println("\nLongest Common Subsequence:");
        System.out.println(result);

        //*******************************************************//

        int[] numbers = {1, 7, 3, 12, 5, 30, 32, 220};
        System.out.println("\nLongest Increasing Subsequence:");
        System.out.println(lis(numbers, numbers.length));
    }

    //=================================================================//

    // Time = O(mn) | Space = O(mn)
    // Longest Common subsequence
    // give us two array of character and we need to find common longest subsequence in them
    // subsequence are chars that appear in same order but not necessarily continuously
    static int lcs(char[] x, char[] y, int m, int n){
//        int[][] temp = new int[m+1][n+1];
//
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if(i == 0 || j == 0)
//                    temp[i][j] = 0;
//                else if (x[i-1] == y[j-1])
//                    temp[i][j] = 1 + temp[i-1][j-1];
//                else
//                    temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
//            }
//        }
//        return temp[m][n];


        // Time = O(m*n) | Space = O(n)
        // in here we just keep two rows "space efficient way"
        int[][] result = new int[2][n+1];
        int row = 0;

        for (int i = 0; i <= m; i++) {
            row = i & 1;

            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    result[row][j] = 0;
                else if (x[i-1] == y[j-1]){
                    result[row][j] = 1 + result[1 - row][j-1];
                }else {
                    result[row][j] = Math.max(result[row][j-1], result[1-row][j]);
                }
            }
        }
        return result[row][n];

    }

    //########################################################################//

    // Time = O(n^2) | Space = O(n)
    static int lis(int[] numbers, int len){
        int[] longest = new int[len];
        int max = 0;

        for (int i = 0; i < len; i++) {
            longest[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && longest[i] < longest[j]+1){
                    longest[i] = longest[j] + 1;
                }
            }
        }

        for (int a : longest){
            if (a > max)
                max = a;
        }

        return max;
    }
}
