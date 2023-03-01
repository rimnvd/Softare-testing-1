package task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void insert(int value) {
        root = insertNodeRecursive(root, value);
    }

    public Node find(int value) {
        return findNodeRecursive(root, value);
    }

    public void remove(int value) {
        root = removeNodeRecursive(root, value);
    }

    private Node insertNodeRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertNodeRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertNodeRecursive(current.right, value);
        }
        return current;
    }

    private Node findNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            return current;
        }
        return value < current.value ? findNodeRecursive(current.left, value) : findNodeRecursive(current.right, value);
    }

    private Node removeNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findMinValue(current.right);
            current.value = smallestValue;
            current.right = removeNodeRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = removeNodeRecursive(current.left, value);
            return current;
        }
        current.right = removeNodeRecursive(current.right, value);
        return current;
    }

    private int findMinValue(Node root) {
        return root.left == null ? root.value : findMinValue(root.left);
    }

    public ArrayList<Integer> traverseLevelOrder() {
        ArrayList<Integer> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(" " + node.value);
            nodeList.add(node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        System.out.println();
        return nodeList;
    }
}
