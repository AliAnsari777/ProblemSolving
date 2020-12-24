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
    void swap(int a, int b){
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
    HashSet subSetSum(int[] arr, int sum){
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
}
