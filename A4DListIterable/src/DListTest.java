
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    public void testConstructor() {
        DList<Integer> c= new DList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    public void testPrependAndToStringR() {
        DList<String> dl= new DList<>();
        dl.prepend("CS2110");
        assertEquals("[CS2110]", dl.toString());
        assertEquals("[CS2110]", dl.toStringR());
        assertEquals(1, dl.size());

        dl.prepend("ENGRD2110");
        assertEquals("[ENGRD2110, CS2110]", dl.toString());
        assertEquals("[CS2110, ENGRD2110]", dl.toStringR());
        assertEquals(2, dl.size());

        dl.prepend("ff");
        assertEquals("[ff, ENGRD2110, CS2110]", dl.toString());
        assertEquals("[CS2110, ENGRD2110, ff]", dl.toStringR());
        assertEquals(3, dl.size());
    }

    @Test
    public void testAppend() {
        DList<String> dl= new DList<>();
        dl.append("1");
        assertEquals("[1]", dl.toString());
        assertEquals("[1]", dl.toStringR());
        assertEquals(1, dl.size());

        dl.append("2");
        assertEquals("[1, 2]", dl.toString());
        assertEquals("[2, 1]", dl.toStringR());
        assertEquals(2, dl.size());

        dl.append("3");
        assertEquals("[1, 2, 3]", dl.toString());
        assertEquals("[3, 2, 1]", dl.toStringR());
        assertEquals(3, dl.size());
    }

    @Test
    public void testGetNode() {
        DList<Integer> dl= new DList<>();
        for (int k= 20; 0 <= k; k= k - 1) dl.append(k);
        System.out.println(dl);
        for (int k= 0; k <= 20; k= k + 1) {
            assertEquals(20 - k, dl.getNode(k).value());

        }
    }

    @Test
    public void testinsertRemove() {
        DList<Integer> dl= new DList<>();
        dl.append(5);
        dl.remove(dl.head());
        assertEquals("[]", dl.toString());
        assertEquals("[]", dl.toStringR());
        assertEquals(0, dl.size());

        dl= new DList<>();
        dl.append(5);
        dl.append(6);
        dl.remove(dl.head());
        assertEquals("[6]", dl.toString());
        assertEquals("[6]", dl.toStringR());
        assertEquals(1, dl.size());

        dl= new DList<>();
        dl.append(5);
        dl.append(6);
        dl.remove(dl.tail());
        assertEquals("[5]", dl.toString());
        assertEquals("[5]", dl.toStringR());
        assertEquals(1, dl.size());

        dl= new DList<>();
        dl.append(5);
        dl.append(6);
        dl.append(7);
        dl.remove(dl.head().succ());
        assertEquals("[5, 7]", dl.toString());
        assertEquals("[7, 5]", dl.toStringR());
        assertEquals(2, dl.size());
    }

    @Test
    public void testinsertAfter() {
        DList<Integer> dl= new DList<>();
        dl.append(5);
        dl.insertAfter(7, dl.head());
        assertEquals("[5, 7]", dl.toString());
        assertEquals("[7, 5]", dl.toStringR());
        assertEquals(2, dl.size());

        dl= new DList<>();
        dl.append(5);
        dl.append(7);
        dl.insertAfter(6, dl.head());
        assertEquals("[5, 6, 7]", dl.toString());
        assertEquals("[7, 6, 5]", dl.toStringR());
        assertEquals(3, dl.size());

        dl= new DList<>();
        dl.append(5);
        dl.append(6);
        dl.insertAfter(7, dl.tail());
        assertEquals("[5, 6, 7]", dl.toString());
        assertEquals("[7, 6, 5]", dl.toStringR());
        assertEquals(3, dl.size());
    }

    @Test
    public void testIterator() {
        // Make a list of the integers in 10..19
        DList<Integer> d= new DList<>();
        for (int k= 0; k < 10; k= k + 1) {
            d.append(k + 10);
        }

        // Test that the list contains 10..19
        Iterator<Integer> dit= d.iterator();
        int k= 0;
        while (dit.hasNext()) {
            assertEquals((Integer) (k + 10), dit.next());
            k= k + 1;
        }
        // Test that the loop stopped at the right place
        assertEquals(10, k);
    }

    @Test
    public void testIterable() {
        // Make a list (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        DList<Integer> d= new DList<>();
        for (int k= 0; k < 10; k= k + 1) {
            d.append(k);
        }

        // Check that the foreach loop enumerates the ints in 0..9.
        int tt= 0;
        for (int ob : d) {
            assertEquals(tt, ob);
            tt= tt + 1;
        }
    }

}
