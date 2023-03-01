package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    static BinaryTree binaryTree;

    @BeforeEach
    void init() {
        binaryTree = new BinaryTree();
    }

    @Test
    void checkInsertNode() {
        binaryTree.insert(8);
        assertEquals(8, binaryTree.find(8).getValue());
        binaryTree.insert(10);
        assertEquals(10, binaryTree.find(10).getValue());
        binaryTree.insert(3);
        assertEquals(3, binaryTree.find(3).getValue());
    }

    @Test
    void checkRemoveNode() {
        binaryTree.remove(11);
        assertNull(binaryTree.find(11));
        fillTree();
        binaryTree.remove(8);
        assertNull(binaryTree.find(8));
        binaryTree.remove(14);
        assertNull(binaryTree.find(14));
        binaryTree.remove(13);
        assertNull(binaryTree.find(13));
        binaryTree.remove(3);
        assertNull(binaryTree.find(3));
    }

    @Test
    void checkFindNode() {
        assertNull(binaryTree.find(0));
        fillTree();
        assertNull(binaryTree.find(0));
        assertEquals(4, binaryTree.find(4).getValue());
        assertEquals(7, binaryTree.find(7).getValue());
    }

    @Test
    void checkInsertOrder() {
        assertEquals("[]", binaryTree.traverseLevelOrder().toString());
        fillTree();
        assertEquals("[8, 3, 10, 1, 6, 14, 4, 7, 13]", binaryTree.traverseLevelOrder().toString());
        binaryTree.remove(13);
        assertEquals("[8, 3, 10, 1, 6, 14, 4, 7]", binaryTree.traverseLevelOrder().toString());
        binaryTree.remove(1);
        assertEquals("[8, 3, 10, 6, 14, 4, 7]", binaryTree.traverseLevelOrder().toString());
        binaryTree.remove(3);
        assertEquals("[8, 6, 10, 4, 7, 14]", binaryTree.traverseLevelOrder().toString());
        binaryTree.insert(5);
    }

    void fillTree() {
        binaryTree.insert(8);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(14);
        binaryTree.insert(13);
        binaryTree.traverseLevelOrder();
    }
}
