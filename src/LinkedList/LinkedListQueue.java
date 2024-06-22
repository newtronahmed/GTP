package LinkedList;

class LinkedListNode {
    int value;
    LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedListQueue {
    private LinkedListNode front;
    private LinkedListNode rear;
    private int size;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int item) {
        LinkedListNode newNode = new LinkedListNode(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int dequeuedValue = front.value;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        System.out.println(linkedListQueue.dequeue());  // Output: 10
        System.out.println(linkedListQueue.peek());     // Output: 20
    }
}

