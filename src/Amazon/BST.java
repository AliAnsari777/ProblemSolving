package Amazon;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public static void main(String[] args) {

        Node tree;

        //*******************************************************//
        insert(10);
        insert(5);
        insert(7);
        insert(3);
        insert(20);
        insert(25);
        insert(17);
        //*******************************************************//
        System.out.print("Does tree has number 7: ");
        System.out.println(search(7));

        //*******************************************************//
//        remove(root,10, null);

        //*******************************************************//
        System.out.print("Is this tree a valid BST: ");
        System.out.println(validateBST(root));

        //*******************************************************//
        List<Integer> result = new ArrayList<>();
        System.out.println("Traversing tree in order: ");
        result = traversInOrder(root, result);
        System.out.println(result.toString());

    }

    //############################################################//

    // helper class for saving value and link to child nodes
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

    static Node root = new Node();

    //############################################################//

    // Average: time O(log(n)) | space O(1)
    // Worst:   time O(n) | space O(1)
    static Node insert(int value){
        if(root.value == 0) {
            root = new Node(value);
            return root;
        }

        Node temp = root;
        while (true){
            if(value < temp.value){
                if (temp.left == null){
                    temp.left = new Node(value);
                    break;
                }else {
                    temp = temp.left;
                }
            }else {
                if(temp.right == null){
                    temp.right = new Node(value);
                    break;
                }else {
                    temp = temp.right;
                }
            }
        }

        return temp;
    }

    //############################################################//

    // Average: time O(log(n)) | space O(1)
    // Worst:   time O(n) | space O(1)
    static boolean search(int value){
        if (root.value == 0)
            return false;

        Node temp = root;
        while (temp != null){
            if (value < temp.value)
                temp = temp.left;
            else if(value > temp.value)
                temp = temp.right;
            else
                return true;
        }

        return false;
    }

    //############################################################//

    // Average: time O(log(n)) | space O(1)
    // Worst:   time O(n) | space O(1)
    static void remove(Node currentNode, int value, Node parent){
        Node temp = currentNode;

        //first find the value
        while(temp != null){
            if(value < temp.value){
                parent = temp;
                temp = temp.left;
            }else if(value > temp.value){
                parent = temp;
                temp = temp.right;
            }else{ // now we find the value and want to remove it
                if(temp.left != null && temp.right != null){ // this is the case when node has two child.
                    temp.value = getMinValue(temp.right);
                    remove(temp.right, temp.value, temp);
                }else if(parent == null){
                    if(temp.left != null){
                        temp.value = temp.left.value;
                        temp.right = temp.left.right;
                        temp.left = temp.left.left;
                    }else if (temp.right != null){
                        temp.value = temp.right.value;
                        temp.left = temp.right.left;
                        temp.right = temp.right.right;
                    }else {
                        root = null;
                    }
                }else if (parent.left == temp){
                    if (temp.left != null){
                        parent.left = temp.left;
                    }else {
                        parent.left = temp.right;
                    }
                }else if(parent.right == temp){
                    if(temp.left != null)
                        parent.right = temp.left;
                    else
                        parent.right = temp.right;
                }
                break;
            }
        }
    }

    static int getMinValue(Node right){
        while (right.left != null){
            right = right.left;
        }
        return right.value;
    }

    //############################################################//

    // time O(n) | space O(d)
    static boolean validateBST(Node tree){
        return helperValidator(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helperValidator(Node tree, int minValue, int maxValue) {
        if (tree == null)
            return true;

        if (tree.value < minValue || tree.value > maxValue)
            return false;

        boolean leftValid = helperValidator(tree.left, minValue, tree.value);
        boolean rightValid = helperValidator(tree.right, tree.value, maxValue);

        return  leftValid && rightValid;
    }

    //############################################################//

    // Time O(n) | space O(n)/O(d)
    // if we just display the result and don't save it in an array then the space will be O(d) which is depth of the
    // tree and it is because we put that much callback in callback stack.
    static List<Integer> traversInOrder(Node tree, List<Integer> result){
        if (tree != null){
            traversInOrder(tree.left, result);
            result.add(tree.value);
            traversInOrder(tree.right, result);
        }
        return result;
    }

    static List<Integer> traversPreOrder(Node tree, List<Integer> result){
        if (tree != null){
            result.add(tree.value);
            traversPreOrder(tree.left,result);
            traversPreOrder(tree.right, result);
        }
        return result;
    }

    static List<Integer> traversPostOrder(Node tree, List<Integer> result){
        if (tree != null){
            traversPostOrder(tree.left, result);
            traversPostOrder(tree.right, result);
            result.add(tree.value);
        }
        return result;
    }
}
