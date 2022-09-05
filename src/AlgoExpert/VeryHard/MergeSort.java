package AlgoExpert.VeryHard;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] list = {6,2,1,9,7,3,4,3};
        System.out.println(Arrays.toString(sort.mergeSort(list)));
        System.out.println(Arrays.toString(sort.optimizedMergeSort(list)));
    }


    // Time: O(N log(N))  |  Space O(N log(N))
    public int[] mergeSort(int[] array){
        if (array.length == 1)
            return array;

        int mid = array.length/2;
        int[] leftHalf = new int[mid], rightHalf = new int[mid];

        System.arraycopy(array, 0, leftHalf, 0, mid);
        System.arraycopy(array, mid, rightHalf, 0, mid);

        return mergeSortedArray(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private int[] mergeSortedArray(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
        int k = 0, i = 0, j = 0;

        while (i < leftHalf.length && j < rightHalf.length){
            if (leftHalf[i] <= rightHalf[j]){
                sortedArray[k] = leftHalf[i];
                i++;
            } else {
                sortedArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalf.length){
            sortedArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalf.length){
            sortedArray[k] = rightHalf[j];
            j++;
            k++;
        }
        return sortedArray;
    }

    //////////////////////////////////////////////////////////////////////

    // Time: O(N log(N))  |  Space O(N)
    public int[] optimizedMergeSort(int[] array){
        if (array.length <= 1)
            return array;

        int[] auxiliaryArray = new int[array.length];
        System.arraycopy(array, 0, auxiliaryArray, 0, array.length);

        mergeHelper(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }

    private void mergeHelper(int[] mainArray, int startIdx, int endIdx, int[] auxiliaryArray) {
        if (startIdx == endIdx)
            return;

        int mid = (startIdx + endIdx) / 2;
        mergeHelper(auxiliaryArray, startIdx, mid, mainArray);
        mergeHelper(auxiliaryArray, mid+1, endIdx, mainArray);

        doMerge(mainArray, startIdx, mid, endIdx, auxiliaryArray);
    }

    private void doMerge(int[] mainArray, int startIdx, int mid, int endIdx, int[] auxiliaryArray) {
        int k = startIdx;
        int i = startIdx;
        int j = mid + 1;

        while (i <= mid && j <= endIdx){

            if (auxiliaryArray[i] <= auxiliaryArray[j]){
                mainArray[k] = auxiliaryArray[i];
                i++;
            } else {
                mainArray[k] = auxiliaryArray[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            mainArray[k] = auxiliaryArray[i];
            i++;
            k++;
        }

        while (j <= endIdx){
            mainArray[k] = auxiliaryArray[j];
            j++;
            k++;
        }
    }
}
