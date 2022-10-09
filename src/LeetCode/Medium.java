package LeetCode;

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


}
