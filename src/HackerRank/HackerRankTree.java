package HackerRank;

import AlgoExpert.Easy.FindClosestValueInBST;

import java.util.*;

public class HackerRankTree {
    public static void main(String[] args) {
        insert(47);
        insert(2);
        insert(40);
        insert(20);
        insert(38);
        insert(30);
        insert(14);
        insert(28);
        insert(10);

//        insert(16);
//        insert(19);
//        insert(44);
//        insert(39);
//        insert(27);
//        insert(7);
//        insert(9);
//        insert(31);
//        insert(12);
//
//        insert(43);
//        insert(21);
//        insert(5);
//        insert(41);
//        insert(34);
//        insert(49);
//        insert(13);
//        insert(33);
//        insert(3);
//
//        insert(4);
//        insert(25);
//        insert(22);
//        insert(29);
//        insert(15);
//        insert(32);
//        insert(35);
//        insert(6);
//        insert(24);
//
//        insert(23);
//        insert(26);
//        insert(1);
//        insert(11);
//        insert(42);
//        insert(36);
//        insert(37);
//        insert(17);
//        insert(18);
//
//        insert(8);
//        insert(45);
//        insert(48);
//        insert(50);
//        insert(46);
        //*******************************************************//

//        System.out.println("\nHeight of the tree");
//        System.out.println(height(root));

        //*******************************************************//

//        System.out.println("\nPrint tree level order: ");
//        levelOrder(root);

        //*******************************************************//

        System.out.println("\n\nPrint Each Level of Tree:");
        printTree(root);

        //*******************************************************//
//        System.out.println("\nTree Top View: ");
//        topView(root);

        //*******************************************************//

        System.out.println("Closest value in BST: ");
        FindClosestValueInBST bst = new FindClosestValueInBST();
        System.out.println(bst.FindClosestValue(root, 15));

        System.out.println("Closest value in BST Iterative:");
        System.out.println(bst.FindClosestValueIterative(root, 11));
    }

    //================================================================//

    public static class Node{
        public int value;
        public Node right, left;
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

    //############################################################//

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

    //############################################################//

    static int height(Node root) {

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = 1 + height(root.left);
        }

        if (root.right != null) {
            rightHeight = 1 + height(root.right);
        }

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    //############################################################//

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            System.out.print(temp.value + " ");
            if(temp.left != null)
                queue.add(temp.left);

            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    //############################################################//

    // print all tree with help of "printEachLevel" method.
    static void printTree(Node root){
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            printEachLevel(root, i);
            System.out.println();
        }
    }

    // print each level of a binary tree
    static void printEachLevel(Node root, int height){
        if (root == null)
            return;
        if(height == 0)
            System.out.print(root.value + " ");
        else if(height >= 1){
            printEachLevel(root.left, height-1);
            printEachLevel(root.right, height-1);
        }
    }

    //############################################################//

    public static void topView(Node root) {

        class QueueObj{
            Node node;
            int level;

            public QueueObj(Node n, int l){
                node = n;
                level = l;
            }
        }
        Map<Integer, Node> checking = new TreeMap<>();
        Queue<QueueObj> queue = new LinkedList<>();

        if(root == null)
            return;
        else {
            queue.add(new QueueObj(root, 0));
        }

        while(!queue.isEmpty()){
            QueueObj temp = queue.poll();

            if(!checking.containsKey(temp.level)){
                checking.put(temp.level, temp.node);
            }

            if (temp.node.left != null)
                queue.add(new QueueObj(temp.node.left, temp.level - 1));
            if(temp.node.right != null)
                queue.add(new QueueObj(temp.node.right, temp.level + 1));
        }

        for(Map.Entry<Integer, Node> value : checking.entrySet()){
            System.out.print(value.getValue().value + " ");
        }
    }
}
