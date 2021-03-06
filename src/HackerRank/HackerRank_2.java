package HackerRank;

import java.util.*;

public class HackerRank_2 {
    public static void main(String[] args) {

        System.out.println("\nP-Sequences: ");
        System.out.println(HackerRank_2.pSequences(2,2));
        //############################################################//

        System.out.println("\nCheck Magazine:");
        String[] magazing = {"two", "times", "three", "is", "not", "four", "two"};
        String[] note = {"two", "times", "two", "is", "four"};
        HackerRank_2.checkMagazine(magazing, note);

        //############################################################//

        System.out.println("\nTwo String:");
        System.out.println(HackerRank_2.twoStrings("hello", "world"));

    }

    //==========================================================================//


    // Hard question in array part
    // still not complete
    static int pSequences(int n, int p) {

        List<Integer> prime = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17));
        List<Integer> values = new ArrayList<>();
        int reminder;

        for(int i = 0; i<prime.size(); i++){
            if(p % prime.get(i) == 0)
                values.add(prime.get(i));

            reminder = p / prime.get(i);

            if (!(prime.contains(reminder)) && reminder != 0){
                values.add(reminder);
            }
        }


        return values.size();
    }

    /*******************************************************************/


    // In this problem we check all the value in note does exist in magazine or not
    // first I used array list which couldn't pass two test case because of time limit
    // then I used hash table which has constant time for searching value.
    static void checkMagazine(String[] magazine, String[] note) {

        Hashtable<String, Integer> magazineWords = new Hashtable<>();
        // initialize the hash table with magazine values and give them int value to keep track of words
        // that appear more than once
        for(String m : magazine){
            magazineWords.put(m,magazineWords.getOrDefault(m, 0)+1);
        }

        boolean flag = true;

        for (String n : note){
            if(!magazineWords.containsKey(n) || magazineWords.get(n) == 0) {
                System.out.println("No");
                flag = false;
                break;
            }else{
                magazineWords.replace(n, magazineWords.get(n)-1);
            }
        }

        if (flag)
            System.out.println("Yes");

    }

    /*******************************************************************/

    //Given two strings, determine if they share a common substring. A substring may be as small as one character.
    //For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.
    static String twoStrings(String s1, String s2) {
        Set<Character> chars = new HashSet<>();

        for(int i = 0; i < s1.length(); i++){
            chars.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if(chars.contains (s2.charAt(i)))
                return "YES";
        }
        return "NO";
    }

    /*******************************************************************/

    //Given two strings, determine if they share a common substring. A substring may be as small as one character.
    //For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.
    static String twoString(String s1, String s2) {
        Set<Character> chars = new HashSet<>();

        for(int i = 0; i < s1.length(); i++){
            chars.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if(chars.contains (s2.charAt(i)))
                return "YES";
        }
        return "NO";
    }
}
