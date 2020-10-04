package Amazon;

import java.util.*;

public class MediumProblems {
    public static void main(String[] args) {

        int[] numbers = {12, 3, 1, 2, -6, 5, -8, 6};
        List<Integer> value;
        value = threeNumberSum(numbers, 0);
        System.out.println(value.toString());


        //############################################################//

        int[] one = {10 ,5, 8, 15, 9, 12};
        int[] two = {2, 7, 3, 19, 20, 17};

        System.out.println("\nSmallest Difference: ");
        int[] smallest = smallestDifference(one, two);
        for (int a : smallest) {
            System.out.print(a + " ");
        }

        //############################################################//

        int[] list = {3, 5, 6, 2, 3, 4, 9, 3};
        int[] list2 = {2, 1, 2, 2, 2, 3, 4, 2};

        System.out.println("\nMove Element To End Of Array: ");
        moveElementToEnd(list2, 2);
        for (int a : list2)
            System.out.print(a + ", ");

        //############################################################//

        int[] monotonic = {7, 6, 5, 4, 3, 2};
        System.out.println("\n\nIs Array Monotonic: " );
        System.out.println(monotonicArray(monotonic));

        //############################################################//

        int[][] spiral = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };
        List<Integer> spiralArray;
        spiralArray = spiral2DArrayTraverse(spiral);
        System.out.println("\nSpiral Array Traversing: ");
        System.out.println(spiralArray.toString());

        List<Integer> recursiveSpiral = recursiveSpiral2DArrayTraversing(spiral);
        System.out.println("\nRecursive Spiral Array Traversing: ");
        System.out.println(recursiveSpiral.toString());

        //############################################################//

        int[] peak = {1, 3, 3, 4, 2, 1, 0, 10, 7, 5, 3, 1, 5};
        System.out.println("\nLongest Peak: ");
        int longestPeak = longestPeak(peak);
        System.out.println(longestPeak);

        //############################################################//

        Vertix graph = new Vertix('A');

        graph.add(graph, 'B');
        graph.add(graph, 'C');
        graph.add(graph, 'D');

        graph.add(graph.children.get(0), 'E');
        graph.add(graph.children.get(0), 'F');
        graph.add(graph.children.get(2), 'G');
        graph.add(graph.children.get(2), 'H');

