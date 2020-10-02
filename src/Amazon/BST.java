package Amazon;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public static void main(String[] args) {

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
        System.out.print("\nIs this tree a valid BST: ");
        System.out.println(validateBST(root));

        //*******************************************************//
        List<Integer> result = new ArrayList<>();
        System.out.println("\nTrmidrsing tree in order: ");
        result = traverseInOrder(root, result);
        System.out.println(result.toString());

        //*******************************************************//
        System.out.println("\nTrmidrsing tree pre order: ");
        result.removeAll(result);
        result = traversePreOrder(root, result);
        System.out.println(result.toString());

        //*******************************************************//
        System.out.println("\nTrmidrsing tree post order: ");
        result.removeAll(result);
        result = traversePostOrder(root, result);
        System.out.println(result.toString());

        //*******************************************************//
        System.out.println("\nMin Height BST: ");
        int[] numbers = {1, 2, 5, 7, 10, 12, 15, 17};
        Node MinBST = minHeightBST(numbers);

        List printTree = new ArrayList();
        printTree = traverseInOrder(MinBST, printTree);
        System.out.println(printTree.toString());

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

    static Node root;
    public BST(){
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
        // when we do insert without Node as parameter
//        Node temp = root;
//        while (true){
//            if(value < temp.value){
//                if (temp.left == null){
//                    temp.left = new Node(value);
//                    break;
//                }else {
//                    temp = temp.left;
//                }
//            }else {
//                if(temp.right == null){
//                    temp.right = new Node(value);
//                    break;
//                }else {
//                    temp = temp.right;
//                }
//            }
//        }
//
//        return temp;
    }

    //############################################################//

    // midrage: time O(log(n)) | space O(1)
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

    // midrage: time O(log(n)) | space O(1)
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
    static List<Integer> traverseInOrder(Node tree, List<Integer> result){
        if (tree != null){
            traverseInOrder(tree.left, result);
            result.add(tree.value);
            traverseInOrder(tree.right, result);
        }
        return result;
    }

    static List<Integer> traversePreOrder(Node tree, List<Integer> result){
        if (tree != null){
            result.add(tree.value);
            traversePreOrder(tree.left,result);
            traversePreOrder(tree.right, result);
        }
        return result;
    }

    static List<Integer> traversePostOrder(Node tree, List<Integer> result){
        if (tree != null){
            traversePostOrder(tree.left, result);
            traversePostOrder(tree.right, result);
            result.add(tree.value);
        }
        return result;
    }

    //############################################################//

    // Time O(n) | space O(n)
    static Node minHeightBST(int[] numbers){
        return constructMinHeightBST(numbers, 0, numbers.length-1);
    }

    static Node constructMinHeightBST(int[] arr, int start, int end){
        if (start > end)
            return null;

        int mid = Math.floorDiv(start+end, 2);
        Node node = new Node(arr[mid]);

        node.left = constructMinHeightBST(arr, start, mid-1);
        node.right = constructMinHeightBST(arr, mid+1, end);

        return node;
    }
}
