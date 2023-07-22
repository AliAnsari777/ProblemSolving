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

    public static long substrCount(int n, String s) {
        long result = (long)n;
        HashMap<Integer, List> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
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

}
