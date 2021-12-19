package AlgoExpert.Easy;

import static HackerRank.HackerRankTree.Node;

public class FindClosestValueInBST {

    public int FindClosestValue(Node tree, int target){
        return helperMethod(tree,target);
    }

    int helperMethod(Node tree, int target){
        int closest = Integer.MAX_VALUE;
        if (tree == null){
            return closest;
        }

        closest = Math.min(closest, Math.abs(closest - tree.value));
        if (closest == target)
            return closest;

        if (tree.value > target){
            helperMethod(tree.left, target);
        }
        if (tree.value < target){
            helperMethod(tree.right, target);
        }

        return closest;
    }

}
