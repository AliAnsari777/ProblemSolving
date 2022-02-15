package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class HackerRank_Medium {

    public static void main(String[] args) {

        System.out.println("Encryption:");
        System.out.println(HackerRank_Medium.encryption("if man was meant to stay on the ground god would have given us roots"));

        //############################################################//

    }

    //==========================================================================//


    public static String encryption(String s) {
        String temp, column;
        List<String> grid = new ArrayList<>();
        int row, col, size;
        StringBuilder result = new StringBuilder();

        temp = s.replaceAll("\\s", "");;
        size = temp.length();
        col = (int)Math.ceil(Math.sqrt(size));;

        for (int i = col; i > 0; i--) {
            if (temp.length() == 0)
                continue;
            else if (temp.length() < col){
                grid.add(temp);
                temp = "";
                continue;
            }
            column = temp.substring(0, col);
            temp = temp.substring(col);
            grid.add(column);
        }

        row = grid.size();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp = grid.get(j);
                if (temp.length() <= i)
                    continue;
                result.append(temp.charAt(i));
            }
            result.append(" ");
        }

        return result.toString();
    }

    /*******************************************************************/


}
