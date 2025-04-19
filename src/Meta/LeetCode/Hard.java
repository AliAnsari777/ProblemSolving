package Meta.LeetCode;

import java.util.*;

public class Hard {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid));

        //############################################################//


    }

    //############################################################//

    /*
    * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
        Return the size of the largest island in grid after applying this operation.
        An island is a 4-directionally connected group of 1s.
    * */

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2;  // start from 2 to avoid conflict with 0 and 1
        int max = 0;

        // Step 1: Label islands and record sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    max = Math.max(max, size);
                    islandId++;
                }
            }
        }

        // Step 2: Try flipping each 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int size = 1; // the flipped cell
                    for (int[] dir : dirs) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                            int id = grid[ni][nj];
                            if (id > 1 && seen.add(id)) {
                                size += islandSize.get(id);
                            }
                        }
                    }
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    // DFS to label the island and return its size
    private static int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int size = 1;
        for (int[] dir : dirs) {
            size += dfs(grid, i + dir[0], j + dir[1], id);
        }
        return size;
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /*******************************************************************/

    /*
        You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
        Merge all the linked-lists into one sorted linked-list and return it.
        [[1,4,5],[1,3,4],[2,6]]
        [1,1,2,3,4,4,5,6]
    */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode point = head;

        for (ListNode n : lists) {
            while (n != null) {
                list.add(n.val);
                n = n.next;
            }
        }

        Collections.sort(list);

        for (int value : list) {
            point.next = new ListNode(value);
            point = point.next;
        }

        return head.next;
    }

    /*******************************************************************/

}
