package KickStart;

import java.util.*;
import java.io.*;

public class roundB {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String m = in.next();
            StringBuilder result = new StringBuilder("1 ");
            int count = 1;

            for (int j = 1; j < m.length(); j++) {
                if(m.charAt(j-1) < m.charAt(j)){
                    count++;
                    result.append(count).append(" ");
                }else{
                    result.append("1 ");
                    count = 1;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}