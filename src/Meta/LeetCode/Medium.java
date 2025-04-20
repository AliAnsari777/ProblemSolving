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


    /*
     Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
     Each node will have a reference to its parent node.
    */
    public Node lowestCommonAncestor(Node p, Node q) {
        Map<Integer, Node> map = new HashMap<>();

        do {
            map.put(p.val, p);
            p = p.parent;
        } while(p != null);

        do {
            if(map.containsKey(q.val)){
                return q;
            }
            q = q.parent;
        } while(q != null);

        return null;

//        Node a = p, b = q;
//        while (a != b) {
//            a = a == null? q : a.parent;
//            b = b == null? p : b.parent;
//        }
//        return a;
    }

    /*******************************************************************/

    /*
    * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;

    }

    /*******************************************************************/

    /*
    * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1]
    * has each integer's value set to its depth.
    * Return the sum of each integer in nestedList multiplied by its depth.
    */
    public int depthSum(List<NestedInteger> nestedList) {
        return unpackAndSum(nestedList, 1);
    }

    private int unpackAndSum(List<NestedInteger>  list, int depth) {
        int total = 0;
        System.out.println("depth: " + depth);
        for(NestedInteger val : list) {
            if(val.isInteger()) {
                total += val.getInteger() * depth;
            } else {
                total += unpackAndSum(val.getList(), depth +1);
            }
        }
        System.out.println("total:" + total);
        return total;
    }

    /*******************************************************************/

    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0], end = intervals[0][1], idx = 0;
        int[][] answers = new int[intervals.length][2];

        for(int i = 0; i < intervals.length; i++) {
            if(end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                answers[idx] = new int[] {start, end};
                start = intervals[i][0];
                end = intervals[i][1];
                idx++;
            }
        }

        answers[idx] = new int[] {start, end};
        answers = Arrays.copyOfRange(answers, 0, idx + 1);

        return answers;
    }

    /*******************************************************************/

    /*
    Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

    A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
    The length of a clear path is the number of visited cells of this path.
    */

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] cell = queue.remove();

            int row = cell[0];
            int col = cell[1];

            int distance = grid[row][col];
            if(row == grid.length-1 && col == grid[0].length-1) {
                return distance;
            }

            for(int[] neighbour : getNeighbours(row, col, grid)){
                int neighborRow = neighbour[0];
                int neighbuotCol = neighbour[1];

                queue.add(new int[]{neighborRow, neighbuotCol});
                grid[neighborRow][neighbuotCol] = distance + 1;
            }
        }

        return -1;
    }

    private static final int[][] dir = new int[][]{{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private List<int[]> getNeighbours(int r, int c, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();

        for(int i = 0; i < dir.length; i++) {
            int newRow = r + dir[i][0];
            int newCol = c + dir[i][1];

            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }

            neighbours.add(new int[]{newRow, newCol});
        }

        return neighbours;
    }

    /*******************************************************************/

    /*
        You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
        You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1]
        (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
        For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the
        probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
    */
    class Solution {
        private int[] prefixSums;
        private int totalsum;

        public Solution(int[] w) {
            this.prefixSums = new int[w.length];
            int prefixSum = 0;

            for (int i = 0; i < w.length; i++) {
                prefixSum += w[i];
                prefixSums[i] = prefixSum;
            }

            this.totalsum = prefixSum;
        }

        public int pickIndex() {
            double target = this.totalsum * Math.random();
            int L = 0, R = this.prefixSums.length, M = 0;

            // run a binary search to find the target zone
            while (L < R) {
                // better to avoid the overflow
                M = L + (R - L) / 2;
                if (target > this.prefixSums[M])
                    L = M + 1;

                else
                    R = M;
            }

            return L;
        }
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

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    class NestedInteger {
        public boolean isInteger() {
            return false;
        }
        public int getInteger() {
            return 0;
        }
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
