import java.util.*;

public class Practice {
    public static void main(String[] args) {
//        int[] val = {3, 5, 6, 7, 2, 3, 4, 5, 1, 3, 6, 1};
//        List<Integer> result = findDuplicateNumbers(val);
//        System.out.println(result.toString());
        List test = new ArrayList(Arrays.asList(4,4,9,2,3));
        System.out.println(Practice.calculateAmount(test));

    }

    static List<Integer> findDuplicateNumbers(int[] num){
        Map<Integer, Integer> values = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            if (!values.containsKey(num[i])) {
                values.put(num[i], 1);
            }else{
                values.replace(num[i], 2);
            }
        }

        for(Map.Entry<Integer, Integer> val : values.entrySet()){
            if (val.getValue() > 1)
                result.add(val.getKey());
        }

        return result;
    }

    // After first value we subtract next value with the minimum value before it
    // it means after second value we subtract that value with them minimum value before it and if the
    // result of subtraction is less then zero we consider it as zero and at end we sum new values
    public static long calculateAmount(List<Integer> prices) {

        List<Integer> discount = new ArrayList<>();
        int temp = 0;
        int min = prices.get(0);
        long total = 0;
        discount.add(min);
        for(int i = 1; i < prices.size(); i++){
            temp  = Math.max(prices.get(i) - min, 0);
            if(min > prices.get(i))
                min = prices.get(i);

            discount.add(temp);
        }

        for(int a : discount){
            total += a;
        }
        return total;
    }
}
