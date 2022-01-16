package HackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class HackerRank_3 {
    public static void main(String[] args) {

//        List<Integer> roteated = Arrays.asList(1,2,3,4,5);
//        roteated = HackerRank_3.rotateLeft(2, roteated );
//        for (int a : roteated) {
//            System.out.println(a);
//        }

        //############################################################//

//        String[] strings = {"lekgdisnsbfdzpqlkg", "eagemhdygyv", "jwvwwnrhuai", "urcadmrwlqe", "mpgqsvxrijpombyv", "mpgqsvxrijpombyv", "urcadmrwlqe", "mpgqsvxrijpombyv", "eagemhdygyv", "eagemhdygyv", "jwvwwnrhuai", "urcadmrwlqe", "jwvwwnrhuai", "kvugevicpsdf", "kvugevicpsdf", "mpgqsvxrijpombyv", "urcadmrwlqe", "mpgqsvxrijpombyv", "exdafbnobg", "qhootohpnfvbl", "suffrbmqgnln", "exdafbnobg", "exdafbnobg", "eagemhdygyv", "mpgqsvxrijpombyv", "urcadmrwlqe", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "exdafbnobg", "mpgqsvxrijpombyv", "kvugevicpsdf", "qhootohpnfvbl", "urcadmrwlqe", "kvugevicpsdf", "mpgqsvxrijpombyv", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "kvugevicpsdf", "qhootohpnfvbl", "lxyqetmgdbmh", "urcadmrwlqe", "urcadmrwlqe", "kvugevicpsdf", "lxyqetmgdbmh", "urcadmrwlqe", "lxyqetmgdbmh", "jwvwwnrhuai", "qhootohpnfvbl", "qhootohpnfvbl", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "kvugevicpsdf", "mpgqsvxrijpombyv", "exdafbnobg", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "qhootohpnfvbl", "exdafbnobg", "qhootohpnfvbl", "exdafbnobg", "mpgqsvxrijpombyv", "suffrbmqgnln", "mpgqsvxrijpombyv", "qhootohpnfvbl", "jwvwwnrhuai", "mpgqsvxrijpombyv", "qhootohpnfvbl", "lekgdisnsbfdzpqlkg", "eagemhdygyv", "jwvwwnrhuai", "kvugevicpsdf", "eagemhdygyv", "eagemhdygyv", "lxyqetmgdbmh", "qhootohpnfvbl", "lxyqetmgdbmh", "exdafbnobg", "qhootohpnfvbl", "qhootohpnfvbl", "exdafbnobg", "suffrbmqgnln", "mpgqsvxrijpombyv", "urcadmrwlqe", "eagemhdygyv", "lxyqetmgdbmh", "urcadmrwlqe", "suffrbmqgnln", "qhootohpnfvbl", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "lxyqetmgdbmh", "mpgqsvxrijpombyv", "jwvwwnrhuai", "lxyqetmgdbmh", "lxyqetmgdbmh", "lekgdisnsbfdzpqlkg", "qhootohpnfvbl"};
//        String[] queries = {"exdafbnobg", "eagemhdygyv", "mpgqsvxrijpombyv", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "kvugevicpsdf", "exdafbnobg", "qhootohpnfvbl", "eagemhdygyv", "kvugevicpsdf", "suffrbmqgnln", "jwvwwnrhuai", "lekgdisnsbfdzpqlkg", "lekgdisnsbfdzpqlkg", "mpgqsvxrijpombyv", "jwvwwnrhuai", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "exdafbnobg", "suffrbmqgnln", "qhootohpnfvbl", "eagemhdygyv", "exdafbnobg", "suffrbmqgnln", "jwvwwnrhuai", "qhootohpnfvbl", "eagemhdygyv", "exdafbnobg", "exdafbnobg", "jwvwwnrhuai", "qhootohpnfvbl", "lxyqetmgdbmh", "qhootohpnfvbl", "suffrbmqgnln", "lxyqetmgdbmh", "qhootohpnfvbl", "eagemhdygyv", "jwvwwnrhuai", "eagemhdygyv", "qhootohpnfvbl", "mpgqsvxrijpombyv", "qhootohpnfvbl", "jwvwwnrhuai", "exdafbnobg", "eagemhdygyv", "eagemhdygyv", "kvugevicpsdf", "kvugevicpsdf", "jwvwwnrhuai", "urcadmrwlqe", "lxyqetmgdbmh", "qhootohpnfvbl", "exdafbnobg", "exdafbnobg", "eagemhdygyv", "qhootohpnfvbl", "exdafbnobg", "exdafbnobg", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "eagemhdygyv", "urcadmrwlqe", "kvugevicpsdf", "lekgdisnsbfdzpqlkg", "jwvwwnrhuai", "eagemhdygyv", "lekgdisnsbfdzpqlkg", "exdafbnobg", "kvugevicpsdf", "jwvwwnrhuai", "exdafbnobg", "lxyqetmgdbmh", "exdafbnobg", "lxyqetmgdbmh", "jwvwwnrhuai", "mpgqsvxrijpombyv", "eagemhdygyv", "urcadmrwlqe", "kvugevicpsdf", "qhootohpnfvbl", "jwvwwnrhuai", "eagemhdygyv", "urcadmrwlqe", "urcadmrwlqe", "exdafbnobg", "qhootohpnfvbl", "exdafbnobg", "eagemhdygyv", "exdafbnobg", "jwvwwnrhuai", "eagemhdygyv", "jwvwwnrhuai", "mpgqsvxrijpombyv", "urcadmrwlqe", "urcadmrwlqe", "eagemhdygyv", "eagemhdygyv", "jwvwwnrhuai", "suffrbmqgnln", "eagemhdygyv"};
//        int[] result = new int[queries.length];
//        result = HackerRank_3.matchingStrings(strings, queries);
//        for (int a : result) {
//            System.out.print(a + ", ");
//        }
        //############################################################//

//        int[][] numbers = {{1,2,100}, {2,5, 100}, {3,4,100}};
//        System.out.println(HackerRank_3.arrayManipulation(5, numbers));

        //############################################################//

//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(Arrays.asList(1,0,5));
//        queries.add(Arrays.asList(1,1,7));
//        queries.add(Arrays.asList(1,0,3));
//        queries.add(Arrays.asList(2,1,0));
//        queries.add(Arrays.asList(2,1,1));
//        HackerRank_3.dynamicArray(2, queries);

        //############################################################//

//        System.out.println(HackerRank_3.downToZero(10));

        //############################################################//

//        int[] keyboards = {5};
//        int[] drives = {4};
//        System.out.println(HackerRank_3.getMoneySpent(keyboards,drives, 5));

        //############################################################//

//        System.out.println(HackerRank_3.catAndMouse(1,3,2));

        //############################################################//

//        List<List<Integer>> numbers = new ArrayList<>();
//        numbers.add(Arrays.asList(5,3,4));
//        numbers.add(Arrays.asList(1,5,8));
//        numbers.add(Arrays.asList(6,4,2));
//        System.out.println(HackerRank_3.formingMagicSquare(numbers));

        //############################################################//

//        List<Integer> array =  Arrays.asList(1,2,2,3,1,2);
//        System.out.println(HackerRank_3.pickingNumbers(array));

        //############################################################//

//        List<Integer> ranked =  Arrays.asList(100, 100, 50, 40, 40, 20, 10);
//        List<Integer> player =  Arrays.asList(5, 25, 50, 120);
//        System.out.println("Climbing Leaderboard");
//        System.out.println(HackerRank_3.climbingLeaderboard(ranked, player));

        //############################################################//

//        System.out.println("Hurdle Race:");
//        List<Integer> hurdles =  Arrays.asList(5, 8, 3, 7);
//        System.out.println(HackerRank_3.hurdleRace(9, hurdles));

        //############################################################//

//        System.out.println("Designer PDF Viewer:");
//        List<Integer> heights = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
//        String word = "zaba";
//        System.out.println(HackerRank_3.designerPdfViewer(heights, word));

        //############################################################//

//        System.out.println("Utopian Tree");
//        System.out.println(HackerRank_3.utopianTree(5));

        //############################################################//

//        System.out.println("Non Divisible Subset:");
//        System.out.println(HackerRank_3.nonDivisibleSubset());

        //############################################################//

//        System.out.println("Non Divisible Subset:");
//        List<Integer> divisibleArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(HackerRank_3.nonDivisibleSubset(4, divisibleArray));

        //############################################################//

//        System.out.println("Divisible Sum Pairs: ");
//        List<Integer> divisibleNumbers = Arrays.asList(1, 3, 2, 6, 1, 2);
//        System.out.println(HackerRank_3.divisibleSumPairs(6, 3, divisibleNumbers));

        //############################################################//

        System.out.println("Migratory Birds:");
        List<Integer> birdsType = Arrays.asList(
                3,1,1,2,4,1,1,2,1,4,1,2,4,2,2,2,5,1,3,1,2,2,1,1,2,4,2,2,2,2,1,1,2,5,2,1,1,1,2,1,2,1,3,1,1,2,1,5,1,4,1,1,1,3,5,2,1,1,4,2,4,2,2,2,1,1,3,2,2,1,3,5,4,2,2,4,4,5,2,2,2,3,1,2,1,2,3,2,2,1,1,2,5,2,2,1,1,1,2,1,1,1,1,2,1,2,1,2,2,5,1,4,1,2,2,2,2,1,1,2,2,2,3,2,2,2,2,2,2,2,3,1,1,5,2,1,2,1,2,4,2,2,1,2,1,2,1,2,2,1,2,1,2,4,2,5,2,4,4,2,4,1,1,2,2,2,2,4,1,5,2,2,1,1,1,2,1,1,2,2,1,4,1,2,1,4,1,4,2,1,4,2,1,1,1,4,3,2,2,2,2,2,2,1,2,2,2,2,4,1,2,2,1,2,1,4,3,4,2,4,1,2,1,3,2,2,5,2,1,1,1,2,2,1,4,1,1,2,1,5,4,2,1,2,1,1,2,1,2,2,1,5,2,4,1,2,2,1,2,2,1,2,1,2,2,3,2,1,2,1,2,1,1,4,1,2,2,4,2,2,1,1,1,1,2,4,1,2,1,3,1,2,2,1,2,5,1,1,2,2,2,1,1,1,1,1,4,2,1,2,2,1,2,1,4,1,2,2,1,2,2,2,2,2,2,4,2,1,5,1,2,3,2,4,2,1,1,2,1,1,2,1,3,1,2,2,2,2,2,4,3,1,2,1,3,2,4,2,4,4,1,2,5,3,1,4,1,2,2,1,2,2,4,1,2,3,1,1,1,3,1,5,1,2,2,1,2,2,1,1,1,1,1,4,2,3,3,2,2,1,2,1,2,1,1,4,5,2,2,2,2,2,1,2,1,1,5,2,4,1,1,1,1,2,2,2,2,3,2,2,1,5,5,2,5,2,2,2,1,1,2,1,4,2,4,2,1,1,2,2,1,4,2,4,2,1,2,1,1,1,2,4,2,2,3,1,1,2,2,1,2,2,1,1,2,2,1,1,1,2,4,1,1,1,1,1,5,2,1,5,1,2,4,2,2,1,2,1,1,4,1,2,1,1,1,1,2,1,1,1,2,1,1,2,4,1,2,4,2,2,1,2,2,4,2,1,2,1,1,1,2,2,1,2,1,2,2,1,2,2,2,2,1,2,4,2,4,4,3,2,1,2,1,1,1,2,4,1,1,1,2,1,5,4,2,1,1,2,1,2,5,1,1,4,4,2,1,1,2,2,1,2,1,1,1,2,1,2,2,1,1,2,1,2,1,4,1,4,1,1,4,1,3,2,2,2,2,4,5,2,2,1,2,1,1,2,1,1,1,2,2,4,5,2,5,2,2,1,1,1,2,1,5,1,2,1,1,4,1,2,1,5,2,1,2,4,2,4,1,2,1,1,2,1,2,2,5,1,1,1,4,2,2,2,1,1,4,5,2,4,1,2,2,2,2,2,2,2,1,2,2,2,2,1,2,1,4,2,1,4,1,2,3,1,1,2,1,2,1,1,1,2,1,1,1,2,1,2,2,5,5,2,4,2,4,1,2,5,2,4,1,1,1,2,2,1,4,5,5,2,2,1,4,4,4,1,4,2,5,2,2,1,1,1,2,1,2,1,4,4,4,2,1,3,2,5,1,1,2,2,2,1,1,5,2,4,2,2,4,3,1,1,2,2,2,2,1,2,5,1,1,1,3,2,2,1,5,2,1,2,2,1,2,4,1,1,4,2,4,2,4,1,2,2,1,5,1,2,1,1,2,2,1,1,2,4,1,1,4,5,2,1,2,4,4,2,2,2,1,1,1,4,1,2,2,4,1,2,5,2,3,1,1,1,2,1,2,1,4,2,2,5,1,1,2,2,4,2,3,2,1,3,1,1,1,4,2,1,2,2,1,1,4,5,2,1,1,2,3,4,2,2,2,4,1,1,5,1,2,1,2,1,2,1,2,1,1,4,2,4,2,2,3,5,5,2,5,5,1,3,4,2,3,1,4,2,1,1,2,1,2,4,1,1,1,1,1,1,2,4,2,1,4,5,1,1,1,1,2,1,1,1,4,1,4,1,2,4,1,1,1,5,3,2,4,4,2,1,1,2,4,1,1,4,2,4,1,1,5,1,1,1,1,2,2,2,4,1,2,1,2,2,2,2,4,2,2,1,1,1,1,1,4,5,1,2,2,4,2,1,2,2,2,4,2,4,2,2,1,1,5,2,5,4,1,1,2,2,1,2,1,2,2,1,2,1,2,2,1,2,1,4,1,2,2,2,2,2,2,2,5,1,2,1,2,1,1,1,2,1,2,2,5,2,2,2,1,1,2,4,2,2,1,1,1,2,2,2,1,4,1,1,2,1,4,1,1,2,2,4,1,4,2,2,2,1,3,1,2,2,4,2,1,1,2,2,1,1,2,1,2,1,1,2,1,2,4,1,1,4,3,4,2,2,1,4,1,4,1,1,5,1,1,1,2,5,5,2,2,2,4,4,4,1,4,5,1,2,3,2,2,2,1,1,2,2,2,1,2,2,1,2,2,1,5,1,2,1,1,2,2,1,4,5,1,1,2,1,2,2,1,2,2,1,2,1,2,1,1,2,4,4,1,2,4,2,4,4,1,1,1,1,2,5,1,2,4,4,2,1,4,1,1,1,2,1,1,1,2,5,2,2,1,1,5,2,4,3,2,1,1,4,2,2,1,5,5,2,3,2,1,2,1,5,4,1,2,4,1,4,1,1,2,2,2,1,5,1,1,1,5,1,1,5,1,1,1,1,2,4,2,2,1,1,1,2,1,2,1,2,2,1,1,4,5,2,4,2,2,1,1,2,4,2,2,1,1,2,4,1,1,1,1,2,2,2,4,2,2,2,4,4,1,1,5,2,4,2,1,4,1,1,2,2,2,2,1,1,1,2,1,1,2,2,1,1,1,2,1,1,2,5,1,5,2,2,1,1,2,4,2,2,2,2,2,1,4,1,1,2,4,2,2,1,2,1,1,2,5,2,2,2,2,4,1,2,2,3,2,2,1,3,4,2,3,4,2,1,2,2,1,1,2,1,3,2,1,2,2,2,1,2,2,5,1,1,4,1,2,2,5,5,2,2,1,1,2,1,2,4,2,1,4,1,1,2,1,1,4,2,2,4,1,5,4,1,1,1,1,1,2,1,1,2,5,2,1,4,1,1,1,2,1,5,5,2,1,2,1,5,1,4,2,2,4,1,2,2,2,1,1,2,1,2,5,1,1,4,2,2,4,4,1,1,2,1,2,4,2,3,1,2,1,1,1,1,2,2,1,2,4,1,1,4,4,1,1,4,5,2,1,1,1,2,2,4,2,2,2,1,1,1,2,2,4,1,1,2,1,2,2,1,2,2,4,2,2,3,2,1,4,1,1,3,1,1,5,1,5,1,4,2,1,2,2,2,1,2,1,2,3,2,1,4,2,1,1,5,1,4,3,2,1,1,1,4,1,1,4,1,1,4,4,2,1,2,1,2,1,1,1,2,2,1,1,2,1,2,2,1,4,2,2,2,1,2,2,2,2,1,2,2,4,1,1,2,2,5,2,3,1,1,1,1,5,2,2,4,2,4,2,3,1,1,2,1,1,4,2,1,2,2,2,2,1,1,1,2,1,1,1,1,2,3,1,2,2,4,1,4,2,5,2,3,1,1,4,2,4,4,2,1,1,1,2,2,1,5,1,4,1,2,2,1,4,3,1,1,3,1,2,3,1,2,2,2,2,2,5,1,2,1,4,1,2,4,2,1,2,2,4,2,1,1,2,1,2,5,2,2,2,1,5,1,1,1,4,2,1,5,2,2,1,1,1,1,1,1,4,2,1,5,2,5,2,1,2,4,2,2,1,1,2,4,1,4,1,2,2,2,4,2,1,2,4,1,1,4,1,2,1,2,1,4,2,1,2,5,5,4,1,2,2,2,2,3,2,2,2,2,5,2,5,2,1,2,1,4,1,2,1,2,4,1,1,2,2,1,1,1,1,1,2,1,1,2,5,2,1,1,4,2,1,1,4,1,1,1,2,2,1,2,2,3,1,1,2,2,2,1,2,2,1,1,2,2,2,3,1,1,2,4,4,1,1,2,2,2,3,2,1,4,4,1,4,4,2,1,2,1,5,1,4,2,2,2,2,2,2,4,2,2,4,5,2,1,1,2,2,1,2,2,5,4,1,2,3,5,2,2,2,1,1,2,2,2,1,1,1,2,2,2,5,4,2,4,4,1,4,5,1,2,1,1,4,3,4,4,1,1,1,1,4,2,3,1,4,1,1,1,4,1,1,2,2,1,1,1,5,1,1,2,1,4,2,4,4,1,5,1,2,2,2,1,1,2,3,1,2,2,5,1,2,1,2,4,2,2,1,2,4,4,2,2,2,2,1,4,2,1,4,2,1,1,2,1,2,2,5,2,1,5,4,2,2,2,4,2,2,5,1,1,5,1,1,2,4,2,5,1,4,1,2,1,3,2,2,1,2,2,1,2,4,4,1,2,1,5,1,1,1,1,1,2,2,2,1,5,5,1,1,2,4,1,2,2,1,3,1,4,2,1,1,4,1,2,2,2,2,2,5,2,2,2,2,2,2,1,1,1,2,1,1,2,2,1,1,2,1,1,1,1,1,1,3,1,2,2,1,4,2,1,4,3,2,2,2,1,3,4,2,4,2,2,2,4,1,2,1,2,2,1,5,1,2,4,2,2,1,1,4,1,1,1,1,1,1,1,2,4,1,1,1,2,4,2,2,3,2,2,1,1,3,1,4,2,2,2,1,2,4,2,2,2,2,1,3,5,1,4,3,1,3,1,1,1,2,3,1,5,5,5,2,1,2,1,1,1,2,2,1,1,5,2,4,2,3,4,2,4,1,5,1,4,2,2,1,1,1,2,2,2,1,4,3,1,1,1,1,5,2,1,2,3,4,2,1,2,2,4,1,5,1,4,2,2,5,4,2,1,1,4,3,4,5,1,1,2,1,1,2,1,1,2,1,2,2,2,5,2,2,2,1,4,1,2,1,2,2,1,4,4,5,3,1,4,2,2,2,5,2,2,2,2,2,1,1,1,4,2,1,1,1,1,1,2,1,2,2,2,1,1,2,1,2,2,2,1,1,4,2,4,2,4,4,2,4,2,2,4,2,2,2,1,4,2,2,1,4,2,3,2,3,2,2,2,1,2,1,1,2,5,1,1,5,2,2,4,1,3,2,1,1,1,4,2,2,1,4,2,1,4,1,1,2,2,2,1,3,2,2,2,1,1,1,2,2,1,3,1,2,1,2,2,1,4,2,2,2,2,1,2,2,4,2,1,5,3,5,2,1,2,1,5,2,2,1,4,2,4,2,2,4,2,1,1,4,2,1,1,2,4,2,4,1,2,2,2,1,1,1,2,2,1,1,3,1,1,4,2,2,1,1,2,2,2,1,1,3,1,1,1,4,1,2,5,1,1,1,2,1,1,4,1,2,2,1,2,2,4,1,1,5,2,2,5,2,4,4,1,2,1,1,1,1,1,2,3,2,3,1,1,2,4,2,2,4,3,2,3,2,1,1,1,1,1,2,5,2,4,3,2,1,2,2,1,1,3,1,1,2,1,2,1,4,1,4,1,2,4,2,4,1,1,2,2,1,1,2,2,1,4,1,2,2,1,2,2,2,1,1,2,1,2,2,2,1,1,2,4,4,2,4,1,2,5,1,1,1,1,3,3,1,2,2,2,2,2,2,1,2,1,1,1,1,3,1,1,2,4,1,3,2,1,2,4,1,2,2,4,4,4,1,2,2,2,1,2,2,2,1,2,1,1,4,4,2,1,2,1,1,1,2,2,4,2,3,4,1,2,2,2,1,1,2,2,1,5,1,1,2,1,2,1,1,2,1,4,2,2,4,5,1,1,2,5,1,2,1,1,1,1,1,2,2,2,1,1,1,4,2,1,4,3,1,3,5,1,2,2,2,4,1,2,1,1,1,1,2,1,2,2,1,2,2,1,2,2,1,2,5,1,1,1,1,1,2,1,1,1,1,1,2,1,2,2,2,1,1,2,2,4,1,2,4,2,4,2,2,2,2,1,5,1,1,2,5,2,4,3,1,1,1,2,1,1,2,2,2,4,2,4,2,1,1,1,2,2,2,1,2,4,1,4,5,1,2,1,1,2,1,5,2,4,1,1,2,1,1,2,1,2,2,1,1,4,1,2,4,2,2,2,4,5,4,2,1,1,1,4,3,2,4,1,1,1,2,2,2,1,2,1,2,2,2,1,3,2,3,1,2,2,2,1,2,1,1,5,4,1,2,4,3,3,4,2,1,1,1,1,2,4,1,5,3,2,2,1,3,2,2,2,1,1,4,1,1,2,1,4,1,1,1,2,1,2,2,3,2,2,2,2,2,2,1,2,2,1,1,2,4,4,4,2,4,2,2,4,4,4,2,4,4,1,2,4,2,2,2,1,1,2,1,4,2,2,1,2,1,2,2,2,2,1,1,5,1,4,3,4,1,2,1,4,2,2,1,1,2,1,1,3,1,1,5,4,1,1,1,1,1,2,4,2,2,1,2,1,3,2,4,2,3,1,2,2,2,5,2,1,2,1,4,1,4,1,1,2,2,1,4,1,2,1,1,3,2,2,1,1,4,2,2,1,2,2,2,2,2,1,1,5,1,1,2,1,1,2,2,1,1,5,2,2,1,2,4,2,1,4,2,1,2,4,2,1,3,1,2,2,1,1,2,2,2,1,3,1,1,2,2,1,2,1,1,1,2,2,1,3,1,1,3,2,1,2,2,2,5,2,1,2,2,1,1,4,5,1,2,3,2,4,1,3,1,2,4,4,2,2,3,2,2,4,4,4,1,2,2,4,2,2,1,2,4,4,1,2,2,1,1,5,2,2,1,1,1,1,2,4,2,5,1,4,1,2,1,2,5,1,2,2,2,1,1,1,2,1,5,2,2,2,1,1,1,1,1,1,2,1,2,2,1,2,1,1,2,1,2,1,4,5,1,1,1,3,2,1,1,3,1,2,2,2,4,1,2,1,1,1,1,2,2,1,3,1,1,2,2,4,1,1,1,1,4,1,1,2,2,1,1,1,1,1,2,2,2,2,2,5,1,2,1,1,1,2,1,2,1,2,4,1,2,2,2,1,2,2,1,2,1,2,5,5,3,1,1,1,1,1,2,2,2,1,2,4,2,2,2,5,1,2,5,3,1,1,4,3,2,4,2,2,1,2,2,2,1,4,2,2,1,1,1,2,2,2,2,2,5,1,1,1,2,1,1,1,2,5,3,2,1,2,2,1,2,2,1,3,3,3,1,1,2,1,5,1,2,2,2,4,1,2,4,4,2,1,1,2,2,1,1,1,3,2,2,4,2,5,1,2,1,2,2,5,2,2,5,2,4,1,1,2,1,1,1,2,1,1,1,1,2,1,1,2,1,1,2,2,2,2,1,1,2,2,2,2,1,2,1,5,4,2,2,4,2,2,4,2,5,2,2,1,2,2,4,3,1,4,1,1,4,4,1,1,1,1,2,2,2,5,4,3,1,1,4,1,4,5,2,1,5,1,1,4,2,2,1,2,2,5,4,1,1,2,2,2,2,1,2,1,1,1,4,1,2,1,1,2,1,1,1,2,4,1,3,2,3,4,3,1,4,2,1,1,2,2,1,2,3,2,5,1,1,4,1,1,2,4,4,2,2,1,2,4,4,1,2,1,1,1,1,1,4,1,4,1,2,2,2,2,1,1,2,1,1,2,1,1,5,1,2,5,2,4,5,4,1,2,5,2,3,1,1,2,5,1,1,5,5,4,1,2,4,2,2,1,1,4,1,1,1,1,2,4,2,2,4,4,5,4,1,2,4,1,1,1,4,2,4,2,2,1,2,3,2,4,1,2,1,4,1,2,1,2,2,1,1,1,1,1,2,1,2,1,2,3,2,1,4,4,2,4,2,3,2,1,1,4,2,2,2,1,2,1,1,5,1,5,1,2,1,1,2,1,1,2,4,1,1,2,4,1,1,5,4,1,2,4,3,2,1,3,4,2,1,1,1,1,2,4,1,1,2,2,1,1,1,1,4,2,4,3,1,1,2,2,1,2,2,1,1,2,1,1,4,2,1,2,1,4,2,4,3,2,2,2,2,2,1,1,2,1,2,3,2,2,2,2,1,2,2,1,5,4,2,4,2,4,1,2,1,4,2,1,2,2,4,2,4,1,1,2,2,1,2,1,1,2,2,1,2,2,1,2,1,2,2,1,1,2,1,2,1,2,1,2,1,1,5,2,4,2,3,1,1,4,1,2,2,2,2,1,3,4,2,1,1,1,1,4,1,2,1,3,1,2,4,2,1,4,2,2,1,4,2,2,2,3,1,1,1,1,1,1,5,1,2,2,1,4,2,2,2,2,2,4,3,1,1,2,4,2,1,5,4,2,4,1,2,1,1,2,2,1,1,1,2,5,2,2,2,1,1,1,1,4,2,2,4,2,2,1,5,2,1,2,5,2,2,1,4,1,2,4,5,4,1,1,2,2,2,4,1,5,1,5,1,2,3,1,2,2,1,2,2,2,2,4,2,1,5,2,2,2,2,2,1,2,1,1,2,1,2,2,1,3,2,2,1,5,1,1,1,2,2,2,4,3,2,4,4,1,2,2,3,1,1,1,2,2,2,2,2,1,1,2,2,1,1,2,2,2,1,2,1,3,4,4,1,1,1,2,1,4,2,1,1,2,4,2,4,2,2,4,4,5,4,2,1,2,2,2,2,1,1,2,5,2,1,4,1,2,4,2,2,5,2,4,2,2,1,1,5,4,1,1,2,1,1,1,1,1,2,5,5,1,4,1,4,4,1,1,1,2,3,1,4,1,1,1,1,2,2,1,1,2,4,1,2,1,1,1,2,2,2,2,2,2,2,2,1,1,2,1,2,2,2,1,4,5,2,2,2,2,2,2,1,2,3,5,1,4,1,2,1,1,2,1,2,1,1,1,4,4,1,2,2,4,5,2,1,2,2,2,2,1,1,4,2,1,2,4,1,2,2,2,1,2,1,1,4,1,2,1,1,5,4,2,1,2,2,2,1,2,5,1,3,1,3,1,1,2,1,1,4,2,5,2,2,4,3,1,4,1,2,1,1,2,1,1,2,2,3,2,4,1,1,1,1,1,2,1,1,1,1,2,2,1,1,5,1,4,2,1,4,1,2,2,2,4,2,5,2,1,3,1,2,4,1,1,3,1,1,1,1,1,1,1,1,1,2,1,4,4,1,1,4,2,2,5,1,1,2,2,2,2,1,1,1,4,2,1,2,1,2,4,2,2,2,5,2,1,1,2,5,1,1,1,1,1,2,1,2,2,1,2,4,2,2,4,1,1,4,2,2,1,1,4,4,1,1,4,1,2,4,1,2,1,2,2,2,1,1,1,3,1,2,2,4,2,1,4,1,1,4,3,2,2,1,1,2,5,2,4,4,2,2,3,1,5,2,2,1,1,1,1,1,2,2,4,1,2,5,2,1,1,2,2,2,2,4,5,1,1,2,1,1,3,2,2,2,2,1,5,1,2,5,2,2,1,2,2,3,5,4,4,5,2,1,1,1,5,1,2,1,4,3,2,2,1,1,2,1,1,2,1,2,1,2,2,2,1,2,1,1,3,1,2,2,4,3,1,2,2,4,3,3,4,2,1,5,1,5,4,1,4,2,1,1,2,1,1,1,2,1,2,1,4,4,2,2,1,3,1,1,1,1,5,1,1,1,1,4,2,5,5,2,2,3,1,2,1,1,2,3,1,2,2,4,2,2,4,1,1,1,2,4,4,1,2,4,2,2,1,1,1,2,1,1,2,2,2,2,2,4,1,1,3,1,1,2,1,2,1,1,2,2,1,1,2,5,2,1,1,4,2,2,1,2,4,1,1,4,1,1,5,1,4,1,1,1,1,1,2,1,1,3,1,1,2,5,4,2,5,2,1,2,1,2,4,4,2,2,2,2,2,2,1,1,3,2,4,2,1,4,2,1,1,1,1,2,1,2,2,1,1,2,2,3,2,2,1,2,1,1,2,4,2,2,1,5,1,1,3,2,1,5,1,1,4,2,1,2,2,1,1,2,2,2,1,2,2,1,1,2,1,2,4,4,1,1,2,1,2,1,4,1,2,2,1,1,2,2,1,1,1,2,2,2,1,2,2,2,1,1,2,2,1,5,1,1,2,2,2,4,2,4,1,4,1,2,1,1,2,2,2,2,2,4,1,1,1,2,2,2,1,1,1,2,2,4,1,2,4,1,1,1,4,1,2,2,1,1,4,1,5,4,4,1,2,3,1,4,1,4,4,5,2,1,5,1,2,2,2,1,2,5,2,1,1,2,5,1,4,1,4,1,1,4,1,2,5,1,1,3,1,1,1,1,1,1,2,1,1,3,1,2,2,1,1,2,5,1,2,2,2,2,1,1,4,1,1,1,2,2,4,4,2,4,1,2,2,1,1,4,1,1,1,1,5,1,2,1,2,5,3,1,1,5,2,2,2,2,1,4,4,1,2,4,2,1,1,1,5,4,2,1,1,2,2,2,4,5,1,2,1,4,4,1,2,1,2,1,1,1,4,2,1,2,1,2,1,3,1,1,1,2,2,2,2,4,1,1,2,4,1,2,1,4,1,2,1,4,2,1,4,1,1,1,2,1,2,1,2,2,1,4,2,3,5,2,1,1,1,2,2,2,4,4,4,1,1,2,1,1,2,1,1,2,1,1,1,1,2,1,1,4,2,4,2,2,1,2,1,1,1,2,1,4,1,2,2,4,1,1,3,4,1,2,5,2,1,2,1,2,1,2,1,5,4,2,2,1,4,2,1,2,2,1,4,1,2,5,2,2,1,2,3,2,2,2,1,2,2,5,1,1,1,1,3,4,4,2,1,2,2,1,1,1,2,1,2,1,1,3,1,1,1,2,2,2,2,2,1,5,5,2,1,1,1,2,2,1,1,2,2,2,3,1,5,4,1,1,2,1,2,2,2,2,2,2,5,2,2,1,2,1,3,2,2,1,2,4,1,2,2,1,4,5,1,1,4,1,2,2,2,5,1,2,3,1,5,1,4,1,1,2,2,1,2,1,2,2,1,2,2,1,4,1,2,3,1,1,1,2,4,4,4,1,1,4,2,1,2,2,2,4,2,2,2,2,1,1,1,2,1,4,1,1,2,1,2,1,3,2,1,1,1,1,1,4,1,2,2,2,2,2,2,2,1,1,4,1,1,3,2,2,2,1,1,1,1,1,2,1,1,2,2,2,1,2,2,1,2,2,5,4,2,2,2,2,1,1,2,4,4,4,3,2,5,1,2,1,1,2,2,2,4,2,4,2,2,4,1,1,1,1,1,1,2,1,2,3,1,1,2,3,1,4,1,2,4,1,2,3,2,4,2,2,4,1,1,4,2,4,2,1,2,4,1,5,1,1,3,1,1,2,4,2,1,2,1,2,2,1,1,1,1,2,2,1,3,2,1,2,2,2,2,4,4,1,2,4,3,2,3,4,2,1,1,3,1,2,5,2,1,1,1,1,4,5,5,1,2,2,1,1,1,4,1,1,1,2,1,2,1,2,4,1,3,2,2,2,1,3,1,4,3,2,2,2,2,1,4,1,2,5,2,4,1,1,1,4,2,3,2,2,1,5,1,1,1,2,1,1,2,3,1,3,1,1,1,1,1,1,2,1,2,1,1,2,2,3,2,2,1,2,2,1,2,2,2,2,1,1,5,1,2,1,2,2,4,1,4,1,2,2,2,3,2,2,1,2,1,1,4,3,1,4,1,2,2,4,5,4,2,2,1,2,2,4,2,1,4,1,2,1,1,2,1,1,4,4,2,5,1,5,1,2,2,1,2,5,1,2,5,2,1,1,2,4,2,2,1,1,2,1,4,1,3,1,2,1,1,4,2,2,5,1,1,1,3,2,1,2,2,3,1,2,2,2,1,1,4,2,1,1,2,4,1,2,4,4,5,2,5,4,1,1,1,1,1,4,1,1,1,5,5,5,2,1,2,1,2,2,2,1,1,4,3,3,1,1,4,2,3,1,1,2,2,1,1,2,2,2,2,2,1,3,3,2,2,2,2,2,3,1,1,1,2,1,1,3,4,3,1,1,4,4,1,4,1,4,2,1,2,1,1,1,1,4,1,2,4,2,2,5,2,2,2,2,2,1,2,4,2,1,2,2,2,1,1,2,2,5,2,3,2,2,2,1,2,4,2,4,4,1,2,1,2,2,2,1,1,2,2,2,1,4,2,1,2,2,1,1,1,1,1,1,5,1,3,3,2,2,1,1,1,5,1,2,2,4,4,2,2,2,1,2,2,1,4,2,2,1,1,1,5,1,2,2,2,4,1,2,2,2,2,1,1,4,2,2,1,1,2,1,1,2,2,1,4,2,1,1,2,2,2,1,4,1,5,3,1,2,2,2,1,1,1,1,1,1,2,2,1,5,2,4,3,1,4,2,1,4,1,2,2,1,1,1,2,2,2,1,1,1,4,1,1,4,2,1,4,4,2,1,4,2,1,3,3,1,2,1,3,2,2,5,2,2,2,1,2,2,2,1,2,1,1,2,1,2,1,2,1,4,3,1,1,2,4,1,2,1,1,2,2,2,2,4,1,1,2,2,4,1,5,2,1,1,1,1,2,1,1,2,1,1,2,5,2,4,2,1,1,4,2,1,5,5,1,2,2,4,1,2,3,2,2,1,1,1,1,2,1,4,2,2,4,1,1,2,2,4,1,1,2,3,1,1,5,1,2,2,2,1,1,1,5,1,1,1,2,2,2,1,1,4,4,2,2,2,3,1,2,1,4,1,1,4,1,2,2,5,2,4,1,4,4,2,4,2,1,2,2,2,4,2,4,4,4,2,4,1,2,1,3,1,2,1,2,5,1,1,1,1,1,1,2,2,2,1,4,1,4,1,4,3,1,4,4,4,1,1,1,4,2,2,2,2,2,2,2,1,1,4,3,2,2,1,3,1,3,1,2,2,5,3,1,1,1,2,4,2,2,1,1,2,2,2,1,2,1,3,2,2,2,2,2,4,2,2,2,1,4,2,4,1,3,1,2,4,2,1,2,1,2,2,2,1,1,2,4,2,5,4,2,2,2,2,2,2,4,2,1,1,2,2,2,1,4,2,2,1,2,2,2,4,1,2,1,2,1,2,2,2,2,1,1,2,1,1,4,1,2,2,1,2,5,1,2,1,1,4,4,1,1,1,4,5,2,2,1,2,1,1,2,1,1,2,2,3,2,1,5,1,1,1,1,2,4,2,1,2,1,2,2,1,1,1,4,2,2,2,1,4,3,4,2,2,2,2,2,1,4,3,5,3,1,2,4,1,2,1,2,2,4,4,4,1,2,4,4,2,1,1,4,2,1,4,2,1,2,2,2,2,2,1,2,2,2,2,1,1,2,2,1,1,4,2,3,1,3,1,1,2,5,1,2,2,3,5,4,2,4,2,2,2,3,1,4,4,1,2,1,1,2,4,2,2,3,1,1,2,2,2,2,3,4,2,1,3,2,2,1,2,2,2,2,1,2,1,2,2,2,1,4,1,4,1,1,2,1,2,1,1,2,1,4,2,1,1,2,1,1,1,2,2,1,1,1,2,2,1,2,2,2,1,3,4,1,5,4,1,2,1,4,1,1,4,1,4,3,4,2,3,4,1,2,2,1,2,1,1,4,2,5,1,2,1,1,2,5,2,1,1,1,4,2,2,2,1,2,1,2,1,2,4,1,2,2,4,2,1,1,2,2,4,1,2,2,1,1,3,2,2,2,2,1,2,2,1,2,4,2,2,5,2,1,4,3,3,3,2,2,4,2,2,1,2,1,5,2,1,2,1,2,2,1,1,2,1,2,4,2,2,1,2,1,2,2,1,1,1,2,2,2,1,1,2,4,3,1,1,3,2,1,2,2,3,1,2,1,1,1,2,1,1,4,1,2,1,1,1,1,3,4,1,2,4,2,5,5,1,1,2,5,4,1,1,1,1,2,2,4,1,2,2,1,2,5,4,4,2,1,3,2,5,4,2,2,2,1,1,1,2,1,2,2,2,1,4,4,4,1,3,1,3,4,1,1,2,1,1,2,4,3,2,2,2,2,1,1,1,2,5,2,4,3,1,1,1,2,2,4,1,4,2,4,1,2,4,2,1,2,2,2,2,1,2,4,2,1,1,4,4,2,1,4,2,2,2,2,2,1,1,2,4,1,2,1,1,2,1,1,2,2,2,2,4,4,1,1,1,1,2,1,2,4,1,2,4,4,2,2,1,1,5,4,4,1,1,4,2,1,4,3,2,1,2,2,2,5,2,2,4,1,2,1,5,4,1,2,4,1,1,1,2,4,2,1,1,2,1,2,1,1,2,2,1,4,4,2,4,1,4,2,2,3,2,1,1,2,1,2,1,4,2,4,4,2,3,1,2,4,2,1,2,1,1,2,2,1,1,2,1,1,4,1,2,2,3,2,4,1,2,1,2,1,5,2,1,2,2,2,4,2,2,5,1,2,1,2,2,2,1,1,4,1,2,1,4,1,1,2,2,2,4,1,1,5,2,4,1,2,2,1,1,2,5,2,2,1,1,2,3,2,1,1,4,1,2,5,1,1,1,2,2,2,2,2,4,4,2,1,2,1,1,2,1,2,1,1,1,3,1,2,2,1,1,1,2,1,1,2,1,3,1,2,1,2,4,1,2,1,1,2,1,1,4,1,1,4,2,4,1,1,2,1,2,1,3,3,2,4,2,4,1,1,1,1,2,1,1,1,1,5,1,4,1,4,1,2,2,1,1,2,1,1,4,1,1,1,2,4,2,2,2,4,2,4,1,2,1,2,1,5,1,1,3,1,2,2,4,2,1,4,4,4,1,2,1,1,2,1,1,1,2,2,1,1,2,1,1,1,4,1,1,1,1,1,4,1,2,1,2,2,1,1,1,2,1,2,2,1,2,2,4,1,2,4,1,1,1,1,1,1,2,2,1,1,1,3,2,1,5,2,4,3,1,1,1,2,2,1,2,2,1,4,2,2,2,2,1,4,2,2,4,1,1,1,2,1,3,2,1,4,2,4,2,2,1,2,1,1,1,4,1,1,1,2,1,1,2,1,5,4,2,2,1,4,2,1,2,5,2,1,2,2,4,2,1,1,2,2,3,1,5,2,2,2,2,1,4,4,1,5,4,4,1,1,1,1,1,2,4,4,2,2,2,1,1,1,2,4,2,1,2,2,2,2,5,1,2,2,1,4,4,2,1,1,1,2,2,2,2,2,4,5,4,2,5,2,2,2,1,2,2,1,1,1,1,1,2,2,2,4,2,1,2,2,1,2,1,2,4,5,1,1,2,2,1,2,2,1,4,1,2,5,4,2,4,1,4,1,2,1,2,1,1,1,4,2,1,3,5,1,2,1,3,2,1,1,1,4,1,1,2,2,1,1,1,1,4,3,1,2,2,1,1,2,2,2,4,2,4,1,4,1,1,2,2,2,2,2,1,2,2,1,1,1,1,2,5,2,2,2,3,3,2,2,1,5,2,3,2,1,2,1,4,3,2,5,1,4,1,2,2,2,2,2,1,2,1,5,2,1,1,1,1,2,2,1,5,1,2,1,1,2,1,1,2,2,4,4,1,3,2,2,1,1,1,3,1,4,3,4,2,1,1,4,2,2,1,2,4,1,2,1,1,2,1,1,4,2,2,2,2,3,1,4,1,2,2,2,1,2,1,2,3,5,5,4,3,1,2,4,2,2,1,2,2,1,2,1,2,2,2,1,1,1,1,1,1,2,2,4,1,1,1,2,2,1,1,2,1,2,2,1,2,1,2,2,1,1,2,1,2,2,4,2,2,2,1,2,1,2,1,1,2,2,2,2,1,2,2,1,1,1,1,2,2,1,4,2,1,1,1,1,4,2,2,2,4,2,3,2,1,2,2,4,2,2,3,2,2,4,1,2,2,1,1,1,1,2,2,4,4,1,4,1,2,2,2,4,1,1,2,2,1,2,1,2,2,2,1,2,1,1,1,5,3,2,2,4,1,4,1,5,2,2,1,2,4,3,5,1,5,1,2,1,4,2,2,1,1,2,5,3,2,5,1,2,2,2,1,2,1,1,4,1,2,1,2,1,2,1,1,2,1,5,2,1,1,3,1,4,4,2,2,1,1,5,2,1,1,3,1,1,4,2,2,1,1,2,3,2,2,1,4,4,1,2,2,2,5,1,1,2,2,3,1,1,2,2,2,1,1,2,1,4,1,2,2,2,2,2,1,4,1,3,1,3,2,1,4,2,1,1,5,1,1,1,2,4,2,2,1,1,2,2,2,2,1,4,1,1,4,3,5,4,4,5,1,4,2,1,1,1,2,1,4,1,3,1,2,1,1,1,1,2,2,2,1,1,2,2,2,2,2,4,1,2,3,1,2,1,2,1,4,1,1,2,2,2,1,2,1,1,1,1,2,4,1,3,2,4,1,2,1,2,1,1,2,2,3,2,2,1,4,1,4,2,3,5,2,2,4,2,2,2,1,4,1,4,1,1,1,2,4,2,5,2,1,2,1,1,2,4,2,2,1,4,1,2,3,2,1,3,1,1,1,2,2,1,1,1,2,1,1,2,2,1,1,4,1,1,1,1,2,5,2,1,2,1,1,5,2,2,1,1,2,1,5,4,2,2,3,2,1,1,2,2,1,1,2,2,5,1,2,2,1,2,2,2,2,1,2,4,2,2,2,2,2,2,5,2,1,3,2,2,2,2,2,1,2,1,1,2,1,2,2,1,2,2,1,1,2,1,1,1,2,2,1,5,1,4,1,1,2,1,1,2,2,4,2,4,2,1,4,3,2,1,2,5,3,1,2,2,1,2,1,1,4,3,1,1,2,5,2,1,4,1,1,1,1,4,1,2,5,1,1,1,2,3,1,1,1,4,1,1,2,2,4,2,2,3,2,1,1,1,1,1,1,4,5,4,2,2,3,2,1,2,2,3,1,1,2,1,2,1,3,1,2,1,1,1,5,1,4,2,4,1,1,4,5,2,5,2,3,2,4,1,1,1,5,3,4,4,2,1,2,2,1,1,5,1,4,1,1,2,2,5,2,1,2,4,2,1,3,1,2,2,1,2,1,3,4,4,2,1,4,2,2,1,2,4,1,2,2,1,4,5,2,2,1,1,4,1,2,1,2,2,2,2,2,5,2,1,3,4,5,2,2,2,2,1,2,4,2,1,1,1,5,4,4,5,2,1,5,1,2,1,3,2,2,2,2,1,2,1,2,2,2,2,1,2,4,4,3,1,5,2,5,2,2,1,1,2,2,4,3,4,2,1,1,5,2,2,1
        );
        System.out.println(HackerRank_3.migratoryBirds(birdsType));
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

    /*******************************************************************/

    /**
     * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each
     * the array element between two given indices, inclusive. Once all operations have been performed, return
     * the maximum value in the array.
     *  a b k
     *  1 5 3
     *  4 8 7
     *  6 9 1
     */
    static long arrayManipulation(int n, int[][] queries) {
        int[] numbers = new int[n+1];

        for (int[] query : queries) {
            numbers[query[0] - 1] += query[2];
            numbers[query[1]] -= query[2];
        }


        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /*******************************************************************/

    // https://www.hackerrank.com/challenges/dynamic-array/problem

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (List<Integer> num : queries) {
            List<Integer> temp = list.get((num.get(1) ^ lastAnswer) % n);

            if (num.get(0) == 1){
                temp.add(num.get(2));
            } else {
                lastAnswer = temp.get(num.get(2) % temp.size());
                System.out.println(lastAnswer);
                result.add(lastAnswer);
            }
        }
        return result;
    }

    /*******************************************************************/


    static int[] minMoves = new int[1000001];

    public static int downToZero(int n) {
        if (n <= 3) return n;
        if (minMoves[n] > 0) return minMoves[n];
        int min = Integer.MAX_VALUE;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) {
                int factor = n/i;
                min = Math.min(min, 1 + downToZero(factor));
            }
        }
        min = Math.min(min, 1 + downToZero(n-1));
        minMoves[n] = min;
        return min;
    }

    /*******************************************************************/


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = 0;
        for(int i = keyboards.length-1; i >= 0; i--){
            int sum = 0;
            for(int j = drives.length-1; j >= 0; j--){
                sum = keyboards[i]+drives[j];
                if(sum > max && sum <= b)
                    max = sum;
            }
        }
        if(max == 0)
            return -1;
        else
            return max;
    }

    /*******************************************************************/

    static String catAndMouse(int x, int y, int z) {
        if (Math.abs(z-x) < Math.abs(z-y)){
            return "Cat A";
        } else if (Math.abs(z-x) > Math.abs(z-y)){
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    /*******************************************************************/

    public static int formingMagicSquare(List<List<Integer>> s) {
        int cost = Integer.MAX_VALUE;
        int[][] t =
                {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                };
        int temp = 0;
        for(int i=0;i<8;i++){
            temp = Math.abs(s.get(0).get(0) - t[i][0]) + Math.abs(s.get(0).get(1) - t[i][1]) + Math.abs(s.get(0).get(2) - t[i][2])
                 + Math.abs(s.get(1).get(0) - t[i][3]) + Math.abs(s.get(1).get(1) - t[i][4]) + Math.abs(s.get(1).get(2) - t[i][5])
                 + Math.abs(s.get(2).get(0) - t[i][6]) + Math.abs(s.get(2).get(1) - t[i][7]) + Math.abs(s.get(2).get(2) - t[i][8]);
            cost = Math.min(temp, cost);
        }
        return cost;
    }

    /*******************************************************************/

    public static int pickingNumbers(List<Integer> a) {
        int[] repeated = new int[100];
        int max = 0;

        for (int num : a) {
            repeated[num]++;
        }

        for (int i = 0; i < repeated.length - 1; i++) {
            max = Math.max(repeated[i] + repeated[i + 1], max);
        }

        return max;
    }

    /*******************************************************************/

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = ranked.stream().distinct().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int index = ranks.size() - 1;

        for(int num : player){
            while (index >= 0){
                if (num >= ranks.get(index)){
                    index--;
                }else{
                    result.add(index+2);
                    break;
                }
            }
            if (index < 0){
                result.add(1);
            }
        }
        return result;
    }

    /*******************************************************************/

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int maxHeight = Collections.max(height);
        return Math.max(maxHeight - k, 0);
    }

    /*******************************************************************/

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int wordCount = word.length(), tallest = 0, index = 0;
        for (int i = 0; i < wordCount; i++) {
            index = word.charAt(i) - 97;
            if (h.get(index) > tallest){
                tallest = h.get(index);
            }
        }
        return tallest * wordCount;
    }

    /*******************************************************************/

    //  The Utopian Tree goes through 2 cycles of growth every year. Each spring,
    //  it doubles in height. Each summer, its height increases by 1 meter
    public static int utopianTree(int n) {
        // Write your code here
        int height = 1;
        if (n == 0)
            return height;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                height++;
            } else {
                height *= 2;
            }
        }

        return height;
    }

    /*******************************************************************/

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Non-Divisible Subset

        // In maths. if (a + b) % k = 0 => then ((a % k) + (b % k)) % k = 0
        // Example: (5 + 7) % 6 = 0 => then (5 % 6) + (7 % 6) > (5 + 1) % 6 = 0

        // Solution: Find remainder of each element in the array.
        // then, choose max element from the pair which together can able to be divided by k. If one pair is "i" then other pair will be "k-i"
        // For example: S = {2, 3, 7, 8, 12} and k = 5.
        // Now we have 3 numbers whose remainder 2 => ( 2 % 5 = 2, 7 % 5 = 2, 12 % 5 = 2)
        // and also we have 2 numbers whose remainder 3 => (3, 8)
        // Right now we have to choose one of the element from that pair (3, 2) (where 3 > numbers 2, 7, 12 && 2 > numbers 3, 8)
        // Because of the problem, we will choose the max which is 3.
        int[] reminderArray = new int[k];

        // find remainder of each element in the array S
        // For example k = 4, S = {0, 5, 7, 10} => remainderArr will be: {0, 1, 1, 1}
        // where each index represents remainder. For example remainderArr[2] = 1 means
        // that there is 1 number whose remainder 2 after divided 4. (10 % 4 = 2)
        for(int num : s) {
            reminderArray[num % k]++;
        }

        // After getting each remainder, index 0 (actually remainder 0) is a special case
        // Think of it like this:
        // 1. There will be no element such as k - 0 = k. (remainderArr[k] will give us ArrayIndexOutOfBoundsException)
        // 2. If there are 2 elements in remainderArr[0], we have to choose only 1, otherwise, we can sum up 2 or more
        // zeros, then non-sub divisible set could be divisible by k.
        int zeroReminder = reminderArray[0];

        // That's why, our initial subset size is 1, if there is a zero remainder,
        // otherwise it is 0
        int maxNumberOfDivisibleSet = zeroReminder > 0 ? 1 : 0;

        // Another thing is that pair which is itself. That's means, let's say k = 4, therefore pair of remainderArr[2]
        // will also be remainderArr[2]( i = 2 then, k - i = 2). Thus, we have to choose only 1 element from that pair (or we should increment
        // the result number just 1)
        // if condition "i != k - i" will handle this situation.
        for (int i = 1; i <= (k/2); i++) {
            if (i != k - i){
                maxNumberOfDivisibleSet += Math.max(reminderArray[i], reminderArray[k-i]);
            } else {
                maxNumberOfDivisibleSet++;
            }
        }

        return maxNumberOfDivisibleSet;
    }

    /*******************************************************************/

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int counter = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if((ar.get(i) + ar.get(j)) % k == 0){
                    counter++;
                }
            }
        }

        return counter;
    }

    /*******************************************************************/

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
//        int[] numbers = new int[arr.size()];
//        int maxNumber = 0;
//
//        for (int i = 0; i < arr.size(); i++){
//            numbers[arr.get(i)]++;
//        }
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] > maxNumber){
//                maxNumber = i;
//            }
//        }

        return maxNumber;
    }
}
