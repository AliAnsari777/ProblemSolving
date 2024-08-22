package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRank_Medium {

    public static void main(String[] args) {

//        System.out.println("Encryption:");
//        System.out.println(HackerRank_Medium.encryption("if man was meant to stay on the ground god would have given us roots"));

        //############################################################//

        List<List<Integer>> containers = new ArrayList<List<Integer>>();
        containers.add(Arrays.asList(997612619, 934920795, 998879231, 999926463));
        containers.add(Arrays.asList(960369681, 997828120, 999792735, 979622676));
        containers.add(Arrays.asList(999013654, 998634077, 997988323, 958769423));
        containers.add(Arrays.asList(997409523, 999301350, 940952923, 993020546));

        System.out.println("organizingContainers:");
        System.out.println(HackerRank_Medium.organizingContainers(containers));

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

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        int size = container.size();
        long[] rowSum = new long[size];
        long[] colSum = new long[size];;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                rowSum[i] += container.get(i).get(j);
                colSum[i] += container.get(j).get(i);
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        for (int i = 0; i < colSum.length; i++) {
            if(rowSum[i] < colSum[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }

    public static String biggerIsGreater(String w) {
        // Write your code here
        /*
        * Ideas:
        1. Selecting an element that is smallest in a specific substring on the right of the string and swap it with the element (e) next to the left of that substring, which is also in the string.
        2. After that, sort characters on the right of that e in increment order.

        * Steps to identify the smallest element to swap
        1. Traverse from right to left until finds a element that is smaller than the right one.
        2. Then, there is at least 1 way to swap.
        3. Find the smallest one by traversing until satisfy the requirement
        */

        int curIdx = w.length() - 1;
        int leftIdx = curIdx - 1;

        //Find the first of two elements to switch
        while(leftIdx > -1 && w.charAt(leftIdx) >= w.charAt(curIdx)) {
            curIdx--;
            leftIdx--;
        }

        if(leftIdx == -1) {
            return "no answer";
        }

        //Find the second one
        int mid = curIdx;
        while(mid < w.length() - 1 && w.charAt(mid + 1) > w.charAt(leftIdx)) {
            mid++;
        }

        char[] tempC = w.toCharArray();
        //Swap
        char tempSwap = tempC[leftIdx];
        tempC[leftIdx] = tempC[mid];
        tempC[mid] = tempSwap;

        char[] tempRSub = new char[w.length() - curIdx];
        System.arraycopy(tempC, curIdx, tempRSub, 0, w.length() - curIdx);

        //Get new substring
        Arrays.sort(tempRSub);
        System.arraycopy(tempRSub, 0, tempC, curIdx, w.length() - curIdx);

        return new String(tempC);
    }
}
