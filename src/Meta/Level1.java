package Meta;

import java.util.*;
import java.util.stream.Collectors;

public class Level1 {

    public static void main(String[] args) {
        System.out.println(Level1.minRemoveToMakeValid("le)e(t(c)o)d)e)"));
    }

    //==========================================================================//

    public int getMaximumEatenDishCount(int N, int[] D, int K) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < N; i++) {
            size = result.size();
            if(size >= K) {
                if(!result.subList(size-K, size).contains(D[i])) {
                    result.add(D[i]);
                }
            } else {
                result.add(D[i]);
            }
        }

        return result.size();
    }

    /*******************************************************************/

    public int getMaximumEatenDishCountWorking(int N, int[] D, int K) {
        // Write your code here
        Set<Integer> recent = new HashSet<>();
        Queue<Integer> memory = new LinkedList<>();

        int eaten = 0;

        for (int dish : D) {
            if (!recent.contains(dish)) {
                eaten++;

                memory.add(dish);
                recent.add(dish);

                if (memory.size() > K) {
                    int removed = memory.poll();
                    recent.remove(removed);
                }
            }
        }

        return eaten;
    }

    /*******************************************************************/

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> toRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toRemove.add(i);
                }
            }
        }

        toRemove.addAll(stack);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /*******************************************************************/


}
