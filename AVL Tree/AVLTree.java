public class AVLTree extends BinarySearchTree {

    public AVLTree() {
        super();
    }

    public void add(int newEntry) {
        
        if (isEmpty()) 
            setRootNode(new BinaryNode(newEntry));
        else {
            BinaryNode rootNode = getRootNode();
            addEntry(rootNode, newEntry);
            setRootNode(rebalance(rootNode));
        }
    }

    private void addEntry(BinaryNode rootNode, int newEntry) {

        if (newEntry < rootNode.getData()) {
            if (rootNode.hasLeftChild()) {
                BinaryNode leftChild = rootNode.getLeftChild();
                addEntry(leftChild, newEntry);
                rootNode.setLeftChild(rebalance(leftChild));
            } else 
                rootNode.setLeftChild(new BinaryNode(newEntry));
        } else if (rootNode.hasRightChild()) {
            BinaryNode rightChild = rootNode.getRightChild();
            addEntry(rightChild, newEntry);
            rootNode.setRightChild(rebalance(rightChild));
        } else 
            rootNode.setRightChild(new BinaryNode(newEntry));
    }  

    private BinaryNode rebalance(BinaryNode nodeN) {
        int heightDifference = getHeightDifference(nodeN);

        if (heightDifference > 1) { // left subtree is taller by more than 1, 
            // so addition was in left subtree
            if (getHeightDifference(nodeN.getLeftChild()) > 0) // addition was in left subtree of left child
                nodeN = rotateRight(nodeN);
            else // addition was in right subtree of left child
                nodeN = rotateLeftRight(nodeN);
        } else if (heightDifference < -1) { // right subtree is taller by more than 1, 
            // so addition was in right subtree
            if (getHeightDifference(nodeN.getRightChild()) < 0) // addition was in right subtree of right child
                nodeN = rotateLeft(nodeN);
            else // addition was in left subtree of right child
                nodeN = rotateRightLeft(nodeN);
        } // end if
        // else nodeN is balanced

        return nodeN;
    }  

    private BinaryNode rotateRight(BinaryNode nodeN) {
        BinaryNode nodeC = nodeN.getLeftChild();
        nodeN.setLeftChild(nodeC.getRightChild());
        nodeC.setRightChild(nodeN);
        return nodeC;
    } 

    private BinaryNode rotateLeft(BinaryNode nodeN) {
        BinaryNode nodeC = nodeN.getRightChild();
        nodeN.setRightChild(nodeC.getLeftChild());
        nodeC.setLeftChild(nodeN);
        return nodeC;
    }  

    private BinaryNode rotateRightLeft(BinaryNode nodeN) {
        BinaryNode nodeC = nodeN.getRightChild();
        nodeN.setRightChild(rotateRight(nodeC));
        return rotateLeft(nodeN);
    }  

    private BinaryNode rotateLeftRight(BinaryNode nodeN) {
        BinaryNode nodeC = nodeN.getLeftChild();
        nodeN.setLeftChild(rotateLeft(nodeC));
        return rotateRight(nodeN);
    }  

    private int getHeightDifference(BinaryNode node) {
        BinaryNode left = node.left;
        BinaryNode right = node.right;

        int leftHeight, rightHeight;

        if (left == null) 
            leftHeight = 0;
        else 
            leftHeight = left.getHeight();

        if (right == null) 
            rightHeight = 0;
       else 
            rightHeight = right.getHeight();

        return leftHeight - rightHeight;
    }  

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        avl.add(60);
        avl.add(50);
        avl.add(20);
        
        System.out.println("AVL root node data is: " + 
                           avl.getRootNode().getData());
    }
}  // end AVLTree Class
