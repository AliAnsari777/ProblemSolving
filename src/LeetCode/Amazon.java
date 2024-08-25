package LeetCode;

public class Amazon {
    public static void main(String[] args) {
        System.out.println("Min Swaps");
        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(minSwaps(data));

        //############################################################//
        System.out.println("=================================================");


    }

    // Given an array of 0s and 1s, find the minimum number of swaps required to make all 1s together, no matter where in the array
    // To solve this problem we used fixed sliding window
    public static int minSwaps(int[] data) {
        if(data.length <= 2)
            return 0;

        int numOnes = 0;
        int maxOnes = 0;
        int tempOnes = 0;

        for (int datum : data) {
            numOnes += datum;
        }

        for(int i = 0; i < data.length; i++) {
            tempOnes += data[i];
            if(i >= numOnes - 1) {
                if(i > numOnes - 1)
                    tempOnes -= data[i - numOnes];
                maxOnes = Math.max(maxOnes, tempOnes);
            }
        }

        return numOnes - maxOnes;
    }

    /*******************************************************************/


}
