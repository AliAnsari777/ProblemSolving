package GFG;

import java.util.*;

public class Graphs {
    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2, 3);
        graph.add(3, 3);

        graph.BFS(2);
        graph.DFS(2);
        //*******************************************************//


    }

    //=================================================================//

    static class Graph{

        // Number of vertices
        int vertices;
        // this is our graph an array of LinkedList because graph can has circle
        LinkedList<Integer>[] graph;
        public Graph(int v){
            vertices = v;
            graph = new LinkedList[v];
            // Initialize all value of graph with a linked list.
            for (int i = 0; i < v; i++) {
                graph[i] = new LinkedList<>();
            }
        }

        // Function to add an edge into the graph
        public void add(int vertex, int edge){
            graph[vertex].add(edge);
        }

        public void BFS(int startPoint){
            Queue<Integer> queue = new LinkedList<>();
            boolean[] checked = new boolean[vertices];

            checked[startPoint] = true;
            queue.add(startPoint);

            System.out.println("\nBreadth First Search in Graph, Start Point: " + startPoint);
            while (!queue.isEmpty()){
                startPoint = queue.poll();
                System.out.print(startPoint + " ");

                for (int no : graph[startPoint]) {
                    if (!checked[no]) {
                        checked[no] = true;
                        queue.add(no);
                    }
                }
            }
        }

        /*
        Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
        Space Complexity: O(V).
        Since, an extra visited array is needed of size V.
         */
        public void DFS(int startPoint){
            boolean[] checked = new boolean[vertices];
            System.out.println("\nDepth First Search in Graph, Start Point: " + startPoint);

            // for disconnected graphs
//            for (int i = 0; i < vertices; i++) {
//                if(!checked[i])
//                    DFSUtil(i, checked);
//            }

            // for connected graphs with starting point
            DFSUtil(startPoint, checked);
        }

        private void DFSUtil(int vertices, boolean[] check){
            check[vertices] = true;
            System.out.print(vertices + " ");

            for (int no : graph[vertices]){
                if(!check[no]){
                    DFSUtil(no, check);
                }
            }
        }
    }

    //########################################################################//


}
