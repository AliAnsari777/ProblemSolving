public class Hackerrank {

    public static void main(String[] args) {
        int[] simpleArray = {7,5,3,8,4,2,1};
        System.out.println(Hackerrank.simpleArraySum(simpleArray));

        //############################################################//


    }

//==========================================================================//

    // This is "Simple Array Sum" problem
    // This method sum all the elements of an array and return on integer value.
    static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int value : ar) {
            sum += value;
        }
        return sum;
    }

    /*******************************************************************/


}
