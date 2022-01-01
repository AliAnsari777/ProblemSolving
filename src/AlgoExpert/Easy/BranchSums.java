package AlgoExpert.Easy;

import HackerRank.HackerRankTree.Node;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    // Average: Time O(n)  |  Space O(n)
    public List<Integer> BranchSum(Node root){
        List<Integer> result = new ArrayList<>();
        HelperMethod(root, 0, result);
        return result;
    }

    private void HelperMethod(Node node, int runningSum, List<Integer> result) {
        if (node == null)
            return;

        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null){
            result.add(newRunningSum);
            return;
        }

        HelperMethod(node.right, newRunningSum, result);
        HelperMethod(node.left, newRunningSum, result);
    }
}
