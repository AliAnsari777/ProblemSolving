package GFG;

public class SortingAndSearch {
    public static void main(String[] args) {

        int[] numbers = {3, 5, 7, 8, 9, 14, 56};
        System.out.println("\nBinary Search: ");
        System.out.println(SortingAndSearch.binarySearch(numbers,0,numbers.length,30));

        //############################################################//

    }

    //==========================================================================//


    static int binarySearch(int[] numbers, int L, int R, int target) {
        if (numbers.length == 0){
            System.out.println("\nArray is empty!");
            return -1;
        }
        if (L > R){
            System.out.println("\nNumber wasn't in list!");
            return -1;
        }

        int mid = (L + R) / 2;
        if (numbers[mid] == target)
            return mid;
        else if (numbers[mid] < target)
            return binarySearch(numbers,mid+1, R, target);
        else
           return binarySearch(numbers, L, mid-1,target);

    }
    /*******************************************************************/


}
