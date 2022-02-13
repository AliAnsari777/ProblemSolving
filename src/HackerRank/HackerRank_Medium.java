package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class HackerRank_Medium {

    public static void main(String[] args) {

        HackerRank_Medium.encryption("if man was meant to stay on the ground god would have given us roots");

        //############################################################//


    }

    //==========================================================================//


    public static String encryption(String s) {
        String result = "this is for test", temp, column;
        List<String> grid = new ArrayList<>();
        int row, col, size;

        temp = s.replaceAll("\\s", "");;
        size = temp.length();
        row = (int)Math.floor(Math.sqrt(size));
        col = (int)Math.ceil(Math.sqrt(size));;

        if (row * col >= size) {
            for (int i = col; i > 1; i--) {
                if (temp.length() < col){
                    grid.add(temp);
                    continue;
                }
                column = temp.substring(0, col);
                temp = temp.substring(col);
                grid.add(column);
            }
        }



        return result;
    }

    /*******************************************************************/


}
