package linkedlists;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SinglyLinkedListTest {

    SinglyLinkedList<String> linkedList;

    @Before
    public void setup() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void create() {
        linkedList.add("foobar");
    }

    @Test
    public void getByIndex() {
        linkedList.add("foobar");
        assert (linkedList.get(0).equals("foobar"));
    }

    @Test
    public void getByValue() {
        linkedList.add("foobar");
        assert (linkedList.getByValue("foobar") == 0);
    }

    @Test
    public void getByIndex_avoidsNullPointers() {
        linkedList.add("foobar");
        try {
            linkedList.get(2);
            fail("Expected exception to be thrown");
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    @Test
    public void insertByIndex_middle() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.insert("foobar", 1);

        assert (linkedList.get(0).equals("foobar1"));
        assert (linkedList.get(1).equals("foobar"));
        assert (linkedList.get(2).equals("foobar2"));
        assert (linkedList.get(3).equals("foobar3"));
    }

    @Test
    public void insertByIndex_head() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.insert("foobar", 0);

        assert (linkedList.get(0).equals("foobar"));
        assert (linkedList.get(1).equals("foobar1"));
        assert (linkedList.get(2).equals("foobar2"));
        assert (linkedList.get(3).equals("foobar3"));
    }

    @Test
    public void insertByIndex_end() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.insert("foobar", 2);

        assert (linkedList.get(0).equals("foobar1"));
        assert (linkedList.get(1).equals("foobar2"));
        assert (linkedList.get(2).equals("foobar"));
        assert (linkedList.get(3).equals("foobar3"));
    }

    @Test
    public void removeByIndex_middle() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.remove(1);

        assert (linkedList.get(0).equals("foobar1"));
        assert (linkedList.get(1).equals("foobar3"));
    }

    @Test
    public void removeByIndex_head() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.remove(0);

        assert (linkedList.get(0).equals("foobar2"));
        assert (linkedList.get(1).equals("foobar3"));
    }

    @Test
    public void getByIndexFromLast() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar4");
        linkedList.add("foobar5");
        linkedList.add("foobar6");
        linkedList.add("foobar7");
        linkedList.add("foobar8");
        linkedList.add("foobar9");

        assert (linkedList.getByIndexFromLast(2).equals("foobar7"));
        assert (linkedList.getByIndexFromLast(5).equals("foobar4"));
    }

    @Test
    public void removeByIndex_end() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");

        linkedList.remove(2);

        assert (linkedList.get(0).equals("foobar1"));
        assert (linkedList.get(1).equals("foobar2"));
    }

    @Test
    public void removeDuplicates() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar4");
        linkedList.add("foobar5");
        linkedList.add("foobar6");
        linkedList.add("foobar7");
        linkedList.add("foobar1");

        linkedList.removeDuplicates();

        assert (linkedList.get(0).equals("foobar1"));
        assert (linkedList.get(1).equals("foobar2"));
        assert (linkedList.get(2).equals("foobar3"));
        assert (linkedList.get(3).equals("foobar4"));
        assert (linkedList.get(4).equals("foobar5"));
        assert (linkedList.get(5).equals("foobar6"));
        assert (linkedList.get(6).equals("foobar7"));
    }

    @Test
    public void palindrome() {
        linkedList.add("foobar1");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar4");
        linkedList.add("foobar3");
        linkedList.add("foobar2");
        linkedList.add("foobar3");
        linkedList.add("foobar2");
        linkedList.add("foobar1");

        assert (linkedList.isPalindrome());

        linkedList.add("foobar1");

        assert (!linkedList.isPalindrome());
    }

    @Test
    public void partition() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(3);
        linkedList.add(10);
        linkedList.add(9);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(4);

        linkedList.partition(5);

        assert (linkedList.getByValue(1) <= 4);
        assert (linkedList.getByValue(2) <= 4);
        assert (linkedList.getByValue(3) <= 4);
        assert (linkedList.getByValue(4) <= 4);
        assert (linkedList.getByValue(6) >= 4);
        assert (linkedList.getByValue(7) >= 4);
        assert (linkedList.getByValue(8) >= 4);
        assert (linkedList.getByValue(9) >= 4);
        assert (linkedList.getByValue(10) >= 4);
    }

    @Test
    public void sumListsReversedNumbers() {
        SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();

        linkedList1.add(7);
        linkedList1.add(1);
        linkedList1.add(6);

        linkedList2.add(5);
        linkedList2.add(9);
        linkedList2.add(4);

        SinglyLinkedList<Integer> result = linkedList.sumListsReversedNumbers(linkedList1, linkedList2);

        assert (result.get(0) == 2);
        assert (result.get(1) == 1);
        assert (result.get(2) == 1);
        assert (result.get(3) == 1);
    }

    @Test
    public void getIntersectingNode_whenPresent() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();

        linkedList1.addNode(new Node<>(0));
        linkedList1.addNode(new Node<>(2));
        linkedList1.addNode(new Node<>(2));
        linkedList1.addNode(new Node<>(3));
        Node<Integer> commonNode = new Node<>(4);
        linkedList1.addNode(commonNode);
        linkedList1.addNode(new Node<>(3));
        linkedList1.addNode(new Node<>(7));

        linkedList2.addNode(new Node<>(5));
        linkedList2.addNode(new Node<>(6));
        linkedList2.addNode(commonNode);

        Node<Integer> node = linkedList.getIntersectingNode(linkedList1, linkedList2);

        assert (node == commonNode);

    }

    @Test
    public void getIntersectingNode_whenNotPresent() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();

        linkedList1.addNode(new Node<>(0));
        linkedList1.addNode(new Node<>(2));
        linkedList1.addNode(new Node<>(3));
        linkedList1.addNode(new Node<>(3));
        linkedList1.addNode(new Node<>(7));

        linkedList2.addNode(new Node<>(5));
        linkedList2.addNode(new Node<>(6));
        linkedList2.addNode(new Node<>(7));

        Node<Integer> node = linkedList.getIntersectingNode(linkedList1, linkedList2);

        assert (node == null);

    }

    @Test
    public void getLoopingNode_whenPresent() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Node<Integer> commonNode = new Node<>(3);
        linkedList.addNode(new Node<>(0));
        linkedList.addNode(new Node<>(1));
        linkedList.addNode(new Node<>(2));
        linkedList.addNode(commonNode);
        linkedList.addNode(new Node<>(4));
        linkedList.addNode(new Node<>(5));
        linkedList.addNode(new Node<>(8));
        linkedList.addNode(new Node<>(6));
        linkedList.addNode(commonNode);

        Node<Integer> node = linkedList.getLoopingNode();

        assert (node == commonNode);

    }

    @Test
    public void getLoopingNode_whenNotPresent() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        Node<Integer> commonNode = new Node<>(3);
        linkedList.addNode(new Node<>(0));
        linkedList.addNode(new Node<>(1));
        linkedList.addNode(new Node<>(2));
        linkedList.addNode(commonNode);
        linkedList.addNode(new Node<>(4));
        linkedList.addNode(new Node<>(10));
        linkedList.addNode(new Node<>(5));
        linkedList.addNode(new Node<>(6));

        Node<Integer> node = linkedList.getLoopingNode();

        assert (node == null);

    }
}