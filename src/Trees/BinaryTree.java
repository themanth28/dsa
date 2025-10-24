package Trees;

import java.util.Scanner;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinaryTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        populate(sc);
        display();
    }

    private static Node root;

    public static void populate(Scanner scanner){
        System.out.println("Enter the root: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }

    public static void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public static void display() {
        display(root, "");
    }

    private static void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

}
