package ground;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Binary Search Tree Tests.
 *
 * @author Vladimir Livin
 */
public class BinarySearchTreeTest {
    public static class BinaryTreeNode {
        public int key;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int key, BinaryTreeNode left, BinaryTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        /** Speed: O(N); Memory = O(h), h - BST depth. */
        public boolean isBST() {
            return isBSTInBounds(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static boolean isBSTInBounds(BinaryTreeNode node, int min, int max) {
            return
                (node.key >= min) && (node.key <= max) &&
                (node.left != null && isBSTInBounds(node.left, min, node.key) || node.left == null) &&
                (node.right != null && isBSTInBounds(node.right, node.key, max) || node.right == null);
        }
    }

    public static BinaryTreeNode n(int key, BinaryTreeNode left, BinaryTreeNode right) {
        return new BinaryTreeNode(key, left, right);
    }

    public static BinaryTreeNode n(int key) {
        return n(key, null, null);
    }

    @Test
    public void sample1ShouldBeNotBst() {
        BinaryTreeNode t =
            n(10,
                n(5,
                    n(4), n(11)),
                n(20,
                    n(15), n(25)));

        assertFalse("This BT is not BST because 11 > 10", t.isBST());
    }

    @Test
    public void sample2ShouldBeBst() {
        BinaryTreeNode t =
            n(10,
                n(5,
                    n(4), n(8)),
                n(20,
                    n(15), n(25)));

        assertTrue(t.isBST());
    }
}
