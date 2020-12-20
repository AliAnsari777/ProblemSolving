import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
}
