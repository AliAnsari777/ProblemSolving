import sun.awt.util.IdentityLinkedList;

import java.util.*;

public class Hackerrank {

    public static void main(String[] args) throws Exception {

//        // Simple Array Sum
//        int[] simpleArray = {7,5,3,8,4,2,1};
//        System.out.println("Simple Array Sum: " + Hackerrank.simpleArraySum(simpleArray));

        //############################################################//

//        // Compare the Triplets
//        List<Integer> A = new ArrayList<>();
//        List<Integer> B = new ArrayList<>();
//        A.add(10);
//        A.add(20);
//        A.add(30);
//        B.add(5);
//        B.add(15);
//        B.add(50);
//        List<Integer> triplets = compareTriplets(A, B);
//        System.out.print("Compare The Triplets: ");
//        for(int i : triplets) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();

        //############################################################//

//        // A very big sum
//        long[] bigArray = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
//        System.out.println("Very Big Sum: " + Hackerrank.aVeryBigSum(bigArray));

        //############################################################//

//        // Diagonal Difference
//        List<List<Integer>> diagonal = new ArrayList<>();
//        List<Integer> one = Arrays.asList(11,2,4);
//        List<Integer> two = Arrays.asList(4,5,6);
//        List<Integer> three = Arrays.asList(10,8,-12);
//        diagonal.add(one);
//        diagonal.add(two);
//        diagonal.add(three);
//        System.out.println("Diagonal Difference: " + Hackerrank.diagonalDifference(diagonal));

        //############################################################//

//        // Plus Minus
//        int[] plusMinus = {4, 7, -8, -2, 0};
//        System.out.println("Plus Minus: ");
//        Hackerrank.plusMinus(plusMinus);

        //############################################################//

//        // Staircase
//        System.out.println("Staircase: ");
//        Hackerrank.staircase(5);

        //############################################################//

//        // MinMaxSum
//        int[] minMax = {3,5, 8, 9, 2};
//        System.out.println("Min Max Sum: ");
//        Hackerrank.miniMaxSum(minMax);

        //############################################################//

//        // BirthdayCakeCandles
//        int[] candles = {4,7,3,7};
//        System.out.println("Birthday Cake Candles: ");
//        System.out.println(Hackerrank.birthdayCakeCandles(candles));

        //############################################################//

//        // TimeConversion
//        String time = "07:05:45PM";
//        System.out.println("Time Conversion: ");
//        System.out.println(Hackerrank.timeConversion(time));

        //############################################################//

//        // Text Palindrome
//        String palindrome = "madam";
//        System.out.println("Is the text palindrome: " + palindrome);
//        System.out.println(Hackerrank.palindrome(palindrome));

        //############################################################//

//        // Grading Students
//        List<Integer> grades = new ArrayList<>(Arrays.asList(73, 67, 38, 33));
//        System.out.println("Grading Students: ");
//        System.out.println(Hackerrank.gradingStudents(grades));

        //############################################################//

//        // kangaroo
//        System.out.println("Kangaroo: ");
//        System.out.println(Hackerrank.kangaroo(0, 3, 4, 2));

        //############################################################//

//        // ZigZagSequence
//        int[] list = {4,3,2,1,5,7};
//        System.out.println("Zig Zag Sequence: ");
//        try {
//            Hackerrank.findZigZagSequence(list, 6);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        //############################################################//

//        // CountAppleAndOranges
//        int[] apples = {-2, 2, 1};
//        int[] oranges = {5, -6};
//        System.out.println("Count Apples and Oranges: ");
//        Hackerrank.countApplesAndOranges(7, 11, 5, 15, apples, oranges);

        //############################################################//

//        // Breaking Record
//        int[] records = {10, 5, 20, 20, 4, 5, 2, 25, 1};
//        System.out.println("Breaking Record: ");
//        int[] result = Hackerrank.breakingRecords(records);
//        for(int r : result){
//            System.out.print(r + " ");
//        }
//        System.out.println();

        //############################################################//

        List<Integer> cack = new ArrayList<>(Arrays.asList(1,2,1,3,5));
        System.out.println(Hackerrank.birthday(cack,3, 2));

        //############################################################//

        int[] socks = {1, 3, 2, 1, 5, 5, 2, 7, 4};
        System.out.println("Matching Pair of Numbers in an array: ");
        System.out.println(Hackerrank.sockMerchant(socks.length, socks));
    }


//==========================================================================//

