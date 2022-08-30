package AlgoExpert.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoNumbers {
    public static void main(String[] args) {
        int[] numbers = {4,8,2,1,9,13,64,7,10};
        int target = 17;
        TwoSumWithSort(numbers, target);
        TwoSumWithoutSort(numbers, target);
    }

    // Time Complexity: O(n log(n))     Space: O(1) if we don't consider the result array and return the value directly
    private static void TwoSumWithSort(int[] numbers, int target) {
        List<Object> result = new ArrayList<>();

        int front = 0, end = numbers.length-1;

        numbers = Arrays.stream(numbers).sorted().toArray();
        for (int i = 0; i < numbers.length - 1 && front < end ; i++) {
            if (numbers[front] + numbers[end] > target){
                end--;
            } else if (numbers[front]+ numbers[end] < target){
                front++;
            } else if (numbers[front]+ numbers[end] == target){
                result.add(new int[]{numbers[front], numbers[end]});
                front++;
                end--;
            }
        }

        System.out.println(Arrays.deepToString(result.toArray()));
    }

    // Time Complexity: O(n)     Space: O(n) if we don't consider the result array and return the value directly
    private static void TwoSumWithoutSort(int[] numbers, int target){
        List num = new ArrayList<>();
        List<Object> result = new ArrayList<>();

        for (int number : numbers) {
            if (num.contains(target - number)) {
                result.add(new int[]{number, target - number});
            } else {
                num.add(number);
            }
        }
        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
