package arrays;


import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    ArrayList arrayList;

    @Before
    public void setup() {
        arrayList = new ArrayList();
    }

    @Test
    public void add() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");
        arrayList.add("i");
        arrayList.add("j");
        arrayList.add("k");
        arrayList.add("l");

        assert (arrayList.get(0).equals("a"));
        assert (arrayList.get(1).equals("b"));
        assert (arrayList.get(2).equals("c"));
        assert (arrayList.get(3).equals("d"));
        assert (arrayList.get(4).equals("e"));
        assert (arrayList.get(5).equals("f"));
        assert (arrayList.get(6).equals("g"));
        assert (arrayList.get(7).equals("h"));
        assert (arrayList.get(8).equals("i"));
        assert (arrayList.get(9).equals("j"));
        assert (arrayList.get(10).equals("k"));
        assert (arrayList.get(11).equals("l"));
    }

    @Test
    public void remove_towardsEnd() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");
        arrayList.add("i");
        arrayList.add("j");
        arrayList.add("k");
        arrayList.add("l");
        arrayList.add("m");
        arrayList.add("n");

        arrayList.remove(11);
        arrayList.add("o");

        assert (arrayList.get(0).equals("a"));
        assert (arrayList.get(1).equals("b"));
        assert (arrayList.get(2).equals("c"));
        assert (arrayList.get(3).equals("d"));
        assert (arrayList.get(4).equals("e"));
        assert (arrayList.get(5).equals("f"));
        assert (arrayList.get(6).equals("g"));
        assert (arrayList.get(7).equals("h"));
        assert (arrayList.get(8).equals("i"));
        assert (arrayList.get(9).equals("j"));
        assert (arrayList.get(10).equals("k"));
        assert (arrayList.get(11).equals("m"));
        assert (arrayList.get(12).equals("n"));
        assert (arrayList.get(13).equals("o"));

        assert (arrayList.contains("d"));
        assert (!arrayList.contains("l"));
    }

    @Test
    public void remove_end() {
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");

        arrayList.remove(6);

        assert (arrayList.get(0).equals("a"));
        assert (arrayList.get(1).equals("b"));
        assert (arrayList.get(2).equals("c"));
        assert (arrayList.get(3).equals("d"));
        assert (arrayList.get(4).equals("e"));
        assert (arrayList.get(5).equals("f"));
        assert(arrayList.getSize() == 6);

        assert (arrayList.contains("d"));
        assert (!arrayList.contains("g"));
    }


}