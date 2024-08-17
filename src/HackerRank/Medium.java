package HackerRank;

import java.util.*;

public class Medium {

    public static void main(String[] args) {
        // Queens Attack II
        List<List<Integer>> obs = new ArrayList<>();
        obs.add(Arrays.asList(5,5));
        obs.add(Arrays.asList(4,2));
        obs.add(Arrays.asList(2,3));

        System.out.println(queensAttack(5, 3, 4, 3, obs ));
        // Expected Output: 6
    }

    static int cellConsume = 0;
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        // possible path for a queen is 8 directions,
        HashMap<Integer, List<Integer>> obstaclesMap = convertObstaclesIntoMap(obstacles);
        bottomIteration(r_q, c_q,obstaclesMap);
        southWestIteration(r_q, c_q,obstaclesMap);
        leftIteration(r_q, c_q,obstaclesMap);
        northWestIteration(r_q, c_q,n, obstaclesMap);
        topIteration(r_q, c_q,n, obstaclesMap);
        northEastIteration(r_q, c_q,n, obstaclesMap);
        rightIteration(r_q, c_q,n, obstaclesMap);
        southEastIteration(r_q, c_q,n, obstaclesMap);
        return cellConsume;
    }

    private static HashMap<Integer, List<Integer>> convertObstaclesIntoMap(List<List<Integer>> obstacles) {
        HashMap<Integer, List<Integer>> obstaclesMap = new HashMap<>();
        obstacles.forEach(x-> {
            obstaclesMap.compute(x.get(0), (k, existingList) -> {
                if (existingList == null) {
                    // Key not present, create a new list
                    return new ArrayList<>(Collections.singletonList(x.get(1)));
                } else {
                    // Key already exists, add value to the existing list
                    existingList.add(x.get(1));
                    return existingList;
                }
            });
        });
        return  obstaclesMap;
    }

    public static void leftIteration(int r_q, int c_q,  HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q, c = c_q-1; c >=1; c--) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }

    public static void bottomIteration(int r_q, int c_q, Map<Integer, List<Integer>> obstacles) {
        for (int r = r_q - 1, c = c_q; r >= 1; r--) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume++;
        }
    }

    public static void southWestIteration(int r_q, int c_q,  HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q-1, c = c_q-1;r >=1 && c >=1;r--, c--) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }

    public static void northWestIteration(int r_q, int c_q,int n, HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q+1, c = c_q -1;r <=n && c >=1; r++, c--) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }

    public static void topIteration(int r_q, int c_q,int n,   HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q+1, c = c_q; r <=n ; r++) {
            if (obstacles.get(r) != null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume++;
        }
    }

    public static void northEastIteration(int r_q, int c_q, int n, HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q+1, c = c_q +1;r <=n && c <=n; r++, c++) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }

    public static void rightIteration(int r_q, int c_q,int n,  HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q, c = c_q +1; c <=n; c++) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }

    public static void southEastIteration(int r_q, int c_q,int n,  HashMap<Integer, List<Integer>> obstacles) {
        for(int r = r_q-1, c = c_q+1;r >=1 && c <=n; r--, c++) {
            if (obstacles.get(r)!=null && obstacles.get(r).contains(c)) {
                return;
            }
            cellConsume ++;
        }
    }
}
