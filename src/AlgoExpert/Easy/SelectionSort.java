package AlgoExpert.Easy;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {2,7,4,9,6,5,1};
        System.out.println(Arrays.toString(SelectionSort.selectionSort(array)));
    }

    public static int[] selectionSort(int[] array) {
        int currentIdx = 0, smallIdx;

        while (currentIdx + 1 < array.length) {
            smallIdx = currentIdx;
            for (int i = currentIdx + 1; i < array.length; i++) {
                if (array[smallIdx] > array[i]) {
                    smallIdx = i;
                }
            }
            swap(currentIdx, smallIdx, array);
            currentIdx++;
        }

        return array;
    }

    private static void swap(int currentIdx, int smallIdx, int[] array) {
        int temp = array[currentIdx];
        array[currentIdx] = array[smallIdx];
        array[smallIdx] = temp;
    }
}
