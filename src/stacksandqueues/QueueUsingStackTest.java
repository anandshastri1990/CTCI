package stacksandqueues;


import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {

    QueueUsingStack<String> queue;

    @Before
    public void setup() {
        queue = new QueueUsingStack<>();
    }

    @Test
    public void push_peek() {
        queue.add("foobar1");

        assert (queue.peek().equals("foobar1"));
    }

    @Test
    public void add_pop() {
        queue.add("foobar1");
        queue.add("foobar2");
        queue.add("foobar3");

        assert (queue.remove().equals("foobar1"));
        assert (queue.remove().equals("foobar2"));
        assert (queue.remove().equals("foobar3"));

        queue.add("foobar2");
        queue.add("foobar3");

        assert (queue.remove().equals("foobar2"));
        assert (queue.remove().equals("foobar3"));
    }

    @Test
    public void isEmpty() {
        assert (queue.isEmpty());
    }


}