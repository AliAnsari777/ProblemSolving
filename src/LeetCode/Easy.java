package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Easy {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(Easy.twoSum(numbers, 18)));

        //############################################################//

        System.out.println("\nRoman to Integer");
        System.out.println(Easy.romanToInt("IV"));

    }

    //==========================================================================//


    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (result.containsKey(temp)){
                return new int[]{result.get(temp), i};
            }
            result.put(numbers[i], i);
        }
        return new int[]{};
    }

    /*******************************************************************/

    public static int romanToInt(String roman) {
        char[] romanChar = roman.toCharArray();
        int result = 0;

        for (int i = 0; i < romanChar.length; i++) {
            switch (romanChar[i]){
                case 'I':
                    if (i+1 < romanChar.length && romanChar[i + 1] == 'V') {
                        result += 4;
                        i++;
                    } else if (i+1 < romanChar.length && romanChar[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i+1 < romanChar.length && romanChar[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if (i+1 < romanChar.length && romanChar[i + 1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i+1 < romanChar.length && romanChar[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if (i+1 < romanChar.length && romanChar[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }

        return result;
    }

}
