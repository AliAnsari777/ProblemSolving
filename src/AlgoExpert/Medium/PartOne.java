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
}
