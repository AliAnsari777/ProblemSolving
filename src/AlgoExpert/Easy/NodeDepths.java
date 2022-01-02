package AlgoExpert.Easy;

import HackerRank.HackerRankTree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NodeDepths {
    // Average: Time O(n) | Space O(h)


    public int NodeDepth(Node node, int depth){
        if (node == null)
            return 0;

        return depth + NodeDepth(node.left, depth+1) + NodeDepth(node.right, depth+1);
    }

    public int NodeDepthIterative(Node node){
        int sumOfDepth = 0;
        HashMap<Node, Integer> hashMap = new HashMap<>();
        hashMap.put(node, 0);
        Stack<HashMap<Node, Integer>> stack = new Stack();
        stack.push(hashMap);

        while (stack.size() > 0){
            HashMap<Node, Integer> nodeInfo = stack.pop();
            int depth = nodeInfo.get(node);
            Node value = nodeInfo.keySet().iterator().next();

            if (value == null)
                continue;
            sumOfDepth += depth;

            nodeInfo.clear();
            nodeInfo.put(value.left, depth+1);
            stack.push(nodeInfo);
            nodeInfo.clear();
            nodeInfo.put(value.right, depth+1);
            stack.push(nodeInfo);
        }
        return sumOfDepth;
    }
}
