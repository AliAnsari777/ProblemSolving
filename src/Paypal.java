import sun.util.resources.LocaleData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Paypal {
    public static void main(String[] args) {

        List<Integer> c = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        System.out.println(Paypal.jumpingOnClouds(c));

        //############################################################//

        String s1 = "abcde";
        String s2 = "bcdefg";
        System.out.println("Min Deletion");
        System.out.println(Paypal.minDeletionsToAnagrams(s1, s2));

        //############################################################//

        System.out.println("### Test ###");
        System.out.println(Math.abs(3-5));

        //############################################################//

        String sample = "aabbccdd";
        System.out.println(Paypal.isValid(sample));

        //############################################################//

        System.out.println("substring count: ");
        String test = "aaaa";
        System.out.println(Paypal.substrCount(4, test));

    }

    //==========================================================================//


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
}
