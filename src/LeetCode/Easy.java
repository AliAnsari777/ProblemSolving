package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

        Easy.ListNode result = Easy.mergeTwoLists(one, two);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

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
        ListNode temp;
        ListNode head = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp = new ListNode(list2.val);
                list2 = list2.next;
            }

            head.next = temp;
            head = head.next;

        }

        while (list1 != null) {
            temp = new ListNode(list1.val);
            list1 = list1.next;
            head.next = temp;
            head = head.next;
        }

        while (list2 != null) {
            temp = new ListNode(list2.val);
            list2 = list2.next;
            head.next = temp;
            head = head.next;
        }
        return result.next;
    }
}
