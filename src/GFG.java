import java.util.*;

public class GFG {
    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2, 3);
        graph.add(3, 2);

        graph.BFS(2);
        graph.BFS(3);

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

            System.out.println("\nGraph Traversing start from: " + startPoint);
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
    }

    //########################################################################//


}
