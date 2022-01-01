package AlgoExpert.Easy;

import HackerRank.HackerRankTree.Node;

public class NodeDepths {
    // Average: Time O(n) | Space O(h)
    int currentDepth = 0;

    public int NodeDepth(Node node){
        return HelperMethod(node, 0);
    }

    private int HelperMethod(Node node, int depth) {
        if (node == null)
            return currentDepth;

        currentDepth += depth;

        HelperMethod(node.left, currentDepth+1);
        HelperMethod(node.right, currentDepth+1);

        return currentDepth;
    }
}
