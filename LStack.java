//LStack linked based Stack JAVA VH
public class LStack {
    
    private Node topNode; // references the first node in the chain
    
    public LStack() {
        topNode = null;
    }

    public void push(int newEntry) {
        Node newNode = new Node(newEntry, null);
        
        newNode.next = topNode;
        topNode      = newNode;
    }

    // return -999 if stack is empty
    public int peek() {
        int top = -999;

        if (topNode != null) 
            top = topNode.getData();

        return top;
    }

    public int pop() {
        int top = peek();

        if (topNode != null) 
            topNode = topNode.next;

        return top;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    private class Node {

        private int data; // entry in stack
        private Node next; // link to next node

        private Node(int dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(int dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private int getData() {
            return data;
        } // end getData

        private void setData(int newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node

    public static void main(String argv[]) {
        
        LStack stack = new LStack();

        stack.push(5);
        stack.push(7);
        stack.push(8);

        System.out.println("The top of the stack contains: " + stack.peek());
    }
} // end LStack