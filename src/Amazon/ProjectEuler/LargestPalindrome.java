package Amazon.ProjectEuler;

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of
two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class LargestPalindrome {
    public static void main(String[] args) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int[] result = palindrome();
        endTime = System.nanoTime() - startTime;
        System.out.println(endTime);
        for(int i : result)
            System.out.println(i + " ");

    }

    static int[] palindrome(){
       int one, two=0, result=0;
        for (one = 999; one >= 100; one--) {
            for (two = 999; two >= one - 100; two--){
                result = two * one;
                if(palindromeNumber(result))
                    return new int[]{one, two};
            }
        }

        return new int[]{};
    }

    static boolean palindromeNumber(int number){
        int save = number, temp = 0;

        while (save != 0){
            temp = temp * 10 + (save%10);
            save /= 10;
        }

        if (temp == number)
            return true;
        else
            return false;
    }
}
