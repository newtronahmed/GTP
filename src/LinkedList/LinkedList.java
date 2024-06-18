package LinkedList;

public class LinkedList {
    Node head;
    void insertAtEnd(int val) {
        // First create the node
        // if head is null, just set head to new node (by default node will point to null)
        // else, go to the last node(where node->next is null and insert the new node
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
        }else {
            Node temp = head;
            while(temp.next != null){
                temp  = temp.next;
            }
            temp.next= newNode;
        }

    }

    void display (){
        Node temp = head;
        while(temp != null){
            System.out.printf("%d-> ", temp.val);
            temp = temp.next;
        }
        System.out.print("null");
    }
    void reverse (){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            // store next node
            next = current.next;
            // reverse current node
            current.next = prev;

            // set prev to current
            prev = current;
            current = next;

        }
        //
        head = prev;
    }

    void deleteAtPosition (int position){
        Node current = head;
        Node next = null;

        // if head is empty,
        if (head == null){
            System.out.println("The list is emtpy");
            return;
        }
        if(position == 0){
            // if we want to delete the first element, just point head to the second element
            head = current.next;
            return;
        }
        // find the node before the position we want to delete
        for (int i = 0; i < (position - 1) && current != null; i++){
            current = current.next;
        }
        // if current.next == null, we are on the last element
        // if current is null, we are really out of bounds
        if (current == null || current.next == null){
            System.out.println("Position is out of bounds");
            return;
        }
        // delete current.next, the node we want to delete
        next = current.next.next;
        current.next = next;

    }

}
