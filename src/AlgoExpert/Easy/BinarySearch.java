package AlgoExpert.Easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2,4,6,7,8,9};
        int result = BinarySearch.binarySearch(array, 9);
        System.out.println(result);
    }

    public static int binarySearch(int[] numbers, int target) {
        int left, right, middle;
        left = 0;
        right = numbers.length - 1;

        while (left <= right) {
            middle = (int)Math.floor((left + right) / 2);
            if (numbers[middle] == target) {
                return middle;
            }

            if (numbers[middle] < target)
                left = middle + 1;
            else if (numbers[middle] > target)
                right = middle - 1;
        }

        return -1;
    }
}
