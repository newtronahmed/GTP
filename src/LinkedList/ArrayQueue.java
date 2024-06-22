package LinkedList;

class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        System.out.println(arrayQueue.dequeue());  // Output: 10
        System.out.println(arrayQueue.peek());     // Output: 20
    }
}

