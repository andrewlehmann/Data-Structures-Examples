public class BinaryNode {

    int element;  // The data in the node
    BinaryNode left;     // Left child
    BinaryNode right;    // Right child

    BinaryNode(int theElement) {
        this(theElement, null, null);
    }

    BinaryNode(int theElement, BinaryNode lt, BinaryNode rt) {
        element = theElement;
        left = lt;
        right = rt;
    }

    public int getData() {
        return element;
    }

    public void setData(int newData) {
        element = newData;
    }

    public BinaryNode getLeftChild() {
        return left;
    }

    public BinaryNode getRightChild() {
        return right;
    }

    public void setLeftChild(BinaryNode leftChild) {
        left = (BinaryNode) leftChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        right = (BinaryNode) rightChild;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public int getHeight() {
        return getHeight(this); // call private getHeight
    } 

    private int getHeight(BinaryNode node) {
        int height = 0;

        if (node != null) {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        return height;
    }
} // end BinaryNode Class
