package treesandgraphs;

import stacksandqueues.Queue;
import stacksandqueues.Stack;

public class BinaryTree<T> {
    BinaryTreeNode<T> rootNode = new BinaryTreeNode<T>(null);

    public void add(T data) {
        add(rootNode, data);
    }

    private void add(BinaryTreeNode<T> node, T data) {
        if (node.data == null) {
            node.data = data;
            return;
        }

        if ((Integer) data > (Integer) node.data) {
            if (node.right == null) {
                node.right = new BinaryTreeNode<>(null);
            }
            add(node.right, data);
        } else {
            if (node.left == null) {
                node.left = new BinaryTreeNode<>(null);
            }
            add(node.left, data);
        }
    }

    public void inOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(BinaryTreeNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }

    public boolean findByBFS(T i) {
        int count = 0;
        if (rootNode == null) {
            return false;
        }

        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            count++;
            if (queue.peek() != null && queue.peek().data == i) {
                System.out.println("Number of iterations: " + count);
                return true;
            }
            if (queue.peek() != null && queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek() != null && queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.remove();
        }

        System.out.println("Number of iterations: " + count);
        return false;
    }

    public boolean findByDFSRecursion(T i) {
        if (rootNode == null) {
            return false;
        }
        return findByDFSRecursion(rootNode, i);
    }

    private boolean findByDFSRecursion(BinaryTreeNode<T> node, T i) {
        if (node.data == i) {
            return true;
        }

        if (node.left != null) {
            boolean result = findByDFSRecursion(node.left, i);
            if (result) {
                return true;
            }
        }
        if (node.right != null) {
            return findByDFSRecursion(node.right, i);
        }

        return false;
    }

    public boolean findByDFSUsingStack(T i) {
        int count = 0;
        if (rootNode == null) {
            return false;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            count++;
            BinaryTreeNode<T> node = stack.peek();
            if (node != null && node.data == i) {
                System.out.println("Number of iterations: " + count);
                return true;
            }
            stack.pop();
            if (node != null && node.right != null) {
                stack.push(node.right);
            }
            if (node != null && node.left != null) {
                stack.push(node.left);
            }
        }

        System.out.println("Number of iterations: " + count);
        return false;
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
