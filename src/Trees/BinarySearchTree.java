package Trees;

public class BinarySearchTree {

    static class BSTNode{
        private final int value;
        private BSTNode left;
        private BSTNode right;
        private int height;

        private BSTNode(int value){
            this.value = value;
        }

        private int getValue(){
            return value;
        }
    }

    private static BSTNode root;

    private BinarySearchTree(){

    }

    public static int height(BSTNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public static void insert(int value) {
        root = insert(value, root);
    }

    private static BSTNode insert(int value, BSTNode node) {
        if (node == null) {
            node = new BSTNode(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public static void populate(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
    }

    public static void display() {
        display(root, "Root Node: ");
    }

    private static void display(BSTNode node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,7,1,6,9,8,0};
        populate(nums);
        display();
        System.out.println(root.value);
    }

}
