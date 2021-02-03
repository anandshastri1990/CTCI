package stacksandqueues;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        if (first == null) {
            first = new QueueNode<T>(data);
            return;
        }
        if (last == null) {
            last = new QueueNode<>(data);
            first.next = last;
            return;
        }
        last.next = new QueueNode<>(data);
        last = last.next;
    }

    public T remove() {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T peek() {
        return first.data;
    }
}

class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
    }
}