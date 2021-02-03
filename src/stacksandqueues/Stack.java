package stacksandqueues;

public class Stack<T> {
    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public void sort() {
        Stack<T> tempStack = new Stack<>();
        while (!this.isEmpty()) {
            T top = pop();
            while (!tempStack.isEmpty() && (Integer) top < (Integer) tempStack.peek()) {
                push(tempStack.pop());
            }
            tempStack.push(top);
        }

        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }


}

class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
    }
}