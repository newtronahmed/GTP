package LinkedList;

class NodeStack {
    int value;
    NodeStack next;

    public NodeStack(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedListStack {
    private NodeStack head;
    private int size;

    public LinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(int item) {
        NodeStack newNode = new NodeStack(item);
        head = newNode;

        newNode.next = head;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int poppedValue = head.value;
        head = head.next;
        size--;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(10);
        linkedListStack.push(20);
        System.out.println(linkedListStack.pop());  // Output: 20
        System.out.println(linkedListStack.peek()); // Output: 10
    }
}

