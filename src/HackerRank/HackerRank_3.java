package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerRank_3 {
    public static void main(String[] args) {

//        List<Integer> roteated = Arrays.asList(1,2,3,4,5);
//        roteated = HackerRank_3.rotateLeft(2, roteated );
//        for (int a : roteated) {
//            System.out.println(a);
//        }

        //############################################################//

        String[] strings = {"lekgdisnsbfdzpqlkg", "eagemhdygyv", "jwvwwnrhuai", "urcadmrwlqe", "mpgqsvxrijpombyv", "mpgqsvxrijpombyv", "urcadmrwlqe", "mpgqsvxrijpombyv", "eagemhdygyv", "eagemhdygyv", "jwvwwnrhuai", "urcadmrwlqe", "jwvwwnrhuai", "kvugevicpsdf", "kvugevicpsdf", "mpgqsvxrijpombyv", "urcadmrwlqe", "mpgqsvxrijpombyv", "exdafbnobg", "qhootohpnfvbl", "suffrbmqgnln", "exdafbnobg", "exdafbnobg", "eagemhdygyv", "mpgqsvxrijpombyv", "urcadmrwlqe", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "exdafbnobg", "mpgqsvxrijpombyv", "kvugevicpsdf", "qhootohpnfvbl", "urcadmrwlqe", "kvugevicpsdf", "mpgqsvxrijpombyv", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "kvugevicpsdf", "qhootohpnfvbl", "lxyqetmgdbmh", "urcadmrwlqe", "urcadmrwlqe", "kvugevicpsdf", "lxyqetmgdbmh", "urcadmrwlqe", "lxyqetmgdbmh", "jwvwwnrhuai", "qhootohpnfvbl", "qhootohpnfvbl", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "kvugevicpsdf", "mpgqsvxrijpombyv", "exdafbnobg", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "qhootohpnfvbl", "exdafbnobg", "qhootohpnfvbl", "exdafbnobg", "mpgqsvxrijpombyv", "suffrbmqgnln", "mpgqsvxrijpombyv", "qhootohpnfvbl", "jwvwwnrhuai", "mpgqsvxrijpombyv", "qhootohpnfvbl", "lekgdisnsbfdzpqlkg", "eagemhdygyv", "jwvwwnrhuai", "kvugevicpsdf", "eagemhdygyv", "eagemhdygyv", "lxyqetmgdbmh", "qhootohpnfvbl", "lxyqetmgdbmh", "exdafbnobg", "qhootohpnfvbl", "qhootohpnfvbl", "exdafbnobg", "suffrbmqgnln", "mpgqsvxrijpombyv", "urcadmrwlqe", "eagemhdygyv", "lxyqetmgdbmh", "urcadmrwlqe", "suffrbmqgnln", "qhootohpnfvbl", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "lxyqetmgdbmh", "mpgqsvxrijpombyv", "jwvwwnrhuai", "lxyqetmgdbmh", "lxyqetmgdbmh", "lekgdisnsbfdzpqlkg", "qhootohpnfvbl"};
        String[] queries = {"exdafbnobg", "eagemhdygyv", "mpgqsvxrijpombyv", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "kvugevicpsdf", "exdafbnobg", "qhootohpnfvbl", "eagemhdygyv", "kvugevicpsdf", "suffrbmqgnln", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "jwvwwnrhuai", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "exdafbnobg", "suffrbmqgnln", "qhootohpnfvbl", "eagemhdygyv", "exdafbnobg", "suffrbmqgnln", "jwvwwnrhuai", "qhootohpnfvbl", "eagemhdygyv", "exdafbnobg", "exdafbnobg", "jwvwwnrhuai", "qhootohpnfvbl", "lxyqetmgdbmh", "qhootohpnfvbl", "suffrbmqgnln", "lxyqetmgdbmh", "qhootohpnfvbl", "eagemhdygyv", "jwvwwnrhuai", "eagemhdygyv", "qhootohpnfvbl", "mpgqsvxrijpombyv", "qhootohpnfvbl", "jwvwwnrhuai", "exdafbnobg", "eagemhdygyv", "eagemhdygyv", "kvugevicpsdf", "kvugevicpsdf", "jwvwwnrhuai", "urcadmrwlqe", "lxyqetmgdbmh", "qhootohpnfvbl", "exdafbnobg", "exdafbnobg", "eagemhdygyv", "qhootohpnfvbl", "exdafbnobg", "exdafbnobg", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "eagemhdygyv", "urcadmrwlqe", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "eagemhdygyv", "lekgdisnsbfdzpqlkg", "exdafbnobg", "kvugevicpsdf", "jwvwwnrhuai", "exdafbnobg", "lxyqetmgdbmh", "exdafbnobg", "lxyqetmgdbmh", "jwvwwnrhuai", "mpgqsvxrijpombyv", "eagemhdygyv", "urcadmrwlqe", "kvugevicpsdf", "qhootohpnfvbl", "jwvwwnrhuai", "eagemhdygyv", "urcadmrwlqe", "urcadmrwlqe", "exdafbnobg", "qhootohpnfvbl", "exdafbnobg", "eagemhdygyv", "exdafbnobg", "jwvwwnrhuai", "eagemhdygyv", "jwvwwnrhuai", "mpgqsvxrijpombyv", "urcadmrwlqe", "urcadmrwlqe", "eagemhdygyv", "eagemhdygyv", "jwvwwnrhuai", "suffrbmqgnln", "eagemhdygyv"};
        int[] result = new int[queries.length];
        result = HackerRank_3.matchingStrings(strings, queries);
        for (int a : result) {
            System.out.print(a + ", ");
        }
        //############################################################//
    }


    //==========================================================================//


    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int j = 0;
        for(int i = d; i < arr.size(); i++, j++){
            result.add(j, arr.get(i));
        }

        for(int i = 0; i < d; i++, j++){
            result.add(j, arr.get(i));
        }

        return result;
    }

    /*******************************************************************/

    static int[] matchingStrings(String[] strings, String[] queries) {
        List<String> values = new ArrayList<>(Arrays.asList(strings));
        List<String> query = new ArrayList<>(Arrays.asList(queries));
        int[] result = new int[query.size()];
        int index = 0;

        for (String val : query) {
            result[index] = Collections.frequency(values, val);
            index++;
        }

        return result;
    }

}
