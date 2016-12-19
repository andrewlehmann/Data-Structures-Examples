//AStack array based Stack JAVA VH
public class AStack {

    private int[]            stack;                  // array of stack entries
    private int              topIndex;               // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public AStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public AStack(int initialCapacity) {
        stack = new int[initialCapacity];
        topIndex = -1;
    }

    public void push(int newEntry) {
   

        if (!isFull()) {
            topIndex++;
            stack[topIndex] = newEntry;
        } 
    }

    // return -999 if stack is empty
    public int peek() {
        int top = -999;

        if (!isEmpty()) 
            top = stack[topIndex];
     
        return top;
    }

    public int pop() {
        int top = peek();

        if (!isEmpty()) {
            top             = stack[topIndex];
            stack[topIndex] = 0;
            topIndex        = topIndex - 1;      
        }

        return top;
    }

    public boolean isEmpty() {
        return (topIndex < 0);
    }

    public boolean isFull() {
        return (topIndex == DEFAULT_INITIAL_CAPACITY);
    }
    
    public static void main(String argv[]) {
        
        AStack stack = new AStack();

        stack.push(5);
        stack.push(7);
        stack.push(8);

        System.out.println("The top of the stack contains: " + stack.peek());
    }
    
} // end AStack
