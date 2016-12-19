//LList linked based List JAVA VH
public class LList {       // LList Class

    private Node firstNode;     // reference to first node
    private int  length;  	// number of entries in list

    public LList() {                      // default constructor
        firstNode = null;
        length    = 0;
    } 

    public boolean add(int newEntry) {    // add - insertLast
        Node newNode = new Node(newEntry);

        if (firstNode == null)            // add to an empty list
            firstNode = newNode;
        else {                            // add to end of nonempty list
            Node lastNode = getNodeAt(length);
            lastNode.next = newNode;      // make last node reference new node
        }  
        length++;

        return true;
    }  

    // newPosition is one based. i.e., is the 1st to length position
    public boolean add(int newPosition, int newEntry) {   // add at position
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= length + 1)) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
                newNode.next = firstNode;
                firstNode = newNode;
            } else {                             // case 2: list non empty & newPosition > 1
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            }  

            length++;
        } else 
            isSuccessful = false;

        return isSuccessful;
    } 

    public boolean isEmpty() {                // isEmpty
        return firstNode == null;
    } 

    public int getLength() {                  // getLength
        return length;
    } 

    public boolean contains(int anEntry) {    // contains
        boolean found    = false;
        Node currentNode = firstNode;

        while ((currentNode != null) && !found) {
            if (anEntry == currentNode.data) 
                found = true;
            else 
                currentNode = currentNode.next;
        }  

        return found;
    } 

    public void display() {                   // display
        Node currentNode = firstNode;
 
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }   
    } 
    
    // givenPosition is one based. i.e., is the 1st to length position
    public int remove(int givenPosition) {     // remove
        int result = 0;         // return value

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            if (givenPosition == 1) {         // case 1: remove first entry
                result = firstNode.data;      // save entry to be removed 
                firstNode = firstNode.next;
            } 
            else {                          // case 2: givenPosition > 1
                Node nodeBefore   = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.next;
                Node nodeAfter    = nodeToRemove.next;
                nodeBefore.next   = nodeAfter; // disconnect the node to remove
               
                result = nodeToRemove.data;  // save entry to be removed
            }  
            
            length--;
        }  

        return result;    // return removed entry, or null if operation fails
    } 

    // givenPosition is one based. i.e., is the 1st to length position     
    public int getEntry(int givenPosition) {     // getEntry
        int result = 0;  // result to return

        if ((givenPosition >= 1) && (givenPosition <= length)) 
            result = getNodeAt(givenPosition).data;

        return result;
    } 

    private Node getNodeAt(int givenPosition) {   // getNodeAt
        Node currentNode = firstNode;

        for (int counter = 1; counter < givenPosition; counter++) 
            currentNode = currentNode.next;

        return currentNode;
    } 

    private class Node {                           // Node

        private int  data;   // entry in list
        private Node next;   // link to next node

        private Node(int dataPortion) {                // constructor
            data = dataPortion;
            next = null;
        } 

        private Node(int dataPortion, Node nextNode) {  // constructor
            data = dataPortion;
            next = nextNode;
        } 
    } 

    public static void main(String[] args) {
        
        LList list = new LList();
       
        list.add(16); // winner
        list.add(4);  // second place
        list.add(33); // third place
        list.add(27); // fourth place

        list.display();

    } // end main
} // end LList