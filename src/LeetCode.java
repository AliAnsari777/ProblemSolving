import java.util.ArrayList;

public class LeetCode {
    public static void main(String[] args) {

        // Single Number
        int[] singleNumber = {1, 5, 4, 7, 5, 4, 1, 7, 2};
        System.out.println("Single Number: " + LeetCode.singleNumber(singleNumber));

        //############################################################//

    }

//==========================================================================//

    // Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    static int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove((Integer) nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    /*******************************************************************/


}
