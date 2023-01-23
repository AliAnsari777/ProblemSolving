package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Easy {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(Easy.twoSum(numbers, 18)));

        //############################################################//

        System.out.println("\nRoman to Integer");
        System.out.println(Easy.romanToInt("MCMXCII"));
        System.out.println(Easy.romanToIntEnhanced("MCMXCII"));

        //############################################################//

        System.out.println("\nMerge Two sorted linked list");
        Easy.ListNode one = new Easy.ListNode(2);
        one.next = new Easy.ListNode(3);
        one.next.next = new Easy.ListNode(4);

        Easy.ListNode two = new Easy.ListNode(4);
        two.next = new Easy.ListNode(5);
        two.next.next = new Easy.ListNode(6);
        two.next.next.next = new Easy.ListNode(8);
        two.next.next.next.next = new Easy.ListNode(17);

        Easy.ListNode result = Easy.mergeTwoLists(one, two);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        //############################################################//

        System.out.println("\nRemove Duplicate Numbers From Array");
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums1 = {0, 0, 1};
        int[] nums2 = {};

        System.out.println(Easy.removeDuplicates(nums2));

        //############################################################//

        System.out.println("\nRemove Element From Array");
        int[] number = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] number2 = {3, 2, 2, 3};

        System.out.println(Easy.removeElement(number2, 2));

        //############################################################//

        System.out.println("\nRemove Linked List Element");
        Easy.ListNode nodes = new Easy.ListNode(1);
        nodes.next = new Easy.ListNode(2);
        nodes.next.next = new Easy.ListNode(3);
        nodes.next.next.next = new Easy.ListNode(1);
//        nodes.next.next.next.next = new Easy.ListNode(4);
//        nodes.next.next.next.next.next = new Easy.ListNode(5);
//        nodes.next.next.next.next.next.next = new Easy.ListNode(6);

        Easy.ListNode answer = Easy.removeElements(nodes, 1);

        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }

        //############################################################//

        System.out.println("\nSearch Insert Position");
        int[] values = {1, 3};

        System.out.println(Easy.searchInsert(values, 3));

        //############################################################//

        System.out.println("\n278. First Bad Version");
        System.out.println(Easy.firstBadVersion(1));

        //############################################################//

        System.out.println("\n58. Length of Last Word");
        System.out.println(Easy.lengthOfLastWord("   fly me   to   the moon  "));

        //############################################################//

        System.out.println("\n66. Plus One");

        int[] answer2 = Easy.plusOne1(new int[]{1, 2, 5, 8, 9});
        Arrays.stream(answer2).forEach(System.out::println);

        //############################################################//

        String text = "PAYPALISHIRING";
        System.out.println("\n6. Zigzag Conversion");
        System.out.println(Easy.convert(text, 3));

        //############################################################//


    }

    //==========================================================================//


    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (result.containsKey(temp)) {
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
            switch (romanChar[i]) {
                case 'I':
                    if (i + 1 < romanChar.length && romanChar[i + 1] == 'V') {
                        result += 4;
                        i++;
                    } else if (i + 1 < romanChar.length && romanChar[i + 1] == 'X') {
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
                    if (i + 1 < romanChar.length && romanChar[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if (i + 1 < romanChar.length && romanChar[i + 1] == 'C') {
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
                    if (i + 1 < romanChar.length && romanChar[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if (i + 1 < romanChar.length && romanChar[i + 1] == 'M') {
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

    /*******************************************************************/

    public static int romanToIntEnhanced(String roman) {
        int result = 0;
        Stack<Integer> numbers = new Stack<>();
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        for (int i = 0; i < roman.length(); i++) {
            int value = values.get(roman.charAt(i));
            if (numbers.empty() || numbers.peek() >= value) {
                numbers.add(value);
            } else {
                int val = value - numbers.peek();
                numbers.pop();
                numbers.add(val);
            }
        }

        while (!numbers.empty()) {
            result += numbers.pop();
        }

        return result;
    }

    /*******************************************************************/

    static class ListNode {
        int val;
        Easy.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Easy.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        head.next = list1 == null ? list2 : list1;

        return result.next;
    }

    // This solution was in discussion
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*******************************************************************/
    public static int removeDuplicates(int[] nums) {
        int first = 0, answer = nums.length >= 1 ? 1 : 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[first] != nums[i]) {
                first++;
                answer++;
                nums[first] = nums[i];
            }
        }

        return answer;
    }

    /*******************************************************************/

    public static int removeElement(int[] nums, int val) {
        int result = 0;

        for (int a : nums) {
            if (a != val) {
                nums[result] = a;
                result++;
            }
        }
        return result;
    }

    /*******************************************************************/

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /*******************************************************************/

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = end + (start - end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = Math.max(mid - 1, 0);
            else
                start = mid + 1;
        }
        return nums[end] < target ? end + 1 : end;
    }

    /*******************************************************************/

    public static int firstBadVersion(int n) {
        int start = 0, mid;

        while (n - start > 1) {
            mid = n + Math.floorDiv((start - n), 2);
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                start = mid;
            }
        }
        return n;
    }

    private static boolean isBadVersion(int mid) {
        return mid >= 1;
    }

    /*******************************************************************/

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    /*******************************************************************/

    public static int[] plusOne(int[] digits) {
        int size = digits.length - 1;
        int val = 1;
        Stack<Integer> stack = new Stack<>();

        if (digits[size] + val >= 10) {
            for (int i = size; i >= 0; i--) {
                if (digits[i] + val >= 10) {
                    stack.push(0);
                } else {
                    stack.push(digits[i] + val);
                    val = 0;
                }
            }

            if (val != 0) {
                stack.push(val);
            }
        } else {
            digits[size] += 1;
        }
        int length = stack.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result.length > 0 ? result : digits;
    }

    public static int[] plusOne1(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    /*******************************************************************/

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int idx = 0;
        while (idx < size) {
            for (int i = 0; i < numRows && idx < size; i++) {
                sb[i].append(chars[idx++]);
            }

            for (int i = numRows - 2; i >= 1 && idx < size; i--) {
                sb[i].append(chars[idx++]);
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

    public static int solution(String pattern, String source) {
        int result = 0;
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] patt = pattern.toCharArray();
        char[] src = source.toCharArray();
        int j = 0;

        if (pattern.length() > source.length()) {
            return 0;
        }

        for (int i = 0; i < src.length - patt.length; i++) {
            for (int k = 0; k < patt.length; k++) {
                if (patt[k] == '0' && Arrays.asList(vowels).contains(src[i + k])) {
                    j++;
                    System.out.println("first: " + j);
                } else if (patt[k] == '1' && !Arrays.asList(vowels).contains(src[i + k])) {
                    j++;
                    System.out.println("second: " + j);
                } else {
                    j = 0;
                }
            }

            if (j == patt.length) {
                result++;
                j = 0;
            }
        }

        return result;
    }
}
