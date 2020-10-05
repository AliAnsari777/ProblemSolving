public class HackerRankTree {
    public static void main(String[] args) {

    }

    static class Node{
        int value;
        Node right, left;
        public Node(){}

        public Node(int value){
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    static Node root;
    public HackerRankTree(){
        root = null;
    }


    static void insert(int value){
        root = insertNode(root, value);
    }
    // average: time O(log(n)) | space O(1)
    // Worst:   time O(n) | space O(1)
    static Node insertNode(Node node, int value){
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value)
            node.left = insertNode(node.left, value);
        else if(value > node.value)
            node.right = insertNode(node.right, value);

        return node;
    }
}
