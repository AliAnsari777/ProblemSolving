package KickStart.Round_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecordBreaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[] list = new int[n];
            int max = -1, result = 0;

            for (int j = 0; j < n; j++) {
                int number = in.nextInt();
                list[j] = number;
            }

            for (int j = 0; j < n; j++) {
                if(max < list[j] && (j+1 == n || list[j] > list[j+1])){
                    result++;
                }
                if (max < list[j])
                    max = list[j];
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}