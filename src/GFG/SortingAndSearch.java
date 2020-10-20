package GFG;

import java.util.Arrays;

public class SortingAndSearch {
    public static void main(String[] args) {

        int[] numbers = {3, 5, 7, 8, 9, 14, 56};
        System.out.println("\nBinary Search: ");
        System.out.println(SortingAndSearch.binarySearch(numbers,0,numbers.length,5));

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

    static int binarySearch2(int[] number, int target){
        int left = 0, right = number.length, mid;


        while (left < right){
            mid = (left+right)/2;
            if (number[mid] == target)
                return mid;
            else if(number[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println("\nNumber wasn't in the list!");
        return -1;
    }

    /*******************************************************************/



}
