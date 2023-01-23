package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Medium {
    public static void main(String[] args) {

        ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);

        System.out.println("Sum two linked list:");
        ListNode result = Medium.addTwoNumbers(one, two);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

        //############################################################//

        System.out.println("\nSum of two integers without using + and -");
        System.out.println(Medium.getSum(7, 17));

        //############################################################//

        System.out.println("\nStock Prices:");
        long[] prices = {-2,10,2,20,-7,3};
        System.out.println(price(prices));

    }


    //==========================================================================//


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode();
//        ListNode temp = result;
//
//        int reminder = 0, sum = 0;
//
//        while(l1 != null || l2 != null || reminder == 1) {
//            sum = 0;
//            if (l1 != null){
//                sum += l1.val;
//                l1 = l1.next;
//            }
//
//            if (l2 != null){
//                sum += l2.val;
//                l2 = l2.next;
//            }
//
//            sum += reminder;
//            reminder = sum/10;
//            ListNode node = new ListNode(sum%10);
//            // this way we will have the result in order
//            node.next = result;
//            result = node;
//
//        }
//
//        return result;

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int sum=0;
        int carry=0;
        while(l1!=null || l2!=null || carry==1){
            sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            // this way we will have the result in reverse which is what question asked
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    /*******************************************************************/

    // Given two integers a and b, return the sum of the two integers without using the operators + and -.
    public static int getSum(int a, int b) {
        return Integer.sum(a, b);
    }

    /*******************************************************************/

    public static long price(long[] prices){
        if (prices.length == 0){
            return 0;
        }

        List<Long> priceList = Arrays.stream(prices).boxed().collect(Collectors.toList());
        boolean lowChange = false, highChange = false;
        long low, high, diff = 0;
        low = prices[0];
        high = prices[0];

        for (long price : prices) {
            if (low > price) {
                low = price;
                lowChange = true;
            } else if (high < price) {
                high = price;
                highChange = true;
            }

            if ((lowChange || highChange) && (priceList.indexOf(low) < priceList.indexOf(high))) {
                long currentVal = high - low;
                if (diff < currentVal) {
                    diff = currentVal;
                    lowChange = false;
                    highChange = false;
                }
            }
        }

        return diff;
    }
}
