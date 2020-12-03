import java.util.*;

public class Flexton {
    public static void main(String[] args) {

        Flexton obj = new Flexton();

        System.out.println("\nLongest Palindrome:");
        String res = obj.longestPalindrome("ugrecero");
        System.out.println(res);

        //############################################################//

        System.out.println("\nSum Two Numbers: ");
        int[] numbers = {2,4,3,1,5,9,0};
        int[] sum = obj.sumtwoNumber(numbers, 45);
        if(sum != null)
            System.out.println("Two number sum is: " + sum[0] + ", " + sum[1]);
        else
            System.out.println("No value pair");

        //############################################################//

        System.out.println("\nMerge Sort:");
        int[] numbersList = {2,4,3,1,5,9,0};
        obj.mergeSort(numbers, 0, numbersList.length-1);
        for(int a : numbers){
            System.out.print(a + ", ");
        }
        System.out.println();

        //############################################################//

//        System.out.println("\nCombination Sum: ");
//        List<List<Integer>> list;
//        list = obj.combinationSum(numbers, 8);
//        for(List<Integer> a : list){
//            a.forEach(System.out::print);
//            System.out.println();
//        }

        //############################################################//

        System.out.println("\nCustom Comparator Method: ");
        List<employee> emp = new ArrayList<>();
        emp.add(new employee("ali", 90000));
        emp.add(new employee("ahmed", 89000));
        emp.add(new employee("vali", 60000));
        emp.add(new employee("wahid", 70000));

        employee maxEmp = Collections.max(emp, new compEmp());
        System.out.println("max employee is " + maxEmp);

        //############################################################//

        System.out.println("\nRecursion Power Function:");
        System.out.println(obj.power(2, 5));

        //############################################################//

        System.out.println("\nReverse text:");
        String reverse = obj.reverseString("this is for test");
        System.out.println(reverse);

        //############################################################//

        System.out.println("\nDuplicate Characters:");
        obj.duplicateChars("my name is ali ansari");

        //############################################################//

        System.out.println("\n\nPalindrome Text and Number: ");
        obj.palindromeText("recer");
        obj.palindromeNumber(23432);

        //############################################################//

        System.out.println("\nRemove Duplicate: ");
        obj.removeDuplicate("My name is Ali Ansari");

        //############################################################//

        System.out.println("\nSecond Largest Number: ");
        int[] num = {2,4,3,1,5,9,0, 10, 12};
        obj.secondLargestNum(num);

        int[] zerOne = {1,1,0,0,1,0,1};
    }

    //==========================================================================//

    // 0.find the longest palindrome in a text
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // odd-numbered length ie "racecar" case
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    // Return the number of index from center that match on either side
    public int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*******************************************************************/

    // 1. find two numbers in an array that their sum is equal to the specific given value
    public int[] sumPair(int[] numbers, int k){
        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];
        int temp, value;

        for(int i : numbers)
            list.add(i);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            temp = iterator.next();
            iterator.remove();
            value = k - temp;

