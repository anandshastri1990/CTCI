package stacksandqueues;


import org.junit.Before;
import org.junit.Test;

public class StackTest {

    Stack<String> stack;

    @Before
    public void setup() {
        stack = new Stack<>();
    }

    @Test
    public void push_peek() {
        stack.push("foobar1");

        assert (stack.peek().equals("foobar1"));
    }

    @Test
    public void push_pop() {
        stack.push("foobar1");
        stack.push("foobar2");
        stack.push("foobar3");

        assert (stack.pop().equals("foobar3"));
        assert (stack.pop().equals("foobar2"));
        assert (stack.pop().equals("foobar1"));
    }

    @Test
    public void isEmpty() {
        assert (stack.isEmpty());
    }

    @Test
    public void sort() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(0);
        stack.push(4);
        stack.push(5);
        stack.push(2);

        stack.sort();

        assert (stack.pop().equals(0));
        assert (stack.pop().equals(1));
        assert (stack.pop().equals(2));
        assert (stack.pop().equals(3));
        assert (stack.pop().equals(4));
        assert (stack.pop().equals(5));
    }

}