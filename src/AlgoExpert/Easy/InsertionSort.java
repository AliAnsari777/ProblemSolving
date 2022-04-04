package AlgoExpert.Easy;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {2,7,4,9,6,5};
        System.out.println(Arrays.toString(InsertionSort.insertionSort(array)));
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                swap(j, j-1, array);
                j--;
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
