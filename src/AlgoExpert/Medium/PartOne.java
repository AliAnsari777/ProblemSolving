package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartOne {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(12, 3, 1, 2, -6, 5, -8, 6, 10));
        System.out.println(tripleSum(numbers, 0));

        //############################################################//

        List<Integer> firstArray = new ArrayList<>(Arrays.asList(-1, 5, 10, 20, 28, 3));
        List<Integer> secondArray = new ArrayList<>(Arrays.asList(26, 134, 135, 15, 17));
        System.out.println(smallestDifference(firstArray, secondArray));
    }


    public static List<List<Integer>> tripleSum(List<Integer> numbers, int target) {

        int left, right;
        List<List<Integer>> result = new ArrayList<>();
        numbers.sort(null);

        for(int i = 0; i < numbers.size(); i++) {
            left = i+1;
            right = numbers.size() - 1;

            while (left < right) {
                int sum = numbers.get(i) + numbers.get(right) + numbers.get(left);

                if(sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numbers.get(i));
                    triplet.add(numbers.get(left));
                    triplet.add(numbers.get(right));
                    result.add(triplet);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /*******************************************************************/

    public static int smallestDifference(List<Integer> first, List<Integer> second) {
        int firstIdx = 0;
        int secondIdx = 0;
        int smallDiff = Integer.MAX_VALUE;
        first.sort(null);
        second.sort(null);

        while(firstIdx < first.size() && secondIdx < second.size()) {
            int diff = Math.abs(first.get(firstIdx) - second.get(secondIdx));

            if(diff == 0)
                return 0;

            if(diff < smallDiff)
                smallDiff = diff;

            if(first.get(firstIdx) < second.get(secondIdx))
                firstIdx++;
            else
                secondIdx++;
        }

        return smallDiff;
    }
}
