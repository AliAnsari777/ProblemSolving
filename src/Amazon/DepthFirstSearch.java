package Amazon;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Vertix graph = new Vertix('A');
        Vertix newGraph = new Vertix();

        graph.add(graph, 'B');
        graph.add(graph, 'C');
        graph.add(graph, 'D');

        graph.add(graph.children.get(0), 'E');
        graph.add(graph.children.get(0), 'F');
        graph.add(graph.children.get(2), 'G');
        graph.add(graph.children.get(2), 'H');

        List<Character> result = new ArrayList<>();
        result = DFS(graph, result);
        System.out.println(result.toString());
    }

    static class Vertix{
        List<Vertix> children;
        char name;

        public Vertix(){
            children = new ArrayList<>();
        };
        public Vertix(char n){
            name = n;
            children = new ArrayList<>();
        }

        public void add(Vertix graph, char name){
            graph.children.add(new Vertix(name));
        }
    }

    public static List<Character> DFS(Vertix graph, List<Character> result){
        result.add(graph.name);

        for(Vertix v : graph.children){
            DFS(v, result);
        }
        return result;
    }
}
