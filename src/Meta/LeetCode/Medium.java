package Meta.LeetCode;

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

    /*
      Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
      A subarray is a contiguous non-empty sequence of elements within an array.
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        int prefixSum = 0;
        int result = 0;

        counts.put(0, 1);
        for(int num : nums) {
            prefixSum += num;

            result += counts.getOrDefault(prefixSum - k, 0);
            counts.put(prefixSum, counts.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
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

    /*******************************************************************/

    // 1762. Buildings With an Ocean View
    public int[] findBuildings(int[] heights) {
        Stack<Integer> idx = new Stack<>();
        int size = heights.length-1;
        int max = heights[size];

        if(size == 0) {
            return new int[]{0};
        }

        idx.push(size);

        for(int i = size; i > 0; i--) {
            if(heights[i-1] > heights[i] && heights[i-1] > max) {
                idx.push(i-1);
                max = Math.max(max, heights[i-1]);
            }
        }

        size = idx.size();
        int[] result = new int[size];
        for(int j = 0; j < size; j++) {
            result[j] = idx.pop();
        }

        return result;
    }

    /*******************************************************************/

    // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
    public double myPow(double x, int n) {
        return binaryExp(x, n);
    }

    private double binaryExp(double x, long n) {
        // Base case, to stop recursive calls.
        if (n == 0) {
            return 1;
        }

        // Handle case where, n < 0.
        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result with 'x'.
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            return binaryExp(x * x, n / 2);
        }
    }

    /*******************************************************************/

    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    /*******************************************************************/

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
