package linkedlists;

public class SinglyLinkedList<T> {
    private Node<T> headNode;

    public void add(T data) {
        if (headNode == null) {
            headNode = new Node<>(data);
            return;
        }

        Node<T> node = headNode;
        while (node.next != null) {
            node = node.next;
        }
        node.addNode(new Node<>(data));
    }

    public void addNode(Node<T> node) {
        if (headNode == null) {
            headNode = node;
            return;
        }

        Node<T> p1 = headNode;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.addNode(node);
    }

    public T get(int i) {
        Node<T> retrievedNode = headNode;
        while (i != 0 && retrievedNode != null) {
            i--;
            retrievedNode = retrievedNode.next;
        }

        if (retrievedNode == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return retrievedNode.data;
    }

    public int getByValue(T data) {
        Node<T> node = headNode;
        int index = -1;
        int temp = 0;
        while (node != null) {
            if (node.data == data) {
                index = temp;
                break;
            } else {
                node = node.next;
            }
            temp++;
        }

        if (index == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return index;
    }

    public Node<T> getNode(int i) {
        Node<T> retrievedNode = headNode;
        while (i != 0 && retrievedNode != null) {
            i--;
            retrievedNode = retrievedNode.next;
        }

        if (retrievedNode == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return retrievedNode;
    }

    public void insert(T data, int index) {
        Node<T> newNode = new Node<>(data);
        if (index != 0) {
            Node<T> previous = getNode(index - 1);
            Node<T> next = getNode(index);
            previous.next = newNode;
            newNode.next = next;
        } else {
            newNode.next = headNode;
            headNode = newNode;
        }
    }

    public void remove(int index) {
        if (index != 0) {
            Node<T> previous = getNode(index - 1);
            Node<T> next = getNode(index);
            previous.next = next.next;
            next = null;
        } else {
            headNode = headNode.next;
        }
    }

    public void removeDuplicates() {
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            Node<T> runner = currentNode;
            while (runner.next != null) {
                if (currentNode.data.equals(runner.next.data)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public T getByIndexFromLast(int index) {
        Node<T> p1 = headNode;
        Node<T> p2 = headNode;

        for (int i = 0; i < index; i++) {
            p1 = p1.next;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }

    public SinglyLinkedList<Integer> sumListsReversedNumbers(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2) {
        Node<Integer> element1 = list1.headNode;
        Node<Integer> element2 = list2.headNode;
        SinglyLinkedList<Integer> resultList = new SinglyLinkedList<>();
        resultList.headNode = new Node<>(0);
        Node<Integer> result = resultList.headNode;

        while (element1 != null || element2 != null) {
            int e1 = element1 == null ? 0 : element1.data;
            int e2 = element2 == null ? 0 : element2.data;

            result.data = e1 + e2 + result.data;

            int carry = result.data > 10 ? result.data / 10 : 0;
            if (carry > 0) {
                result.data = result.data % 10;
            }
            result.next = new Node<>(carry);

            if (element1 != null) {
                element1 = element1.next;
            }
            if (element2 != null) {
                element2 = element2.next;
            }
            result = result.next;
        }

        return resultList;
    }

    public int length() {
        int length = 0;
        Node<T> node = headNode;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    public void partition(int partitionValue) {
        Node<T> head = headNode;
        Node<T> tail = headNode;
        Node<T> node = headNode;
        while (node != null) {
            int value = (Integer) node.data;
            Node<T> temp = node.next;
            if (value < partitionValue) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = temp;
        }

        tail.next = null;
        headNode = head;

//        Alternate approach
//        Node<T> beforeStart = null;
//        Node<T> beforeEnd = null;
//        Node<T> afterStart = null;
//        Node<T> afterEnd = null;
//
//        Node<T> node = headNode;
//        while (node != null) {
//            int value = (Integer) node.data;
//            Node<T> temp = node.next;
//            node.next = null;
//            if (value < partitionValue) {
//                if (beforeStart == null) {
//                    beforeStart = node;
//                    beforeEnd = node;
//                } else {
//                    beforeEnd.next = node;
//                    beforeEnd = node;
//                }
//            } else {
//                if (afterStart == null) {
//                    afterStart = node;
//                    afterEnd = node;
//                } else {
//                    afterEnd.next = node;
//                    afterEnd = node;
//                }
//            }
//            node = temp;
//        }
//
//        if (beforeStart == null) {
//            headNode = afterStart;
//            return;
//        }
//
//        if (afterStart == null) {
//            headNode = beforeStart;
//            return;
//        }
//
//        beforeEnd.next = afterStart;
    }

    public boolean isPalindrome() {
        Node<T> p1 = headNode;
        Node<T> p2 = headNode;
        SinglyLinkedList<T> cloneList = new SinglyLinkedList<>();

        while (p2 != null && p2.next != null) {
            Node<T> newNode = new Node<>(p1.data);
            if (cloneList.headNode != null) {
                newNode.next = cloneList.headNode;
            }
            cloneList.headNode = newNode;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        if (p2 != null) {
            p1 = p1.next;
        }

        Node<T> cloneNode = cloneList.headNode;
        while (cloneNode != null) {
            if (cloneNode.data != p1.data) {
                return false;
            }
            p1 = p1.next;
            cloneNode = cloneNode.next;
        }

        return true;
    }

    public Node<T> getIntersectingNode(SinglyLinkedList<T> linkedList1,
                                       SinglyLinkedList<T> linkedList2) {
        Node<T> p1 = linkedList1.headNode;
        int l1 = 1;
        while (p1.next != null) {
            l1++;
            p1 = p1.next;
        }
        Node<T> p2 = linkedList2.headNode;
        int l2 = 1;
        while (p2.next != null) {
            l2++;
            p2 = p2.next;
        }

        if (p1 != p2) {
            return null;
        }

        p1 = linkedList1.headNode;
        p2 = linkedList2.headNode;
        if (l1 > l2) {

            while (l1 - l2 != 0) {
                l1--;
                p1 = p1.next;
            }
        } else {
            while (l2 - l1 != 0) {
                l2--;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    public Node<T> getLoopingNode() {
        Node<T> slowRunner = headNode;
        Node<T> fastRunner = headNode;

        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner) {
                break;
            }
        }

        if (fastRunner == null || fastRunner.next == null) {
            return null;
        }

        slowRunner = headNode;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }
}


class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void addNode(Node<T> node) {
        this.next = node;
    }
}