package JobInterviews;

import java.util.*;

public class Interview_1 {

    public static void main(String[] args) {
        // Pangram
        System.out.println("Pangram String: " + Interview_1.pangram("abcdefghijklmnopqrstuvwxyz"));

        //############################################################//

        // Blanagrams
        System.out.println("check Blanagrams: " + Interview_1.checkBlanagrams("alex", "flex"));

        //############################################################//

        // Average
        int[] average = {2, 5, 3, 2, 6, 8, 6, 2};
        System.out.println("Majority number in array: " + Interview_1.average(average));

        //############################################################//

        // K frequent element in array
        int[] numbers = {3, 3, 3, 5, 5, 7, 7, 7, 7};
        System.out.println("K frequent element in array");
        Interview_1.kFrequentElement(numbers, 1);

        //############################################################//

        // Unique Number Collection
        int[] uniqueNumbers = {1, 2, 2, 3, 5, 5, 7, 7, 7, 7};
        System.out.println("Unique Number Collection: ");
        HashMap res = Interview_1.uniqueNumberCollection(uniqueNumbers);
        for (Object a : res.entrySet()) {
            System.out.println(a);
        }

        //############################################################//

        // Sorting Hash Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, "Hemendra");
        map.put(99, "Andrew");
        map.put(103, "Anish");
        map.put(18, "Mohan");
        map.put(11, "Christine");
        map.put(109, "Rebeca");
        map.put(111, "David");
        map.put(19, "Rahim");
        map.put(10, "Krishna");
        System.out.println("Sort Hash Map: ");
        Interview_1.sortHashMap(map);

        //############################################################//

        // Group Anagram
        String[] text = {"hello", "olleh", "ali", "lia", "ial"};
        System.out.println("\nGroup Anagram: ");
        List<List<String>> group = Interview_1.groupAnagram(text);
        for (List l : group) {
            System.out.println(l);
        }

        //############################################################//

        // Find Pattern
        String txt = "ABCEABCDABCEABCD";
        String pat = "ABCD";
        System.out.println("Find Pattern: ");
        Interview_1.findPattern(txt, pat);

        //############################################################//

        // Replace word
        String SampleText = "GeeksforGeeks is a computer science portal for geeks. People who love computer and computer " +
                "codes can contribute their valuables/ideas on computer codes/structures on here.";
        String word = "computer";
        System.out.println("Replace word with Star: ");
        Interview_1.replaceWord(SampleText, word);

        //############################################################//

        String value = "abc";
        List<List> result = Interview_1.subSet(value);
        System.out.println("\nSub Sets of " + value + ": ");
        for (List o : result) {
            System.out.println(o);
        }

        //############################################################//

        char[] per = {'a', 'b', 'c'};
        System.out.println("Permutations: ");
        Interview_1.permutations(per, per.length, per.length);

        //############################################################//

        String sample = "abcd";
        System.out.println("String Permute: ");
        Interview_1.stringPermute(sample, 0, sample.length() - 1);
    }

//==========================================================================//

    // this method check that text in parameter has all the alphabet or not.
    static boolean pangram(String text) {
        HashMap<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alpha.put((char) (97 + i), 0);
        }

