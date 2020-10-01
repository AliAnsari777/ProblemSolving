package Amazon;

public class BST {

    public static void main(String[] args) {

        Node tree;

        //*******************************************************//
        insert(10);
        insert(5);
        insert(7);
        insert(3);
        insert(20);

        //*******************************************************//
        System.out.print("Does tree has number 7: ");
        System.out.println(search(7));

        //*******************************************************//
//        remove(root,10, null);

        //*******************************************************//
        System.out.print("Is this tree a valid BST: ");
        System.out.println(validateBST(root));

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
}
