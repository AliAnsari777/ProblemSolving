package KickStart.Round_E;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LongestArithmetic {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int result = 1, max = 1;
            int[] dif = new int[n-1];
            int[] list = new int[n];

            for (int j = 0; j < n; j++) {
                int number = in.nextInt();
                list[j] = number;
            }

            for (int j = 0; j+1 < n; j++) {
                dif[j] = list[j+1] - list[j];
            }

            for (int j = 1; j < n-1; j++) {
                if (dif[j] == dif[j-1]) {
                    result++;
                }
                else {
                    result = 1;
                }
                max = Math.max(max, result);
            }

            max++;

            System.out.println("Case #" + i + ": " + max);
        }
    }
}
