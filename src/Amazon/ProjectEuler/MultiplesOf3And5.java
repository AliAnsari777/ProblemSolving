package Amazon.ProjectEuler;

public class MultiplesOf3And5 {

    public static void main(String[] args) {
        System.out.println(multiplesOf3And5(1000));

        int result = (optimizedMultiples(3, 999) + optimizedMultiples(5, 999) - optimizedMultiples(15, 999));
        System.out.println(result);
    }

    static int multiplesOf3And5(int range){
        int sum = 0;
        for (int i = 0; i < range; i++) {
            if(i%3 == 0 || i%5 == 0){
                sum += i;
            }
        }
        return sum;
    }

    static int optimizedMultiples(int min, int max){
        int val = (int)Math.floor(max/min);
        return min * val * (val + 1) / 2;
    }
}
