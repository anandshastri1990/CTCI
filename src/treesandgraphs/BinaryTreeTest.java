package treesandgraphs;


import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    BinaryTree<Integer> binaryTree;

    @Before
    public void setup() {
        binaryTree = new BinaryTree<>();
    }

    @Test
    public void add() {
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(0);
    }

    @Test
    public void findByBFS() {
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(0);

        assert(binaryTree.findByBFS(4));
        assert(!binaryTree.findByBFS(10));
    }

    @Test
    public void findByDFSUsingStack() {
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(0);

        assert(binaryTree.findByDFSUsingStack(4));
        assert(!binaryTree.findByDFSUsingStack(10));
        assert(binaryTree.findByDFSUsingStack(7));
    }

    @Test
    public void findByDFSRecursion() {
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(0);

        assert(binaryTree.findByDFSRecursion(4));
        assert(!binaryTree.findByDFSRecursion(10));
        assert(binaryTree.findByDFSRecursion(7));
    }

    @Test
    public void inOrderTraversal() {
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(1);
        binaryTree.add(0);

        binaryTree.inOrderTraversal(binaryTree.rootNode);
    }


    @Test
    public void preOrderTraversal() {
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.preOrderTraversal(binaryTree.rootNode);
    }

    @Test
    public void postOrderTraversal() {
        binaryTree.add(5);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.postOrderTraversal(binaryTree.rootNode);

    }
}