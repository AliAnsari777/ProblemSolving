package Meta.LeetCode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Medium {
    public static void main(String[] args) {

        System.out.println(Medium.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

        //############################################################//


    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest
            }
        }

        return minHeap.peek();
    }

    /*******************************************************************/

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            //     Traverse each level
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // The last node at this level is visible from the right
                if(i == size - 1)
                    result.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }
        }

        return result;
    }

    /*******************************************************************/

    /*
    Given the root of a binary tree, return the vertical order traversal of its nodes' values.
    (i.e., from top to bottom, column by column).
    If two nodes are in the same row and column, the order should be from left to right.
    * */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        if(root == null)
            return answers;

        queue.offer(root);
        columns.offer(0);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer col = columns.poll();
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if(node.left != null) {
                queue.offer(node.left);
                columns.offer(col-1);
            }

            if(node.right != null) {
                queue.offer(node.right);
                columns.offer(col+1);
            }
        }

        Integer minKey = Collections.min(map.keySet());
        Integer maxKey = Collections.max(map.keySet());

        while(minKey <= maxKey) {
            answers.add(map.get(minKey));
            minKey++;
        }

        return answers;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
