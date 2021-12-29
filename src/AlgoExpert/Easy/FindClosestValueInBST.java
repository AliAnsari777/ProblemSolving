package AlgoExpert.Easy;

import static HackerRank.HackerRankTree.Node;

public class FindClosestValueInBST {
    int closest = Integer.MAX_VALUE;

    // Average: Time O(Log(n)) | Space O(Log(n))
    // Worst:   Time O(n)      | Space O(n)
    public int FindClosestValue(Node tree, int target){
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

    //================================================================//

    // Average: Time O(Log(n)) | Space O(1)
    // Worst:   Time O(n)      | Space O(1)
    public int FindClosestValueIterative(Node tree, int target){
        return helperMethodIterative(tree, target, closest);
    }

    private int helperMethodIterative(Node tree, int target, int closest) {
        Node currentNode = tree;

        while (currentNode != null){
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)){
                closest = currentNode.value;
            }
            if (currentNode.value > target)
                currentNode = currentNode.left;
            else if (currentNode.value < target)
                currentNode = currentNode.right;
            else
                break;
        }

        return closest;
    }

}
