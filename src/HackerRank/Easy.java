package HackerRank;

public class Easy {
    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                sb.append(i).append(" ");
            }
        }
        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("INVALID RANGE");
        }
    }

    static boolean isKaprekarNumber(int number) {

        if (number == 1){
            return true;
        }

        if (number > 8) {
            long square = (long) Math.pow(number, 2);
            String txtNumber = String.valueOf(square);

            long left = Integer.parseInt(txtNumber.substring(0, txtNumber.length() / 2));
            long right = Integer.parseInt(txtNumber.substring(txtNumber.length() / 2));

            return (left + right) == number;
        }

        return false;
    }
}
