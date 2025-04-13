package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartOne {
    public static void main(String[] args) {

        System.out.println("Triple Sum:");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 3, 1, 2, -6, 5, -8, 6, 10));
        System.out.println(tripleSum(numbers, 0));

        //############################################################//

        System.out.println("\nSmallest Difference:");
        List<Integer> firstArray = new ArrayList<>(Arrays.asList(-1, 5, 10, 20, 28, 3));
        List<Integer> secondArray = new ArrayList<>(Arrays.asList(26, 134, 135, 15, 17));
        System.out.println(Arrays.toString(smallestDifference(firstArray, secondArray)));

        //############################################################//

        System.out.println("\nMove Element to End:");
        List<Integer> list = new ArrayList<>(Arrays.asList(2,1,2,2,21,3,4,2));
        System.out.println(moveElementToEnd(list, 2));

        //############################################################//

        System.out.println("\nIs Array Monotonic:");
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 5, 3, 8, 10));
        System.out.println(isMonotonicArray(array));

        //############################################################//

        System.out.println("\nSpiral Traverse:");
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(12, 13, 14, 5));
        matrix.add(Arrays.asList(11, 16, 15, 6));
        matrix.add(Arrays.asList(10, 9, 8, 7));
        System.out.println(spiralTraverse(matrix));

        //############################################################//

        System.out.println("\nLongest Peak:");
        List<Integer> peak = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3));
        System.out.println(longestPeak(peak));

        //############################################################//

        System.out.println("\nMake Palindrome:");
        System.out.println(makePalindrome("zbcfedcba"));

        //############################################################//

        System.out.println("\nMaximum Books:");
        int[] books = {8,2,3,7,3,4,0,1,4,3};
        System.out.println(maximumBooks(books));

        //############################################################//
        System.out.println("\nGet Max");
        List<Integer> list1 = Arrays.asList(2,3,2);
        System.out.println(getMax2(list1, 4));

    }

    // time O(n^2) | space O(n)
    public static List<List<Integer>> tripleSum(List<Integer> numbers, int target) {

        int left;
        int right;
        List<List<Integer>> result = new ArrayList<>();
        numbers.sort(null);

        for(int i = 0; i < numbers.size(); i++) {
            left = i+1;
            right = numbers.size() - 1;

            while (left < right) {
                int sum = numbers.get(i) + numbers.get(right) + numbers.get(left);

                if(sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numbers.get(i));
                    triplet.add(numbers.get(left));
                    triplet.add(numbers.get(right));
                    result.add(triplet);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /*******************************************************************/

    // time O(n log(n) + m log(m)) | space O(1)
    public static int[] smallestDifference(List<Integer> first, List<Integer> second) {
        int firstIdx = 0;
        int secondIdx = 0;
        int smallDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        first.sort(null);
        second.sort(null);

        while(firstIdx < first.size() && secondIdx < second.size()) {
            int diff = Math.abs(first.get(firstIdx) - second.get(secondIdx));

            if(diff == 0)
                return new int[]{first.get(firstIdx), second.get(secondIdx)};

            if(diff < smallDiff) {
                smallDiff = diff;
                result[0] = first.get(firstIdx);
                result[1] = second.get(secondIdx);
            }

            if(first.get(firstIdx) < second.get(secondIdx))
                firstIdx++;
            else
                secondIdx++;
        }

        return result;
    }

    /*******************************************************************/

    // Move all the target number to the end of the list
    // time O(n) | space O(1)
    public static List<Integer> moveElementToEnd(List<Integer> list, int target) {

        int leftIdx = 0;
        int rightIdx = list.size() - 1;

        while (leftIdx < rightIdx){

            while(leftIdx < rightIdx && list.get(rightIdx) == target) {
                rightIdx--;
            }

            if(list.get(leftIdx) == target) {
                int temp = list.get(leftIdx);
                list.set(leftIdx, list.get(rightIdx));
                list.set(rightIdx, temp);
            }
            leftIdx++;
        }

        return list;
    }

    /*******************************************************************/

    // Is array all increasing or decreasing
    // time O(n) | space O(1)
    public static boolean isMonotonicArray(List<Integer> array) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i = 1; i < array.size(); i++) {
            if(array.get(i) < array.get(i - 1))
                isDecreasing = false;
            else if(array.get(i) > array.get(i - 1))
                isIncreasing = false;
        }

        return isIncreasing || isDecreasing;
    }

    /*******************************************************************/

    public static List<Integer> spiralTraverse(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.size() - 1;
        int startCol = 0;
        int endCol = array.get(0).size() - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array.get(startRow).get(col));
            }
            startRow++;

            for(int row = startRow; row <= endRow; row++) {
                result.add(array.get(row).get(endCol));
            }
            endCol--;

            for (int col = endCol; col >= startCol; col--) {
                result.add(array.get(endRow).get(col));
            }
            endRow--;

            for (int row = endRow; row >= startRow; row--) {
                result.add(array.get(row).get(startCol));
            }
            startCol++;
        }

        return result;
    }

    /*******************************************************************/

    // Find the longest peak in the given array of integers.
    // Peak is defined as a number that is greater than its neighbors, it means the left and right side of the peak is resterictly decreasing.
    // time O(n) | space O(1)
    public static int longestPeak(List<Integer> array) {
        int longest = 0;
        for (int i = 1; i < array.size() - 1; i++) {
            if(array.get(i) > array.get(i-1) && array.get(i) > array.get(i+1)){
                int left = i - 1;
                int right = i + 1;

                while(left >= 0 && array.get(left) > array.get(left-1)) {
                    left--;
                }

                while(right < array.size()-1 && array.get(right) > array.get(right+1)) {
                    right++;
                }

                longest = Math.max(longest, right - left + 1);
                i = right;
            }
        }

        return longest;
    }

    /*******************************************************************/

    public static boolean makePalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int counter = 0;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                counter++;
                if(counter > 2) {
                    return false;
                }
            }
            left++;
            right--;
        }

        return true;
    }

    /*******************************************************************/

    public static long maximumBooks(int[] books) {
        int n = books.length;
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = books[i];
                } else {
                    long maxBooks = 0;
                    for (int k = i; k < j; k++) {
                        maxBooks = Math.max(maxBooks, books[k] + dp[k + 1][j]);
                    }
                    dp[i][j] = maxBooks;
                }
            }
        }

        return dp[0][n - 1];
    }

//    public static String sortPermutation(List<Integer> p, List<Integer> moves){
//
//    }

    public static int getMax(List<Integer> list, int day){
        List<Integer> allDays = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < list.size(); i++){
            for (int j = 1; j <= list.get(i); j++) {
                allDays.add(j);
            }
        }

        for (int i = 0, j = day; j < allDays.size() ; i++, j++){
            int sum = 0;

            for (int k = i; k < j; k++) {
                sum += allDays.get(k);
            }
            if(sum > max)
                max = sum;
        }

        return max;
    }


    public static int getMax2(List<Integer> list, int day) {
    List<Integer> allDays = new ArrayList<>();
    int max = 0;
    int sum = 0;

    // Create a list of all days
    for (int i = 0; i < list.size(); i++) {
        for (int j = 1; j <= list.get(i); j++) {
            allDays.add(j);
        }
    }

    // Calculate the sum for the first 'day' days
    for (int i = 0; i < day; i++) {
        sum += allDays.get(i);
    }
    max = sum;

    // Slide the window and update the max sum
    for (int i = day; i < allDays.size(); i++) {
        sum = sum - allDays.get(i - day) + allDays.get(i);
        max = Math.max(max, sum);
    }

    return max;
}
}
