public class BinarySearchTree {
    
    public BinarySearchTree() {
        root = null;
    }

    public void insert(int x) {
        root = insert(x, root);
    }

    public void remove(int x) {
        root = remove(x, root);
    }

    public boolean search(int x) {
        return search(x, root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printInOrder() {
        if (isEmpty()) 
            System.out.println("Empty tree");
         else 
            printInOrder(root);
    }
    
    private BinaryNode insert(int x, BinaryNode t) {
        if (t == null) 
            return new BinaryNode(x, null, null);

        if (x < t.element) 
            t.left = insert(x, t.left);
        else if (x > t.element) 
            t.right = insert(x, t.right);
        else
            ;  // Duplicate; do nothing
        return t;
    }

    private BinaryNode remove(int x, BinaryNode t) {
        if (t == null) 
            return t;   // Item not found; do nothing

        if (x < t.element) 
            t.left = remove(x, t.left);
        else if (x > t.element) 
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else 
            t = (t.left != null) ? t.left : t.right;
        
        return t;
    }
    
    private BinaryNode findMin(BinaryNode t) {
        if (t == null) 
            return null;
        else if (t.left == null) 
            return t;
 
        return findMin(t.left);
    }

    private boolean search(int x, BinaryNode t) {
        if (t == null) 
            return false;

        if (x < t.element)
            return search(x, t.left);
        else if (x > t.element) 
            return search(x, t.right);
         else 
            return true;    // Match
    }

    private void printInOrder(BinaryNode t) {
        if (t != null) {
            printInOrder(t.left);
            System.out.println(t.element);
            printInOrder(t.right);
        }
    }

    // Basic node private static inner class
    private static class BinaryNode {
        // Constructors

        BinaryNode(int theElement) {
            this(theElement, null, null);
        }

        BinaryNode(int theElement, BinaryNode lt, BinaryNode rt) {
            element = theElement;
            left    = lt;
            right   = rt;
        }

        int        element;  // The data in the node
        BinaryNode left;     // Left child
        BinaryNode right;    // Right child
    }

    private BinaryNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(29);
        bst.insert(45);
        bst.insert(13);
        bst.insert(7);
        bst.remove(13);
        
        if (bst.search(45))
           System.out.println("BST contains 45");
    }
}  // End BinarySearchTree Class