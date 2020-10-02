package Amazon.ProjectEuler;

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

public class LargestPrimeFactor {
    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(600851475143L));
        System.out.println(isPrime(6857));
        System.out.println(isPrimeOptimized(6856));
    }

    static int largestPrimeFactor(long number){
        int i = 2;
        int largeNumber = 0;

        while (i < number/i + 1){
            if (number % i == 0){
                for (int j = 2; j <= i; j++) {
                    if(i % j == 0)
                        break;
                    else if(j == (i-1))
                        largeNumber = i;
                }
            }
            i++;
        }
        return largeNumber;
    }

    static boolean isPrime(int number){
        if (number < 2)
            return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static boolean isPrimeOptimized(int number){
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;

        if (number % 2 == 0 || number % 3 == 0)
            return false;

        for (int i = 5; i * i <= number ; i+=6) {
            if (number%i == 0 || number%(i+2) == 0)
                return false;
        }

        return true;
    }
}
