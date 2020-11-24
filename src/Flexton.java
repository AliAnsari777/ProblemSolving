import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flexton {
    public static void main(String[] args) {

        Flexton obj = new Flexton();

        System.out.println("\nLongest Palindrome:");
        String res = obj.longestPalindrome("ugrecero");
        System.out.println(res);

        //############################################################//

        System.out.println("\nSum Two Numbers: ");
        int[] numbers = {2,4,3,1,5,9,0};
        int[] sum = obj.sumtwoNumber(numbers, 45);
        if(sum != null)
            System.out.println("Two number sum is: " + sum[0] + ", " + sum[1]);
        else
            System.out.println("No value pair");

        //############################################################//

        System.out.println("\nMerge Sort:");
        int[] numbersList = {2,4,3,1,5,9,0};
        obj.mergeSort(numbers, 0, numbersList.length-1);
        System.out.println("sorted array");
        for(int a : numbers){
            System.out.print(a + ", ");
        }
        System.out.println();

        //############################################################//


        int[] zerOne = {1,1,0,0,1,0,1};


    }

    //==========================================================================//

    // 0.find the longest palindrome in a text
    public String longestPalindrome(String s) {
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
    public int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*******************************************************************/

    // 1. find two numbers in an array that their sum is equal to the specific given value
    public int[] sumPair(int[] numbers, int k){
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
    public int[] sumtwoNumber(int[] numbers, int t){
        List<Integer> values = new ArrayList<>();
        for (int num : numbers){
            if(values.contains(t - num)){
                return new int[] {num, t - num};
            }else {
                values.add(num);
            }
        }
        return null;
    }

    /*******************************************************************/

    // 2. merge sort with merge method
    public void mergeSort(int arr[], int left, int right){
        if(left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int arr[], int left, int mid, int right){
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

    /*******************************************************************/


}
