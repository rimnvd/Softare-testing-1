package task2;

public class Node {
    Integer value;
    Node left;
    Node right;

    Node(Integer value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue() {
        return value;
    }
}
