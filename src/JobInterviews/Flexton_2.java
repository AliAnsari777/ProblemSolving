package JobInterviews;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flexton_2 {
    public static void main(String[] args) {

        // 0. Find the longest Palindrome
        String res = Flexton_2.longestPalindrome("ugrecero");
        System.out.println("Palindrome: ");
        System.out.println(res);

        //############################################################//

        // 1. Sum two numbers in array that equal to target
        int[] numbers = {2,4,3,1,5,9,0};
        int[] sum = Flexton_2.sumPair(numbers, 4);
        int[] sum2 = Flexton_2.sumtwoNumber(numbers, 14);

        System.out.println("Sum pairs of numbers: ");
        if(sum2 != null)
            System.out.println("Two number sum is: " + sum2[0] + ", " + sum2[1]);
        else
            System.out.println("No value pair");

        //############################################################//

        // 2. Merge Sort
        int[] mergeSort = {2,4,3,1,5,9,0};
        System.out.println("Merge Sort: ");
        Flexton_2.mergeSort(mergeSort, 0, mergeSort.length-1);

        System.out.println("sorted array");
        for(int a : mergeSort){
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    //==========================================================================//

    // 0. find the longest palindrome in a text
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // odd-numbered length ie "racecar" case
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    // Return the number of index from center that match on either side
    public static int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*******************************************************************/

    // 1. find two numbers in an array that their sum is equal to the specific given value
    public static int[] sumPair(int[] numbers, int k){
        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];
        int temp, value;

        for(int i : numbers)
            list.add(i);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            temp = iterator.next();
            iterator.remove();
            value = k - temp;

            if(list.contains(value)){
                result[0] = temp;
                result[1] = value;
                return result;
            }
        }
        return null;
    }

    // shorter method
    public static int[] sumtwoNumber(int[] numbers, int t){
        List<Integer> values = new ArrayList<>();
        for (int num : numbers){
            if(values.contains(t - num)){
                return new int[] {num, t - num};
            }else {
                values.add(num);
            }
        }
        return new int[] {};
    }

    /*******************************************************************/

    // 2. merge sort with merge method
    public static void mergeSort(int arr[], int left, int right){
        if(left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right){
        int i = 0, j = 0, r = left;
        int[] leftArr = new int[mid - left +1];
        int[] rightArr = new int[right - mid];

        for (int k = 0; k < leftArr.length; k++) {
            leftArr[k] = arr[left+k];
        }
        for (int k = 0; k < rightArr.length; k++) {
            rightArr[k] = arr[mid + 1 + k];
        }

        while (i < leftArr.length && j < rightArr.length){
            if (leftArr[i] <= rightArr[j]){
                arr[r] = leftArr[i];
                i++;
            }else {
                arr[r] = rightArr[j];
                j++;
            }
            r++;
        }

        while (i < leftArr.length){
            arr[r] = leftArr[i];
            i++;
            r++;
        }

        while (j < rightArr.length){
            arr[r] = rightArr[j];
            j++;
            r++;
        }
    }
}