        List<Character> BFS = BFS(graph);
        System.out.println("\nBreadth Fist Search: ");
        System.out.println(BFS.toString());
    }

    //==========================================================================//



    // Three number sum
    // Time = O(n2) | space O(n)
    static List<Integer> threeNumberSum(int[] numbers, int target){
        List<Integer> result = new ArrayList<>();
        int L=0, R=0, temp;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length-2; i++) {
            L = i + 1;
            R = numbers.length-1;

            while (L < R){
                temp = numbers[i] + numbers[L] + numbers[R];
                if (temp == target) {
                    result.add(numbers[i]);
                    result.add(numbers[L]);
                    result.add(numbers[R]);
                    L++; R--;
                }else if(temp < target){
                    L++;
                }else if (temp > target){
                    R--;
                }
            }
        }
        return result;
    }

    /*******************************************************************/

    // Time = O(n log(n) + m log(m)) | space O(1)
    static int[] smallestDifference(int[] one, int[] two){
        int[] result = new int[2];
        int current = Integer.MAX_VALUE, smallest = Integer.MAX_VALUE, oneIndex = 0, twoIndex = 0;

        Arrays.sort(one);
        Arrays.sort(two);

        while (oneIndex < one.length && twoIndex < two.length){
            int firstNum = one[oneIndex];
            int secondNum = two[twoIndex];

            if( firstNum < secondNum ){
                current = secondNum - firstNum;
                oneIndex++;
            }else if (secondNum < firstNum){
                current = firstNum - secondNum;
                twoIndex++;
            }else{
                return new int[]{firstNum, secondNum};
            }

            if (current < smallest){
                smallest = current;
                result[0] = firstNum;
                result[1] = secondNum;
            }
        }
        return result;
    }

    /*******************************************************************/

    // Time = O(n) | space O(1)
    static void moveElementToEnd(int[] array, int target){
        int start = 0, end = array.length-1;

        while (start < end){
            if (array[end] == target)
                end--;
            else if (array[start] == target) {
                swap(array, start, end);
                start++;
                end--;
            }else
                start++;
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*******************************************************************/

    // Time = O(n) | Space = O(1)
    static boolean monotonicArray(int[] array){
        boolean isNonIncreasing = true, isNonDecreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1])
                isNonDecreasing = false;
            else if (array[i] > array[i - 1])
                isNonIncreasing = false;

        }

        return isNonDecreasing || isNonIncreasing;
    }

    /*******************************************************************/

    // Time = O(n) | Space = O(n)
    static List<Integer> spiral2DArrayTraverse(int[][] array){
        List<Integer> result = new ArrayList<>();
        int startRow = 0, endRow = array.length -1;
        int startCol = 0, endCol = array[0].length -1 ;

        while (startRow <= endRow && startCol <= endCol){
            for (int i = startCol; i < endCol+1; i++) {
                result.add(array[startRow][i]);
            }

            for (int i = startRow+1; i < endRow+1; i++) {
                result.add(array[i][endCol]);
            }

            for (int i = endCol-1; i >= startCol  ; i--) {
                result.add(array[endRow][i]);
            }

            for (int i = endRow-1; i > startRow  ; i--) {
                result.add(array[i][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    static List<Integer> recursiveSpiral2DArrayTraversing(int[][] array){
        List<Integer> result = new ArrayList<>();
        fillList(array, 0, array.length-1, 0, array[0].length -1, result);
        return result;
    }

    private static void fillList(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> result){
        if (startRow > endRow || startCol > endCol){
            return;
        }

        for (int i = startCol; i < endCol+1; i++) {
            result.add(array[startRow][i]);
        }
        for (int i = startRow+1; i < endRow+1 ; i++) {
            result.add(array[i][endCol]);
        }
        for (int i = endCol-1; i >= startCol ; i--) {
            result.add(array[endRow][i]);
        }
        for (int i = endRow-1; i > startRow ; i--) {
            result.add(array[i][startCol]);
        }

        fillList(array, startRow+1, endRow-1, startCol+1, endCol-1, result);
    }

    /*******************************************************************/

    // Time = O(n) | Space = O(1)
    static int longestPeak(int[] array){
        int longestPeakSize = 0;
        int i = 1;

        while (i < array.length-1){
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if (!isPeak){
                i++;
                continue;
            }

            int idxLeft = i-2;
            while (idxLeft >= 0 && array[idxLeft] < array[idxLeft + 1]){
                idxLeft--;
            }
            int idxRight = i+2;
            while (idxRight < array.length-1 && array[idxRight] > array[idxRight+1]){
                idxRight++;
            }

            int currentPeakSize = idxRight - idxLeft;
            longestPeakSize = Math.max(currentPeakSize, longestPeakSize);

            i = idxRight;
        }
        return longestPeakSize;
    }

    /*******************************************************************/

    // Time = O(v+e) v: Vertices & e: Edges | Space = O(v)
    static class Vertix{
        List<Vertix> children;
        char valeu;

        public Vertix(){
            children = new ArrayList<>();
        }
        public Vertix(char val){
            valeu = val;
            children = new ArrayList<>();
        }

        public void add(Vertix graph, char value){
            graph.children.add(new Vertix(value));
        }
    }

    static List<Character> BFS(Vertix graph){
        List<Character> result = new ArrayList<>();
        Queue<Vertix> queue = new LinkedList<>();

        queue.add(graph);
        while (!queue.isEmpty()){
            Vertix temp = queue.poll();
            result.add(temp.valeu);
            for (Vertix v : temp.children){
                if(v != null)
                    queue.add(v);
            }
        }
        return result;
    }

    /*******************************************************************/


}
