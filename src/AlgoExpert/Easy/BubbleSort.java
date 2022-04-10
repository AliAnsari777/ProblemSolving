package AlgoExpert.Easy;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2,7,4,9,6,5,1};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] array) {
        boolean isSwapped = true;
        int counter = 0;

        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i+1]) {
                    swap(i, i+1, array);
                    isSwapped = true;
                }
            }
            counter++;
        }

        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
