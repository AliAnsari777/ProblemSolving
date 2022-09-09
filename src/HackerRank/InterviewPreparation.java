package HackerRank;

public class InterviewPreparation {

    public static void main(String[] args) {

        int[] numbers = {1, 3, 5, 2, 4, 6, 7};
        System.out.println("Minimum Swaps:");
        System.out.println(InterviewPreparation.minimumSwaps(numbers));
    }


    //==========================================================================//


    // Array's Problems

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
}
