package AlgoExpert.Easy;

import static HackerRank.HackerRankTree.Node;

public class FindClosestValueInBST {

    // Average: Time O(Log(n)) | Space O(Log(n))
    // Worst:   Time O(n)      | Space O(n)
    public int FindClosestValue(Node tree, int target){
        int closest = Integer.MAX_VALUE;
        return helperMethod(tree,target, closest);
    }

    int helperMethod(Node tree, int target, int closest){
        if (tree == null){
            return closest;
        }

        if (closest == target)
            return closest;

        if (Math.abs(target - closest) > Math.abs(target - tree.value))
            closest = tree.value;

        if (tree.value > target){
            return helperMethod(tree.left, target, closest);
        }
        else if (tree.value < target){
            return helperMethod(tree.right, target, closest);
        }else
            return closest;
    }

}
