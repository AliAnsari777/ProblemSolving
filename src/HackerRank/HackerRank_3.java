package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRank_3 {
    public static void main(String[] args) {

        List<Integer> roteated = Arrays.asList(1,2,3,4,5);
        roteated = HackerRank_3.rotateLeft(2, roteated );
        for (int a : roteated) {
            System.out.println(a);
        }

        //############################################################//




        //############################################################//
    }


    //==========================================================================//


    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int j = 0;
        for(int i = d; i < arr.size(); i++, j++){
            result.add(j, arr.get(i));
        }

        for(int i = 0; i < d; i++, j++){
            result.add(j, arr.get(i));
        }

        return result;
    }

    /*******************************************************************/


}
