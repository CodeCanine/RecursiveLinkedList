class RecursiveLinkedList {

    private static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    private Node reverseUtil(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
            /* Update next to prev node */
            curr.next = prev;
            return head;
        }

        /* Save curr->next node for recursive call */
        Node next = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next, curr);
        return head;
    }

    public static void main(String[] args) {
        RecursiveLinkedList list = new RecursiveLinkedList();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original Linked list ");
        list.printList(head);

        Node res = list.reverseUtil(head, null);

        System.out.println("\n\nReversed linked list ");
        list.printList(res);
    }
} 