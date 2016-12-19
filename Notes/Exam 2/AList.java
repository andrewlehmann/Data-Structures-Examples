// AList array based List JAVA
public class AList {
   
    private int[] list;                     // array of list entries
    private int   length;                   // current number of entries in list
    private static final int MAX_SIZE = 50; // max length of list 

    public AList(int maxSize) {                                  // Constructor
        list   = new int[maxSize]; 
        length = 0;
    } 

    public boolean isFull() {                                      // isFull
        return length == MAX_SIZE;
    } 

    // add at the end
    public boolean add(int newEntry) {                            // add at end
        boolean isSuccessful = true;

        if (!isFull()) {
            list[length] = newEntry;
            length++;
        } else 
            isSuccessful = false;

        return isSuccessful;
    } 

    // newPosition is one based. i.e., is the 1st to length position
    public boolean add(int newPosition, int newEntry) {    //  add at position
        boolean isSuccessful = true;

        if (!isFull() && (newPosition >= 1) && (newPosition <= length + 1)) {
            for (int i = length; i >= newPosition; i--)   // make room
                list[i] = list[i - 1];   //move the elements down
            
            list[newPosition - 1] = newEntry;
            length++;
        } else 
            isSuccessful = false;
        
        return isSuccessful;
    } 

    public boolean isEmpty() {                                   // isEmpty
        return length == 0;
    } 

    // givenPosition is one based. i.e., is the 1st to length position
    public int remove(int givenPosition) {                       // remove
        int result = 0; // return value

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            result = list[givenPosition - 1]; // get entry to be removed

            // move subsequent entries toward entry to be removed, unless last 
            if (givenPosition < length) {            
                for (int i = givenPosition; i < length - 1; i++) {
                    list[i] = list[i + 1];
                }
            }

            length--;
        }  

        return result; // return reference to removed entry, or null
    } 

    // givenPosition is one based. i.e., is the 1st to length position
    public boolean replace(int givenPosition, int newEntry) {   // replace
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= length)) // test catches empty list
            list[givenPosition - 1] = newEntry;
        else 
            isSuccessful = false;
   
        return isSuccessful;
    } 

    public int getLength() {                                     // getLength
        return length;
    } 
    
    // givenPosition is one based. i.e., is the 1st to length position
    public int getEntry(int givenPosition) {                     //  getEntry
        int result = 0;                        // result to return

        if ((givenPosition >= 1) && (givenPosition <= length)) 
            result = list[givenPosition - 1];
        
        return result;
    } 

    public boolean contains(int anEntry) {                      // contains
        boolean found = false;

        for (int index = 0; !found && (index < length); index++) {
            if (anEntry == list[index]) 
                found = true;
        }

        return found;
    } 

    public void display() {                                     // display
        for (int index = 0; index < length; index++) 
            System.out.println(list[index]);
    } 

    public static void main(String[] args) {
        
        AList list = new AList(50);
        
        list.add(16); // winner
        list.add(4);  // second place
        list.add(33); // third place
        list.add(27); // fourth place
        list.add(5);
        list.add(3,1);

        list.display();
    }  
} // end AList