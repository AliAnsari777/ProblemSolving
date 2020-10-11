import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        int[] val = {3, 5, 6, 7, 2, 3, 4, 5, 1, 3, 6, 1};
        List<Integer> result = findDuplicateNumbers(val);
        System.out.println(result.toString());
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
}
