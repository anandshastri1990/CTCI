package stacksandqueues;

public class QueueUsingStack<T> {
//    Last In First Out

//    First In First Out

    Stack<T> stackNew = new Stack<>();
    Stack<T> stackOld = new Stack<>();

    public void add(T data) {
        stackNew.push(data);
    }


    public T remove() {
        shiftFromNewToOld();
        return stackOld.pop();
    }

    private void shiftFromNewToOld() {
        if (stackOld.isEmpty()) {
            while (stackNew.peek() != null) {
                stackOld.push(stackNew.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stackNew.isEmpty() && stackOld.isEmpty();
    }

    public T peek() {
        shiftFromNewToOld();
        return stackOld.peek();
    }
}
