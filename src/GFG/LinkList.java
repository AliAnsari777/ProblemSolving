package GFG;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.LinkedList;

public class LinkList{

    /* Driver function to test above methods */
    public static void main(String args[]) {
        LinkList llist = new LinkList();
        Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();
        System.out.println();

        //*******************************************************//
        Node delete = head.next.next;
        llist.deleteNode(head, delete);
        llist.printList();

        System.out.println();
        delete = head;
        llist.deleteNode(head, delete);
        llist.printList();

        //*******************************************************//

        LinkList list = new LinkList();

        list.a = new CharNode('g');
        list.a.next = new CharNode('e');
        list.a.next.next = new CharNode('e');
        list.a.next.next.next = new CharNode('k');
        list.a.next.next.next.next = new CharNode('s');
        list.a.next.next.next.next.next = new CharNode('b');

        list.b = new CharNode('g');
        list.b.next = new CharNode('e');
        list.b.next.next = new CharNode('e');
        list.b.next.next.next = new CharNode('k');
        list.b.next.next.next.next = new CharNode('s');
        list.b.next.next.next.next.next = new CharNode('c');

        System.out.println("\nCompare two list: ");
        System.out.println(list.compare(list.a, list.b));

        //*******************************************************//

        Node one = new Node();
        Node two = new Node();
        Node result;
        one.data = 9;
        one.next = new Node(9);
        one.next.next = new Node(9);

        two.data = 1;
        two.next = new Node(8);
//        two.next.next = new Node(8);
//        two.next.next.next = new Node(5);

        result = list.sumTwoList(one, two);
        System.out.println("\nSum of two list: ");
        while (result != null){
            System.out.print(result.data);
            result = result.next;
        }
    }

    //=================================================================//


    static Node head; // head of list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
        Node(){
        }
    }

    /* Character Linked list Node*/
    static class CharNode{
        char data;
        CharNode next;
        CharNode(char c){
            data = c;
            next = null;
        }
    }
    CharNode a, b;


    /*Utility functions*/

    /* Function to create a node */
    Node newNode(int data)
    {
        Node x = new Node(data);
        return x;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //########################################################################//

    /* function to insert a new_node in a list. */
    // Time = O(n) | Space = O(1)
    void sortedInsert(Node new_node)
    {
        Node current;

        /* Special case for head node */
        if (head == null || head.data >= new_node.data) {
            new_node.next = head;
            head = new_node;
        }
        else {
            /* Locate the node before point of insertion. */
            current = head;

            while (current.next != null && current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            current.next = new_node;
        }
    }

    //########################################################################//

    // Time = O(n) | Space = O(1)
    void deleteNode(Node head, Node node){
        // when the node to be delete is head node
        if(head == node){
            if (head.next == null)
                System.out.println("There is only one node and this list can't be empty");

            // copy data of next node to head
            head.data = head.next.data;
            // store address of next node
//            node = head.next;
            // remove link of next node
            head.next = head.next.next;
            System.gc();
            return;
        }

        Node pre = head;
        while (pre.next != null && pre.next != node)
            pre = pre.next;

        if (pre.next == null) {
            System.out.println("Node wasn't in this list");
            return;
        }

        pre.next = pre.next.next;

        System.gc();

        return;
    }

    //########################################################################//

    // Time O(n) | Space O(1)
    int compare(CharNode one, CharNode two){
        while (one != null && two != null){
            if (one.data > two.data)
                return 1;
            else if (one.data < two.data)
                return -1;

            one = one.next;
            two = two.next;
        }

        if (one == null && two != null)
            return -1;
        else if(one != null)
            return 1;
        else
            return 0;
    }

    //########################################################################//


    Node sumTwoList(Node a, Node b){
        int one, two;
        one = makeNumber(a, 0);
        two = makeNumber(b, 0);

        Node result = new Node();
        return createList(one+two, result);

    }

    // converting numbers in the list into a whole number
    int makeNumber(Node number, int val){
        if (number == null){
            return val;
        }

        val = val * 10 + number.data;
        return makeNumber(number.next, val);
    }

    // sum two numbers
    // in here we add number from right to left to the result list
    Node createList(int number, Node result){
        result.data = number%10;
        number /= 10;

        if (number <= 0 )
            return result;

        // create a new node and put it before the result node
        Node r = new Node();
        r.next = result;

        return createList(number, r);
    }
}
