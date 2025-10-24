package Trees;

// Class to represent a single node in the binary tree
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Class to represent the binary tree itself
class BinaryTreeDS {
    TreeNode root;

    // Constructor to create a binary tree with a root, left, right, and an "additional" child
    public BinaryTreeDS(int rootData, int leftData, int rightData, int additionalChildData) {
        // Create the root node
        this.root = new TreeNode(rootData);
        
        // Create and set the left child
        this.root.left = new TreeNode(leftData);
        
        // Create and set the right child
        this.root.right = new TreeNode(rightData);
        
        // Add the additional child to the right child of the root
        this.root.right.left = new TreeNode(additionalChildData);
    }
}

// Main class to demonstrate the binary tree
public class Main {
    public static void main(String[] args) {
        // Create a binary tree using the specialized constructor
        BinaryTreeDS tree = new BinaryTreeDS(10, 20, 30, 40);
        tree.root.right.right.data = 50;
        
        System.out.println("A binary tree has been created.");
        System.out.println("Root node data: " + tree.root.data);
        System.out.println("Left child data: " + tree.root.left.data);
        System.out.println("Right child data: " + tree.root.right.data);
        System.out.println("Additional child data (left child of the right child): " + tree.root.right.left.data);
    }
}