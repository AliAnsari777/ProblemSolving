package AlgoExpert.Easy;

public class ValidateSubsequence {
    public static void main(String[] args) {
        int [] numbers = {1,7,3,4,9,0,3,4,12};
        int [] subsequence = {7,4,0,12};

        System.out.println(validateSubsequence(numbers, subsequence));
    }

    static boolean validateSubsequence(int[] num, int[] seq){
        int seqIndx = 0;
        for (int val: num){
            if (seqIndx == seq.length)
                return true;
            if (val == seq[seqIndx])
                seqIndx++;
        }
        return seqIndx == seq.length;
    }
}
