package HackerRank;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewPreparation {

    public static void main(String[] args) {

        // Array's Problems
        System.out.println("Array Problems: ------------------------------");

        int[][] glass = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println("\n2D Array - Hours Glass Sum: ");
        System.out.println(InterviewPreparation.hourglassSum(glass));
        System.out.println(InterviewPreparation.hourGlassSum2(glass));

        int[] numbers = {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        System.out.println("\nArrays: Left Rotation");
        int[] rotatedArray = InterviewPreparation.rotLeft(numbers, 13);
        for (int a : rotatedArray)
            System.out.print(a + " ");

        int[] line = {1, 2, 5, 3, 4, 7, 8, 6};
        System.out.println("\n\nNew Year Chaos: ");
        InterviewPreparation.minimumBribes(line);

        int[] numbers2 = {1, 3, 5, 2, 4, 6, 7};
        System.out.println("\nMinimum Swaps:");
        System.out.println(InterviewPreparation.minimumSwaps(numbers2));

        int[][] numbers3 = {{1,2,100}, {2,5, 100}, {3,4,100}};
        System.out.println("\nArray Manipulation:");
        System.out.println(InterviewPreparation.arrayManipulation(5, numbers3));

        //############################################################//

        String text = "cdcd";
        System.out.println("\nHashMap:");
        System.out.println(InterviewPreparation.sherlockAndAnagrams(text));

        List<Integer> list = Arrays.asList(1, 3, 9, 9, 27, 81);
        System.out.println("\nCount Triplets:");
        System.out.println(InterviewPreparation.countTriplets(list, 3));

        List<List<Integer>> quries = new ArrayList<>();
        quries.add(Arrays.asList(1, 5));
        quries.add(Arrays.asList(1, 6));
        quries.add(Arrays.asList(1, 2));
        quries.add(Arrays.asList(2, 2));
        quries.add(Arrays.asList(2, 2));
        quries.add(Arrays.asList(3, 2));
        quries.add(Arrays.asList(1, 10));
        quries.add(Arrays.asList(1, 10));
        quries.add(Arrays.asList(1, 6));
        quries.add(Arrays.asList(2, 5));
        quries.add(Arrays.asList(1, 2));
        quries.add(Arrays.asList(1, 2));
        quries.add(Arrays.asList(3, 2));

        System.out.println("\nFrequency Queries:");
        System.out.println(InterviewPreparation.freqQuery(quries));

    }


    //==========================================================================//


    // Array's Problems

    // Easy
    static int hourglassSum(int[][] arr) {
        int rs = 0, re = 2, cs = 0, ce = 2, total=0, result = Integer.MIN_VALUE;

        while(re < 6) {
            total += arr[rs+1][cs+1];
            for (int i = rs; i <= re; i += 2) {
                for (int j = cs; j <= ce; j++) {
                    total += arr[i][j];
                }
            }

            if (total > result) {
                result = total;
            }

            if (ce < 5) {
                cs++;
                ce++;
            }else{
                cs = 0;
                ce = 2;
                rs++;
                re++;
            }
            total = 0;
        }
        return result;
    }

    static int hourGlassSum2(int[][] arr){
        int total = 0, result = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                total = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if (total > result)
                    result = total;

                total = 0;
            }
        }
        return result;
    }

    // Easy
    static int[] rotLeft(int[] a, int d) {
        int size = a.length;
        int[] result = new int[size];
//        int i;
//        for(i = 0; i < a.length - d; i++){
//            result[i] = a[i+d];
//        }
//        for(int j = 0; j < d; j++, i++){
//            result[i] = a[j];
//        }

        for (int j = 0; j < size; j++) {
            int loc = (j + (size - d) ) % size;
            result[loc] = a[j];
        }
        return result;
    }

    // Medium
    static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = q.length - 1; i >= 0 ; i--) {
            if (q[i] - (i + 1) > 2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i])
                    bribes++;
            }
        }
        System.out.println(bribes);
    }

    // Medium
    static int minimumSwaps(int[] arr) {
        int idx = 0, swapCount = 0;

        while(idx < arr.length){
            if(arr[idx] != idx+1){
                swap(idx, arr[idx] - 1, arr);
                swapCount++;
            }else{
                idx++;
            }
        }
        return swapCount;
    }

    static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each
     * the array element between two given indices, inclusive. Once all operations have been performed, return
     * the maximum value in the array.
     *  a b k
     *  1 5 3
     *  4 8 7
     *  6 9 1
     */
    // Hard
    static long arrayManipulation(int n, int[][] queries) {
        int[] numbers = new int[n+1];

        for (int[] query : queries) {
            numbers[query[0] - 1] += query[2];
            numbers[query[1]] -= query[2];
        }


        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /*******************************************************************/

    // HashMap's Problems
    static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                char[] arr = s.substring(start, end).toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);
                if (map.containsKey(str)) {
                    count += map.get(str);
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        return count;
    }

    static long countTriplets(List<Integer> arr, int r) {
        long numberOfTriplets = 0L;
        Map<Long, Long> mapValueCounting = new HashMap<>();
        Map<Long, Long> mapPair = new HashMap<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);
            if (mapPair.containsKey(a * r)) {
                numberOfTriplets += mapPair.get(a * r);
            }
            if (mapValueCounting.containsKey(a * r)) {
                mapPair.put(a, mapPair.getOrDefault(a, 0L) + mapValueCounting.get(a * r));
            }
            mapValueCounting.merge(a, 1L, Long::sum);
        }
        return numberOfTriplets;
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();

        for (List<Integer> query : queries) {
            int opr = query.get(0), val = query.get(1);

            if (opr == 1) {
                numMap.put(val, numMap.getOrDefault(val, 0) + 1);
            } else if (opr == 2 && numMap.containsKey(val)) {
                if (numMap.get(val) != 0) {
                    numMap.put(val, numMap.get(val) - 1);
                }
            } else if (opr == 3) {
                result.add(numMap.containsValue(val) ? 1 : 0);
            }
        }
        return result;
    }

}
