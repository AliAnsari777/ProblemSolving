package AlgoExpert.Hard;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 1, 9, 3, 4, 2};
        System.out.println(Arrays.toString(QuickSort.quickSort(nums)));
    }

    public static int[] quickSort(int[] array) {
        quickSortHelper(0, array.length - 1, array);
        return array;
    }

    private static void quickSortHelper(int startIdx, int endIdx, int[] arr) {
        if (startIdx >= endIdx)
            return;

        int pivot = startIdx;
        int leftPoint = startIdx + 1;
        int rightPoint = endIdx;

        while (leftPoint <= rightPoint){
            if (arr[leftPoint] > arr[pivot] && arr[rightPoint] < arr[pivot]){
                swap(leftPoint, rightPoint, arr);
            }
            if (arr[leftPoint] <= arr[pivot]){
                leftPoint++;
            }
            if (arr[rightPoint] >= arr[pivot]){
                rightPoint--;
            }
        }

        swap(pivot, rightPoint, arr);

        boolean isLeftSubArrayIsSmall = rightPoint - 1 - startIdx < endIdx - (rightPoint + 1);

        if (isLeftSubArrayIsSmall){
            quickSortHelper(startIdx, rightPoint - 1, arr);
            quickSortHelper(rightPoint + 1, endIdx, arr);
        } else {
            quickSortHelper(rightPoint + 1, endIdx, arr);
            quickSortHelper(startIdx, rightPoint - 1, arr);
        }
    }

    private static void swap(int leftPoint, int rightPoint, int[] arr) {
        int temp = arr[leftPoint];
        arr[leftPoint] = arr[rightPoint];
        arr[rightPoint] = temp;
    }
}
