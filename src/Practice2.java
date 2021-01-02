import java.util.*;

public class Practice2 {
    public static void main(String[] args) {

        int[] list = {3,5,1,1,3,4,2,1,5,3};
        System.out.println("\nFind a number which is in majority of array");
        System.out.println(average(list));

        //############################################################//

        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> two = new LinkedList<>();
        one.push(1);
        one.push(3);
        one.push(5);
        one.push(7);
        two.push(2);
        two.push(4);
        two.push(6);
        two.push(8);
        two.push(10);
        two.push(12);
        one.push(9);

        System.out.println("\nMerge and sort two linked list:");
        LinkedList<Integer> resul = Practice2.merge(two, one);
        for (int i : resul){
            System.out.print(i + ", ");
        }

        //############################################################//

        System.out.println("\n\nCheck two strings are anagram: ");
        System.out.println(Practice2.anagram("Ahmed", "Ahmed"));

        //############################################################//

        System.out.println("\nSwap two numbers without using third variable:");
        Practice2.swap(20, Integer.MAX_VALUE);

        //############################################################//

        System.out.println("\nSubset sum: ");
        int[] myNumberList = {3,5,1,1,3,4,2,1,5,3};
        HashSet result = Practice2.subSetSum(myNumberList, 7);
        System.out.println(result);

        //############################################################//

        System.out.println("\nFibonacci and dynamic Fibonacci");
        System.out.println(Practice2.fib(9));
        System.out.println(Practice2.dynamicFib(9));

        //############################################################//

        System.out.println("\nRemove duplicate letters: ");
        Practice2.removeDuplicate("abcdbca");

        //############################################################//

        System.out.println("\nRemove each every character: ");
        String str = "Flexton";
        System.out.println("Original String: " + str);
        System.out.println("New String is: \'"+ Practice2.NewString(str)+"\'");

        //############################################################//

        linkedList myList = new linkedList();
        myList = myList.insert(myList, 1);
        myList = myList.insert(myList, 2);
        myList = myList.insert(myList, 3);
        myList = myList.insert(myList, 4);
        myList = myList.insert(myList, 5);

        System.out.println("\nFind nth element from end of a single linked list: ");
        myList.printNthElementFromEnd(2);

        //############################################################//

        System.out.println("\nArmstrong Number:");
        System.out.println(Practice2.armstrongNumber(1634));

        //############################################################//

        System.out.println("\nIs Prime: ");
        System.out.println(Practice2.isPrime(107));

    }

    //==========================================================================//

    // find a number which is in majority of array
    static int average(int[] arr){
        HashMap<Integer, Integer> mylist = new HashMap<>();
        for (int value : arr) {
            if (mylist.containsKey(value)) {
                mylist.put(value, mylist.get(value) + 1);
            } else {
                mylist.put(value, 1);
            }
        }
        return Collections.max(mylist.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /*******************************************************************/

    // Merge two sorted linked list
    static LinkedList<Integer> merge(LinkedList<Integer> L1, LinkedList<Integer> L2){
        LinkedList<Integer> temp = new LinkedList<>();

        while (L1.peek() != null && L2.peek() != null){
            if(L1.peek() >= L2.peek()){
                temp.push(L1.pop());
            }
            else{
                temp.push(L2.pop());
            }
        }

        while (L1.peek() != null){
            temp.push(L1.pop());
        }

        while (L2.peek() != null){
            temp.push(L2.pop());
        }

        return temp;
    }

    /*******************************************************************/

    // checks if two Strings are Anagram or not
    static boolean anagram(String first, String second){
        if(first.length() != second.length()){
            return false;
        }

        HashMap<Integer, Character> test = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            test.put(i, first.charAt(i));
        }
        for(char a : second.toCharArray()){
            if(!(test.containsValue(a))){
                return false;
            }
        }
        return true;
    }

    /*******************************************************************/

    // swap two number without using third variable and checking overflow.
    static void swap(int a, int b){
        try{
            a = Math.addExact(a, b);
            b = Math.subtractExact(a, b);
            a = Math.subtractExact(a, b);
        }catch (Exception e){
            System.out.println("value overflowed");
        }
        System.out.println("First number: " + a + "  Second number: " + b);
    }

    /*******************************************************************/

    // to find all pairs of elements in an integer array, whose sum is equal to a given number
    static HashSet subSetSum(int[] arr, int sum){
        List<Integer> mylist = new ArrayList<Integer>();
        HashSet<String> result = new HashSet<String>();

        for(int i : arr){
            mylist.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if(mylist.contains(temp)){
                result.add("[" + arr[i] + "," + temp + "]");
            }
        }
        return result;
    }

    /*******************************************************************/

    // fibonacci
    static int fib(int k){
        if(k == 1 || k == 0){
            return k;
        }
        return fib(k-1) + fib(k - 2);
    }

    static int dynamicFib(int k){
        int[] result = new int[k+1];
        result[0] = 0;

        if (k > 0) {
            result[1] = 1;

            for (int i = 2; i <= k; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result[k];
    }

    /*******************************************************************/

    // remove duplicate from string
    static void removeDuplicate(String text){
        TreeSet<Character> set = new TreeSet<>();
        for(char a : text.toCharArray()){
            set.add(a);
        }
        System.out.println(set);
    }

    /*******************************************************************/

    // remove every each character
    static String NewString(String str)
    {
        if ((str==null)||(str.length() <= 1) )
            return str;
        return NewString(str.substring(0,str.length()-2)) + str.charAt(str.length()-1);
    }

    /*******************************************************************/

    // Find nth element from end of a single linked list
    static class linkedList{
        Node head;

        static class Node{
            int data;
            Node next;

            Node(int val){
                this.data = val;
                next = null;
            }
        }

        linkedList insert(linkedList list, int data){
            Node new_node = new Node(data);
            new_node.next = null;

            if(list.head == null){
                list.head = new_node;
            }else {
                Node last = list.head;
                while (last.next != null){
                    last = last.next;
                }
                last.next = new_node;
            }
            return list;
        }

        void printList(linkedList list){
            Node currentNode = list.head;
            while (currentNode != null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }

        void  printNthElementFromEnd(int n){
            Node temp = head;
            int len = 0;

            //find the size of list
            while (temp != null){
                temp = temp.next;
                len++;
            }

            if(len < n)
                return;

            temp = head;
            for (int i = 0; i < len - n; i++) {
                temp = temp.next;
            }

            System.out.println(temp.data);
        }
    }

    /*******************************************************************/

    // it check if we raise each digit in number to power of number of its digit and the result will be equal to
    // the original number like 153 = 1*1*1 + 5*5*5 + 3*3*3
    static boolean armstrongNumber(int num){
        ArrayList<Integer> list = new ArrayList<>();
        int temp = num;
        while (temp != 0){
            list.add(temp%10);
            temp /= 10;
        }

        int result = 0;
        for(int a : list){
            result += Math.pow(a, list.size());
        }
        if(result == num)
            return true;
        else
            return false;
    }

    /*******************************************************************/

    // check if the number is prime or not
    static boolean isPrime(int p){
        if(p%2 == 0)
            return false;

        for (int i = 3; i < Math.sqrt(p) ; i += 2) {
            if(p%i == 0)
                return false;
        }
        return true;
    }

    /*******************************************************************/

}
