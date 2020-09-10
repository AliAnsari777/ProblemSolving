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
        int[] average = {2,5,3,2,6,8,6,2};
        System.out.println("Majority number in array: " + Interview_1.average(average));

    }

//==========================================================================//

    // this method check that text in parameter has all the alphabet or not.
    static boolean pangram(String text){
        HashMap<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < 26 ; i++) {
            alpha.put( (char) (97 + i), 0);
        }

        String temp = text.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            if(alpha.containsKey(temp.charAt(i))){
                alpha.put(temp.charAt(i), 1);
            }
        }

        if (alpha.containsValue(0)){
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

        if(first.equals(second))
            return false;

        if(one.length != two.length)
            return false;

        for (char c : one) {
            temp.add(c);
        }

        for(int i = 0; i < two.length; i++){
            if(temp.contains(two[i]))
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
}