            if(list.contains(value)){
                result[0] = temp;
                result[1] = value;
                return result;
            }
        }
        return null;
    }

    // shorter method
    public int[] sumtwoNumber(int[] numbers, int t){
        List<Integer> values = new ArrayList<>();
        for (int num : numbers){
            if(values.contains(t - num)){
                return new int[] {num, t - num};
            }else {
                values.add(num);
            }
        }
        return null;
    }

    /*******************************************************************/

    // 2. merge sort with merge method
    public void mergeSort(int arr[], int left, int right){
        if(left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int arr[], int left, int mid, int right){
        int i = 0, j = 0, r = left;
        int[] leftArr = new int[mid - left +1];
        int[] rightArr = new int[right - mid];

        for (int k = 0; k < leftArr.length; k++) {
            leftArr[k] = arr[left+k];
        }
        for (int k = 0; k < rightArr.length; k++) {
            rightArr[k] = arr[mid + 1 + k];
        }

        while (i < leftArr.length && j < rightArr.length){
            if (leftArr[i] <= rightArr[j]){
                arr[r] = leftArr[i];
                i++;
            }else {
                arr[r] = rightArr[j];
                j++;
            }
            r++;
        }

        while (i < leftArr.length){
            arr[r] = leftArr[i];
            i++;
            r++;
        }

        while (j < rightArr.length){
            arr[r] = rightArr[j];
            j++;
            r++;
        }
    }

    /*******************************************************************/

    // 5. combination sum "still has problem"
    public List<List<Integer>> combinationSum(int[] num, int x){
        HashMap<Integer, Integer> set = new HashMap<>();
        List<Integer> values = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int temp = 0;

        for (int i = 0; i < num.length; i++) {
            set.put(num[i], num[i]);
        }

        if (set.containsKey(x)){
            values.add(set.get(x));
            result.add(values);
            set.remove(x);
        }

        for(int a : set.values()){
            values = new ArrayList<>();
            temp = x - a;
            if(set.containsKey(temp)){
                values.add(temp);
                values.add(a);
                result.add(values);
            }else{
                values.add(a);
                while (temp > 0){
                    temp -= a;
                    if(set.containsKey(temp)){
                        values.add(a);
                        values.add(temp);
                        break;
                    }
                    values.add(a);
                }
                if (temp > 0){
                    result.add(values);
                }
            }
        }

        return result;
    }

    /*******************************************************************/

    // 8. creating a custom comparator to compare employees by their salary
    static class employee{
        String name;
        Integer salary;

        public employee(String name, int salary){
            this.name = name;
            this.salary = salary;
        }

        public String toString(){
            return "Name: " + name + ", Salary: " + salary;
        }

        public String getName() {
            return name;
        }

        public Integer getSalary() {
            return salary;
        }
    }

    static class compEmp implements Comparator<employee> {
        @Override
        public int compare(employee o1, employee o2) {
            return o1.getSalary().compareTo(o2.getSalary());
        }
    }

    /*******************************************************************/

    // 11. power function with recursion with O(logn) time complexity
    int power(int x, int n){
        int sum;
        if(n == 0)
            return 1;
        sum = power(x, n/2);
        if(n%2 == 0)
            return sum * sum;
        else
            return x * sum * sum;

    }

    /*******************************************************************/

    // 12. Reversing a string text word by word.
    String reverseString(String txt){
        String[] temp = txt.split(" ");
        Stack<String> value = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(String s : temp)
            value.push(s);

        while (!value.empty())
            result.append(value.pop()).append(" ");

        return result.toString();
    }

    /*******************************************************************/

    // 13. Given string only letters, print out the duplicate characters in string ignore case
    void duplicateChars(String text){
        HashMap<Character, Integer> list = new HashMap<>();
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if(!(list.containsKey(text.charAt(i))) && text.charAt(i) != ' '){
                list.put(text.charAt(i), 1);
            }else if(text.charAt(i) != ' '){
                list.put(text.charAt(i), list.get(text.charAt(i)) + 1);
            }
        }

        // by using (Map.Entry) we can access to key and value of each element in hashMap
        for(Map.Entry<Character, Integer> a : list.entrySet()){
            if(a.getValue()>1){
                System.out.print(a.getKey() + ", ");
            }
        }
    }

    /*******************************************************************/

    // 14. check if text is palindrome it means we can read same from both side (Madam)
    void palindromeText(String text){
        int end = text.length()-1;
        boolean result = true;

        for (int i = 0; i < end; i++) {
            if(text.charAt(i) == text.charAt(end)) {
                end--;
            }else {
                result = false;
                break;
            }
        }

        if (result)
            System.out.println("text is palindrome");
        else
            System.out.println("text is not Palindrome ");
    }

    /*******************************************************************/

    // 15. check if the number is palindrome
    // for this I just reverse the number and compare it with original parameter
    void palindromeNumber(int number){
        int save = number, temp = 0;

        while (save != 0){
            temp = temp * 10 + (save%10);
            save /= 10;
        }

        if (temp == number)
            System.out.println("Number is palindrome");
        else
            System.out.println("Number is not palindrome");
    }

    /*******************************************************************/

    // 16. remove duplicate character from a string
    void removeDuplicate(String val){
        HashSet<Character> remove = new HashSet<>();
        for (int i = 0; i < val.length(); i++) {
            remove.add(val.charAt(i));
        }
        String result = remove.toString();
        System.out.println(result);
    }

    /*******************************************************************/

    // 17. find the second largest number in an array.
    void secondLargestNum(int[] numbers){
        if(numbers.length < 2)
            System.out.println("small array of numbers.");

        int first = 0, second = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > first){
                second = first;
                first = numbers[i];
            }else if( numbers[i] >= second && numbers[i] != first){
                second = numbers[i];
            }
        }

        if (second == 0)
            System.out.println("no second largest number");
        else
            System.out.println(second);
    }
}