    // This is "Simple Array Sum" problem
    // This method sum all the elements of an array and return on integer value.
    static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int value : ar) {
            sum += value;
        }
        return sum;
    }

    /*******************************************************************/

    // This is "Compare the Triplets" problem
    // This method takes two list of integers and compare them and if first number of list "a" is bigger than
    // first number of list "b" we add one score for first list in "result list".
    // read full description in hackerrank.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);
        for(int i=0; i<a.size(); i++){
            if(a.get(i) > b.get(i))
                result.set(0,result.get(0) + 1);
            else if(a.get(i) < b.get(i))
                result.set(1,result.get(1) + 1);
        }
        return result;
    }

    /*******************************************************************/

    // this is the "very big sum" problem.
    // Calculate and print the sum of the elements in an array,
    // keeping in mind that some of those integers may be quite large.
    static long aVeryBigSum(long[] ar) {
        long result = 0;
        for(int i = 0; i<ar.length; i++){
            result += ar[i];
        }
        return result;
    }

    /*******************************************************************/

    // This is the "Diagonal Difference" problem
    // Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    public static int diagonalDifference(List<List<Integer>> arr) {
        int arrSize = arr.size();
        int leftSum =0,rightSum = 0;
        for (int i = 0; i < arrSize; i++) {
            leftSum += arr.get(i).get(i);
        }
        for (int i = 0; i < arrSize; i++) {
            rightSum += arr.get(arrSize - i -1).get(i);
        }
        return Math.abs(leftSum - rightSum);
    }

    /*******************************************************************/

    // This is "Plus Minus" problem
    // Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros.
    // Print the decimal value of each fraction on a new line.
    static void plusMinus(int[] arr) {
        float pos=0, neg=0, zero=0;
        int size = arr.length;
        for(int i = 0; i<size; i++){
            if(arr[i] > 0) pos++;
            else if(arr[i] < 0) neg++;
            else zero++;
        }
        System.out.printf("%.6f %n",pos/size);
        System.out.printf("%.6f %n",neg/size);
        System.out.printf("%.6f %n",zero/size);
    }

    /*******************************************************************/

    // This is "Staircase" Problem
    static void staircase(int n) {
        for(int i = 0, j = n - 1; i<n; i++, j--){
            for(int a = 0; a < n; a++){
                if(a < j)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    /*******************************************************************/

    // This is "MinMaxSum" problem
    // Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly
    // four of the five integers. Then print the respective minimum and maximum values as a single line of two
    // space-separated long integers.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = 0, max = 0;
        for(int i = 0; i < arr.length - 1; i++ ){
            min += arr[i];
        }

        for(int i = 1; i < arr.length; i++ ){
            max += arr[i];
        }

        System.out.println(min + " " + max);
    }

    /*******************************************************************/

    // This is "Birthday Cake Candles" Problem
    // In this method we find how many times the biggest number repeated in the given array.
    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);
        int tallest = ar[ar.length-1], count = 0;
        for (int i = ar.length-1; i >= 0; i--) {
            if(tallest == ar[i]){
                count++;
            }
        }
        return count;
    }

    /*******************************************************************/

    // This is "Time Conversion" problem
    //Given a time in -hour AM/PM format, convert it to military (24-hour) time.
    //Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a
    // 12-hour clock, and 12:00:00 on a 24-hour clock
    static String timeConversion(String s) {
        String[] temp = s.split("(:|(?=P)|(?=A))");
        int hour = Integer.parseInt(temp[0]);
        if (temp[3].equals("PM")){
            if(hour != 12)
                hour += 12;
            return hour + ":" + temp[1] + ":" + temp[2];
        }else{
            if(hour == 12){
                return "00" + ":" + temp[1] + ":" +temp[2];
            }
            return temp[0] + ":" + temp[1] + ":" + temp[2];
        }
    }

    /*******************************************************************/

    // This is "Palandrom" problem for text
    static boolean palindrome(String text){
        for(int i = 0; i<text.length()/2; i++){
            if(text.charAt(i) != text.charAt(text.length()-i -1)){
                return false;
            }
        }
        return true;
    }

    /*******************************************************************/

    // This is "Grading Students" problem
    static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> score = new ArrayList<>();
        int temp = 0;
        for(int g : grades){
            if(g<38){
                score.add(g);
                continue;
            }
            temp = (g / 5 + 1) * 5;
            if((temp - g) < 3){
                score.add(temp);
            }else{
                score.add(g);
            }
        }
        return score;
    }

    /*******************************************************************/

    // This is the "kangaroo" problem.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 <= v2 ){
            return "NO";
        }

        if(((x2 - x1) % (v2 - v1)) == 0){
            return "YES";
        }else{
            return "NO";
        }

    }

    /*******************************************************************/

    //
    static void findZigZagSequence(int [] a, int n) throws Exception {
        if (n > a.length)
            throw new Exception("Number can't be bigger than array length");

        Arrays.sort(a);
        int mid = (n)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = mid + 2;
        while(ed < n-1){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed + 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    /*******************************************************************/

    // 's' is start and 't' is end point of our range. 'a' is a point before start and 'b' is a point after end.
    // we just check values in apples array by summing them with 'a' value to see are there in our rage or not.
    // and do same with oranges array. and if they were in range we increase apple or orange counter.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int apple = 0, orange = 0;
        for(int i=0; i<apples.length; i++){
            apples[i] += a;
            if(apples[i] >= s && apples[i] <= t)
                apple++;
        }
        for(int j = 0; j < oranges.length; j++){
            oranges[j] += b;
            if(oranges[j] >= s && oranges[j] <= t)
                orange++;
        }

        System.out.println(apple);
        System.out.println(orange);
    }

    /*******************************************************************/

    //
    static int[] breakingRecords(int[] scores) {
        int max = scores[0], min = scores[0];
        int[] result = new int[2];

        for(int i = 1; i < scores.length; i++){
            if(scores[i] > max){
                max = scores[i];
                result[0]++;
            }else if(scores[i] < min){
                min = scores[i];
                result[1]++;
            }
        }
        return result;
    }

    /*******************************************************************/

    static int birthday(List<Integer> s, int d, int m) {
        int count = 0, temp = 0;
        for (int i = 0; i < m; i++) {
            temp += s.get(i);
        }
        for (int i = 0; i < s.size() - m + 1; i++) {
            if(temp == d)
                count++;

            if (i+m < s.size()){
                temp = temp - s.get(i) + s.get(i+m);
            }
        }
        return count;
    }

    /*******************************************************************/

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> check = new HashMap<>();
        int pairs = 0;

        for(int i =0; i<ar.length; i++){
            if(!check.containsKey(ar[i])){
                check.put(ar[i], i);
            }else{
                pairs++;
                check.remove(ar[i]);
            }
        }

        return pairs;
    }
}
