package KickStart;


import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.




        for (int i = 1; i <= t; ++i) {
            List<Integer> number = new ArrayList<>();
            List<Integer> longest = new ArrayList<>();
            int first = 0, second = 0, count = 2;
            boolean change = true;

            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                number.add(in.nextInt());
            }

            first = number.get(0) - number.get(1);
            for (int j = 2; j < number.size(); j++) {
                second = number.get(j-1) - number.get(j);

                if(first == second){
                    count++;
                }else if(change){
                    count++;
                    change = false;
                    number.set(j, number.get(j-1)+first);
                } else {
                    longest.add(count);
                    count = 2;
                    change = true;
                }
            }
            longest.add(count);

            System.out.println("Case #" + i + ": " + Collections.max(longest));
        }
    }
}