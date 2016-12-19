public class AQueue {

    private int[] queue; // circular array of queue entries and one unused
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public AQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public AQueue(int initialCapacity) {
        queue = new int[initialCapacity + 1];
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    public void enqueue(int newEntry) {
        if (!isFull()) {

            backIndex = (backIndex + 1) % queue.length;
            queue[backIndex] = newEntry;
        }
    }

    public int front() {
        int front = 0;

        if (!isEmpty()) {
            front = queue[frontIndex];
        }

        return front;
    }

    public int dequeue() {
        int front = 0;

        if (!isEmpty()) {
            front = queue[frontIndex];
            queue[frontIndex] = 0;
            frontIndex = (frontIndex + 1) % queue.length;
        }

        return front;
    }

    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    private boolean isFull() {
        return frontIndex == ((backIndex + 2) % queue.length);
    }

    public void clear() {
        
        if (!isEmpty()) {
            for (int index = frontIndex; index != backIndex; 
                                       index = (index + 1) % queue.length) {
                queue[index] = 0;
            }

            queue[backIndex] = 0;
        }

        frontIndex = 0;
        backIndex = queue.length - 1;
    }

    public static void main(String argv[]) {
        AQueue queue = new AQueue();

        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(8);

        System.out.println("The front of the queue contains: " + queue.front());
    }
}  // end AQueue