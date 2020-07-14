import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hackerrank {

    public static void main(String[] args) {

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

        // TimeConversion
        String time = "07:05:45PM";
        System.out.println("Time Conversion: ");
        System.out.println(Hackerrank.timeConversion(time));

        //############################################################//


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


}
