package HackerRank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HackerRank_4 {
    public static void main(String[] args) {

        System.out.println("Angry Professor:");
        System.out.println(HackerRank_4.angryProfessor(3, Arrays.asList(-1, -3, -2, 0, 1, 4, 7)));

        //############################################################//

        System.out.println("Beautiful Days:");
        System.out.println(beautifulDays(20, 23, 6));

        //############################################################//

        System.out.println("Viral Advertising:");
        System.out.println(HackerRank_4.viralAdvertising(4));

        //############################################################//

        System.out.println("Save The Prisoner:");
        System.out.println(HackerRank_4.saveThePrisoner(5, 2, 2));

        //############################################################//

        System.out.println("Circular Array Rotation");
        List<Integer> array = Arrays.asList(3,4,5);
        List<Integer> queries = Arrays.asList(1,2);
        System.out.println(HackerRank_4.circularArrayRotation(array, 2, queries));

        //############################################################//

        System.out.println("Sequence Equation:");
        List<Integer> sequence = Arrays.asList(4, 3, 5, 1, 2);
        System.out.println(HackerRank_4.permutationEquation(sequence));

        //############################################################//

        System.out.println("Page Count:");
        System.out.println(HackerRank_4.pageCount(6, 2));

        //############################################################//

        int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println("Jumping on Clouds:");
        System.out.println(HackerRank_4.jumpingOnClouds(clouds, 2));

        //############################################################//

        System.out.println("Find Digit:");
        System.out.println(HackerRank_4.findDigits(124));

        //############################################################//

        String chars = "1010111001010";
        System.out.println(HackerRank_4.appleTest(chars));
    }

    //==========================================================================//


    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int val : a) {
            if (val <= 0)
                count++;
        }

        if (count >= k)
            return "NO";
        else
            return "YES";
    }

    /*******************************************************************/

    public static int beautifulDays(int i, int j, int k) {

        int result = 0, reverse;
        while (i <= j){
            reverse = reverseNumber(i);
            if (Math.abs(i - reverse) % k == 0)
                result++;

            i++;
        }
        return result;
    }

    static int reverseNumber(int number){
        int reminder = 0;
        while (number > 0){
            reminder =  (reminder * 10) + (number % 10);
            number /= 10;
        }
        return reminder;
    }

    /*******************************************************************/

    public static int viralAdvertising(int n) {
        int cumulativeCount = 0, start = 5, likes = 0;
        for (int i = 1; i <= n; i++){
            likes = (int) Math.floor(start / 2);
            cumulativeCount += likes;
            start = likes * 3;
        }
        return cumulativeCount;
    }

    /*******************************************************************/

    public static int saveThePrisoner(int n, int m, int s) {
//        int result, reminder;
//
//        reminder = m % n;
//        result = s - 1 + reminder;
//        if (result > n)
//            result -= n;

        return ((s - 1 + m - 1) % n) + 1;
    }

    /*******************************************************************/

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(a);

        int lastEle = a.size()-1;

        for (int i = 0; i < k; i++) {
            int val = temp.remove(lastEle);
            temp.add(0, val);
        }

        for (Integer query : queries) {
            result.add(temp.get(query));
        }
        return result;
    }

    /*******************************************************************/

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> result = new ArrayList<>();
        int size = p.size(), index, y;

        for (int x = 1; x <= size; x++) {
            index = p.indexOf(x)+1;
            y = p.indexOf(index)+1;
            result.add(y);
        }

        return result;
    }

    /*******************************************************************/

    public static int pageCount(int n, int p) {
        n = n % 2 == 0 ? n + 1 : n;
        int mid = n / 2;
        if(p <= mid) {
            return p / 2;
        } else {
            return (n - p) / 2;
        }
    }

    /*******************************************************************/

    static int jumpingOnClouds(int[] c, int k) {
        int idx = 0, energy = 100;
        do{

            if(c[idx] == 1){
                energy -= 3;
            } else {
                energy--;
            }
            idx = (idx + k) % (c.length);
        } while(idx != 0);

        return energy;
    }

    /*******************************************************************/

    // An integer d is a divisor of an integer n if the remainder of  n / d = 0.
    // n=124
    // Check whether 1, 2 and 4 are divisors of 124. All 3 numbers divide evenly into 124 so return 3 .
    public static int findDigits(int n) {
        int counter = 0, digit, number = n;

        while(number >= 1) {
            digit = number % 10;
            number = number / 10;
            if(digit != 0 && n % digit == 0){
                counter++;
            }
        }

        return counter;
    }

    /*******************************************************************/

    static int appleTest(String s){
        List<Character> chars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i =  0; i < chars.size()-1; i++) {
            if (chars.size() > 1 && chars.get(i) != chars.get(i + 1) && chars.get(i) != '*' && chars.get(i + 1) != '*') {
                chars.remove(i);
                chars.remove(i);
                i = -1;
            }
        }
        return chars.size();
    }
}
