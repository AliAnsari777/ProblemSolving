package HackerRank;

import java.util.Arrays;
import java.util.List;

public class HackerRank_4 {
    public static void main(String[] args) {

        System.out.println("Angry Professon:");
        System.out.println(HackerRank_4.angryProfessor(3, Arrays.asList(-1, -3, -2, 0, 1, 4, 7)));

        //############################################################//


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


}
