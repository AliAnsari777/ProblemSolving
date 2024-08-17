
import java.util.*;

public class Paypal {
    public static void main(String[] args) {

//        List<Integer> c = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
//        System.out.println(Paypal.jumpingOnClouds(c));
//
//        //############################################################//
//
//        String s1 = "abcde";
//        String s2 = "bcdefg";
//        System.out.println("Min Deletion");
//        System.out.println(Paypal.minDeletionsToAnagrams(s1, s2));
//
//        //############################################################//
//
//        System.out.println("### Test ###");
//        System.out.println(Math.abs(3-5));
//
//        //############################################################//
//
//        String sample = "aabbccdd";
//        System.out.println(Paypal.isValid(sample));
//
//        //############################################################//
//
//        System.out.println("substring count: ");
//        String test = "aaaa";
//        System.out.println(Paypal.substrCount(4, test));
//
//        //############################################################//
//
//        int[] numbers = {4, 3, 1, 2};
//        System.out.println("array length");
//        System.out.println(numbers.length);
//        System.out.println(Paypal.minimumSwaps(numbers));
//
//        //############################################################//
//
//        System.out.println("Common Child: ");
//        String sample1 = "ABC", sample2 = "ADC";
//        System.out.println(Paypal.commonChild2(sample1, sample2));
//
////        Pair<Integer, Integer> val = new Pair<>();
////        int val = Integer.
//
//        //############################################################//
//
//        System.out.println("###########################################");
//        int[] numbers2 = {6,2,1,0,0,0,1,0,0,0};
//        System.out.println(Paypal.isSelfReferential(numbers2));
//
//
//        System.out.println("Prime ###########################################");
//        System.out.println(Paypal.isPrimeHappy(17));

        String testing = "http://exmaple.com/mypage?token=2j234jl&name=jack&id=12";
        String[] a1 = testing.split("[?&=]");
        System.out.println(Arrays.toString(a1));

    }

    //==========================================================================//


    static int test(){

        return 0;
    }

    static int Martin(int[] a) {
        int one = 0, two = 0;

        if (a.length == 0){
            return 0;
        }

        for (int i = a.length-1; i >= 0; i--) {
            if (a[i] == 1){
                one++;
            } else if(a[i] == 2){
                two++;
            }
            if (i != 0 && a[i] == a[i-1]){
                return 0;
            }
        }

        System.out.println("one " + one);
        System.out.println("two " + two);
        if (one > two){
            return 1;
        } else {
            return 0;
        }
    }

    static int isSelfReferential(int[] a){
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i<a.length; i++) {
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }

         for(int i = 0; i<a.length; i++){
             if (a[i] != count.getOrDefault(i, 0)) {
                return 0;
             }
         }

         return 1;
    }


    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int isPrimeHappy(int n) {
        if (n <= 2) {
            return 0; // PrimeHappy requires at least one prime less than n, and 1 is not considered prime
        }

        long sumOfPrimes = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sumOfPrimes += i;
            }
        }

        if (sumOfPrimes % n == 0) {
            return 1; // n is primeHappy
        } else {
            return 0; // n is not primeHappy
        }
    }



    static int sockMerchant(int n, List<Integer> arr) {
        int count = 0;
        HashSet<Integer> uniqueVal = new HashSet<>(arr);

        for(int val : uniqueVal){
            count += Collections.frequency(arr,val)/2;
        }

        return count;
    }

    //############################################################//

    static int valley(int steps, String path) {
        int result = 0, count = 0;
        char[] paths = path.toCharArray();

        for(char step : paths) {
            if (step == 'U') {
                count++;
                if (count == 0)
                    result++;
            } else {
                count--;
            }
        }

        return result;
    }

    //############################################################//

    static int jumpingOnClouds(List<Integer> c) {
        int jump = 0;

        for (int i = 0; i < c.size()-1; ){
            if (i+2 <= c.size()-1 && c.get(i+2) != 1)
                i += 2;
            else
                i++;

            jump++;
        }
        return jump;
    }

    //############################################################//

    static long repeatedString(String s, long n) {
        // Write your code here
        long num =  s.chars().filter(value -> value == 'a').count();
        long result = (n / s.length()) * num;

        n %= s.length();

        for(int i = 0; i<n; i++) {
            if(s.charAt(i) == 'a')
                result++;
        }

        return result;
    }

    //############################################################//

    public static int minDeletionsToAnagrams(String s1, String s2) {
        // Step 1: Count the frequency of characters in both strings
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find the difference in character frequencies between the two strings
        for (char ch : s2.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1);
        }

        // Step 3: Calculate the minimum number of character deletions required
        int deletions = 0;
        for (int frequency : freqMap.values()) {
            deletions += Math.abs(frequency);
        }
        return deletions;
    }

    //############################################################//

    static int alternatingCharacters(String s) {
        // Write your code here
        int result = 0;
        for(int i = s.length()-1; i > 0; i--){
            if(s.charAt(i) == s.charAt(i-1))
                result++;
        }
        return result;
    }

    //############################################################//

    static String isValid(String s) {

        // Count the frequency of each character in the string
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Count the frequency of each frequency value
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int frequency : charFrequency.values()) {
            freqCount.put(frequency, freqCount.getOrDefault(frequency, 0) + 1);
        }

        // Check if all characters have the same frequency
        if (freqCount.size() == 1) {
            return "YES";
        }

        // Check if removing one character makes the remaining frequencies the same
        if (freqCount.size() == 2) {
            int maxFreq = freqCount.keySet().stream().max(Integer::compareTo).orElse(0);
            int minFreq = freqCount.keySet().stream().min(Integer::compareTo).orElse(0);

            if ((freqCount.get(maxFreq) == 1 && (maxFreq - minFreq) == 1) ||
                    (freqCount.get(minFreq) == 1 && minFreq == 1)) {
                return "YES";
            }
        }

        return "NO";
    }

    //############################################################//

    // this is my code but with o(n3) which didn pass test cases
    public static long substrCount2(int n, String s) {
        long result = (long)n;

        for(int i = 0; i < n; i++){
            for(int j = i+2; j <= n; j++){
                String sub = s.substring(i, j);
                if(palindromeTest(sub)){
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean palindromeTest(String text) {
        int i = 0, j = text.length()-1;
        long val = text.chars().distinct().count();
        if (val > 2){
            return false;
        }
        while(i < j){
            if(text.charAt(i) != text.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //############################################################//

    static int count;
    public static long substrCount(int n, String s) {
        count = 0;
        //O(n^2)
        for(int i = 0 ; i < n;i++){//O(n)
            helperOdd(i,i,s);//0(n)
            helperEven(i,i+1,s);//O(n)
        }
        return count;
    }

    static void helperEven(int i, int j, String s){
        if(i >=0 && j < s.length()){
            char c = s.charAt(i);
            while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)&& s.charAt(i) == c){
                count++;
                i--;
                j++;
            }
        }

    }
    static void helperOdd(int i, int j, String s){
        count++;
        i--;
        j++;

        helperEven(i, j, s);
    }

    //############################################################//

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

    //############################################################//

    /*
    A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from
    the other string. Letters cannot be rearranged. Given two strings of equal length, what's the longest string
    that can be constructed such that it is a child of both?
    */
    public static int commonChild2(String s1, String s2)
    {
        int m = s1.length() + 1, n = s2.length() + 1;
        int[][] LCS = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LCS[i][j] = LCS[(i - 1)][(j - 1)] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[(i - 1)][j], LCS[i][(j - 1)]);
                }
            }
        }
        return LCS[(m - 1)][(n - 1)];
    }


}
