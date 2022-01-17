package HackerRank;

import java.util.Arrays;
import java.util.List;

public class HackerRank_4 {
    public static void main(String[] args) {

        System.out.println("Angry Professon:");
        System.out.println(HackerRank_4.angryProfessor(3, Arrays.asList(-1, -3, -2, 0, 1, 4, 7)));

        //############################################################//

        System.out.println(beautifulDays(20, 23, 6));

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
}