        String temp = text.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            if (alpha.containsKey(temp.charAt(i))) {
                alpha.put(temp.charAt(i), 1);
            }
        }

        if (alpha.containsValue(0)) {
            return false;
        }
        return true;
    }

    /*******************************************************************/

    // this method will check if two given string different only in one character
    // for example if we give "abc" and "dac" as input result will be true because they different only in one letter.
    static boolean checkBlanagrams(String word1, String word2) {
        List<Character> temp = new ArrayList<>();
        char[] one = word1.toCharArray();
        char[] two = word2.toCharArray();
        int count = 0;
        Arrays.sort(one);
        Arrays.sort(two);

        String first = new String(one);
        String second = new String(two);

        if (first.equals(second))
            return false;

        if (one.length != two.length)
            return false;

        for (char c : one) {
            temp.add(c);
        }

        for (int i = 0; i < two.length; i++) {
            if (temp.contains(two[i]))
                temp.remove((Object) two[i]);
        }


        if (temp.size() == 1)
            return true;
        else
            return false;

    }

    /*******************************************************************/

    // find a number which is in majority of array
    static int average(int[] arr) {
        HashMap<Integer, Integer> mylist = new HashMap<>();
        for (int value : arr) {
            if (mylist.containsKey(value)) {
                mylist.put(value, mylist.get(value) + 1);
            } else {
                mylist.put(value, 1);
            }
        }
        return Collections.max(mylist.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /*******************************************************************/

    // show K frequent element in an array
    // this method show K number of elements in array according to how much they repeated in array.
    static void kFrequentElement(int[] list, int k) {
        class ValueComparator implements Comparator<Integer> {
            Map<Integer, Integer> base;

            public ValueComparator(Map<Integer, Integer> base) {
                this.base = base;
            }

            // Note: this comparator imposes orderings that are inconsistent with
            // equals.
            public int compare(Integer a, Integer b) {
                if (base.get(a) >= base.get(b)) {
                    return -1;
                } else {
                    return 1;
                } // returning 0 would merge keys
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ValueComparator comparator = new ValueComparator(map);
        TreeMap<Integer, Integer> result = new TreeMap<>(comparator);

        for (int i = 0; i < list.length; i++) {
            if (!(map.containsKey(list[i]))) {
                map.put(list[i], 1);
            } else {
                map.put(list[i], map.get(list[i]) + 1);
            }
        }

        result.putAll(map);

        for (int i = 0; i < k; i++) {
            System.out.println(result.firstKey());
            result.pollFirstEntry();
        }
    }

    /*******************************************************************/

    // this method will count number of digits in an array and save number with its repeated count in a hasmap
    public static HashMap uniqueNumberCollection(int[] numbers) {
        if (numbers == null)
            return null;

        if (numbers.length == 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            if (!(map.containsKey(number))) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        return map;
    }

    /*******************************************************************/

    // this method will sort a hash map by value by implementing compare class and overriding compare method
    public static void sortHashMap(HashMap<Integer, String> map) {

        class compare implements Comparator<Integer> {
            HashMap<Integer, String> temp;

            public compare(HashMap<Integer, String> map) {
                temp = map;
            }

            public int compare(Integer o1, Integer o2) {
                return temp.get(o1).compareTo(temp.get(o2));
            }
        }

        TreeMap<Integer, String> sortedByKey = new TreeMap<>(map);
        System.out.println("Sorted by key: ");
        for (Object obj : sortedByKey.entrySet()) {
            System.out.print(obj + ",  ");
        }


        compare myComparator = new compare(map);
        TreeMap<Integer, String> sortedByValue = new TreeMap<>(myComparator);
        sortedByValue.putAll(map);
        System.out.println("\nSorted by value: ");
        for (Object obj : sortedByValue.entrySet()) {
            System.out.print(obj + ",  ");
        }
    }

    /*******************************************************************/

    // this method will accept an array of strings and group all anagram words, those have same letters
    // but in different order.
    public static List<List<String>> groupAnagram(String[] text) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < text.length; i++) {
            char[] temp = text[i].toCharArray();
            Arrays.sort(temp);
            String vale = new String(temp);

            if (!(map.containsKey(vale))) {
                List<String> list = new ArrayList<>();
                list.add(text[i]);
                map.put(vale, list);
            } else {
                map.get(vale).add(text[i]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    /*******************************************************************/

    //
    public static void findPattern(String text, String pat) {
        int t = text.length();
        int p = pat.length();
        int i = 0;

        while (i <= t - p) {
            int j;

            for (j = 0; j < p; j++) {
                if (text.charAt(i + j) != pat.charAt(j))
                    break;
            }

            if (j == p) {
                System.out.println(i);
                i += p;
            } else if (j == 0)
                i++;
            else
                i += j;
        }
    }

    /*******************************************************************/

    // This method will receive a text and a word and find that word inside the text and replace it with stars
    public static void replaceWord(String text, String word) {
        int w = word.length();
        String star = "";

        for (int i = 0; i < w; i++) {
            star += "*";
        }

        String[] split;
        split = text.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(word)) {
                split[i] = star;
            }
            System.out.print(split[i] + " ");
        }
    }

    /*******************************************************************/

    public static List<List> subSet(String text) {
        List<List> result = new ArrayList<>();
        List set = new ArrayList();
        result.add(set);

        char[] list = text.toCharArray();
        char val;
        for (int i = 0; i < list.length; i++) {
            val = list[i];
            List moreSet = new ArrayList();
            for (List l : result) {
                List temp = new ArrayList();
                temp.addAll(l);
                temp.add(val);
                moreSet.add(temp);
            }
            result.addAll(moreSet);
        }
        return result;
    }

    /*******************************************************************/

    public static void permutations(char[] value, int size, int n) {
        if (size == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(value[i]);
            }
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            permutations(value, size - 1, n);

            if (size % 2 == 1) {
                char temp = value[0];
                value[0] = value[size - 1];
                value[size - 1] = temp;
            } else {
                char temp = value[i];
                value[i] = value[size - 1];
                value[size - 1] = temp;
            }
        }
    }

    /*******************************************************************/

    public static void stringPermute(String text, int start, int end) {
        if (start == end)
            System.out.println(text);
        else {
            for (int i = start; i < end; i++) {
                text = swap(text, start, i);
                stringPermute(text, start + 1, end);
            }
        }
    }
    public static String swap(String s, int a, int b){
        char temp;
        char[] list = s.toCharArray();
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
        return String.valueOf(list);
    }
}
