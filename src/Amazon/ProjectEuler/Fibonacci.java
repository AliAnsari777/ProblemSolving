package Amazon.ProjectEuler;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(20));
        System.out.println(sumOfEvenNumberByFib(4000000));

        System.out.println();
        fib3((long) 80);
    }

    static int fib(int no){
        if(no == 0)
            return 0;
        if (no == 1 || no == 2)
            return 1;

        return fib(no - 2) + fib(no - 1);
    }

    // sum of all even fibonacci numbers
    static int sumOfEvenNumberByFib(int no){
        int previous = 0, next = 1, sum = 0, total = 0;

        while (previous < no) {
            if (previous%2 == 0)
                total += previous;

            sum = next + previous;
            previous = next;
            next = sum;
        }
        return total;
    }

    // Fibonacci without using loop calculate by math formula.
    static void fib3(Long no){
        Double gold1 = Math.pow( ( (1+Math.sqrt(5)) /2),no );
        Double gold2 = Math.pow( ( (1-Math.sqrt(5)) /2),no );
        long result = (long) ((long) (gold1 - gold2) / (Math.sqrt(5)));

        System.out.println(result);
    }
}
