package Skillz;

/**
 * Fill in the following template so that method second()
 * blocks until isSatisfied() returns true.
 * You can modify any or all of the contents of the three
 * methods as needed, but not the method signatures.
 * The solution should be as efficient as possible,
 * that is, a poll/sleep solution is not very efficient.
 */

public class ThreadTest {
    private boolean satisfied = false;

    public void first() {
        System.out.println("This is first");
        satisfied = true;
    }

    public void second() {
        System.out.println("This is Second");
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public static void main(final String[] args) {
        final ThreadTest b = new ThreadTest();

        (new Thread(new Runnable() {
            public void run() {
                b.second();
            }
        })).start();


        (new Thread(new Runnable() {
            public void run() {
                b.first();
            }
        })).start();
    }

}
