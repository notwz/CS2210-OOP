package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ElephantTest {

    /** Group A Tests */
    @Test
    public void testConstructor1() {

        Elephant aDad= new Elephant("test dad", 'M', 2000, 4);
        Elephant aMom= new Elephant("test mom", 'F', 2000, 4);

        assertEquals("test dad", aDad.name());
        assertEquals(false, aDad.isFemale());
        assertEquals(true, aMom.isFemale());
        assertEquals("4/2000", aDad.date());

    }

    /** Group B Tests */
    @Test
    public void testAddParents() {
        Elephant aDad= new Elephant("test dad", 'M', 2000, 4);
        Elephant aMom= new Elephant("test mom", 'F', 2000, 4);

        Elephant a= new Elephant("test name", 'M', 2008, 3, aMom, aDad);

        assertEquals(aDad, a.dad());
        assertEquals(aMom, a.mom());
        assertEquals(1, aDad.children());
        assertEquals(1, aMom.children());

    }

    /** Group C Test */
    @Test
    public void testConstructor2() {
        Elephant aDad= new Elephant("test dad", 'M', 2000, 4);
        Elephant aMom= new Elephant("test mom", 'F', 2000, 4);
        Elephant a= new Elephant("test name", 'M', 2008, 3, aMom, aDad);

        assertEquals("test dad", aDad.name());
        assertEquals(false, aDad.isFemale());
        assertEquals(true, aMom.isFemale());
        assertEquals(aMom, a.mom());
        assertEquals(aDad, a.dad());

        assertEquals(true, a.mom().isFemale());
        assertEquals(false, a.dad().isFemale());
        assertEquals("4/2000", aDad.date());

    }

    /** Group D Tests */
    @Test
    public void testBooleans() {
        Elephant aDad= new Elephant("test dad", 'M', 2000, 4);
        Elephant aMom= new Elephant("test mom", 'F', 2000, 4);

        Elephant a= new Elephant("test name", 'M', 2008, 3, aMom, aDad);
        Elephant b= new Elephant("test name", 'M', 2008, 3, aMom, aDad);

        assertEquals(false, a.areSibs(aDad));
        assertEquals(true, a.areSibs(b));

        assertEquals(false, a.areSibs(null));

        Elephant oldest= new Elephant("Rabbit 1", 'F', 2001, 1);
        Elephant twin1= new Elephant("Rabbit 2 ", 'F', 2003, 3);
        Elephant twin2= new Elephant("Rabbit 3", 'F', 2003, 3);
        Elephant sameYear= new Elephant("Rabbit 4", 'F', 2007, 5);
        Elephant youngest= new Elephant("Rabbit 4", 'F', 2007, 6);

        assertEquals(true, oldest.isOlder(twin1));
        assertEquals(false, twin1.isOlder(twin2));
        assertEquals(true, sameYear.isOlder(youngest));
        assertEquals(false, youngest.isOlder(oldest));
        assertEquals(false, youngest.isOlder(sameYear));

    }

    @Test
    public void testAsserts() {
        Elephant aDad= new Elephant("test dad", 'M', 2000, 4);
        Elephant aMom= new Elephant("test mom", 'F', 2000, 4);

        Elephant a= new Elephant("test name", 'M', 2008, 3, aMom, aDad);
        Elephant b= new Elephant("test name", 'M', 2008, 3, aMom, aDad);

        assertThrows(AssertionError.class, () -> new Elephant("", 'M', 2008, 3));
        assertThrows(AssertionError.class, () -> new Elephant("Name", 'X', 2008, 3));
        assertThrows(AssertionError.class, () -> new Elephant("Name", 'M', 1, 3));
        assertThrows(AssertionError.class, () -> new Elephant("Name", 'M', 2008, 13));
        assertThrows(AssertionError.class, () -> new Elephant("Name", 'M', 2008, 3, null, aDad));
        assertThrows(AssertionError.class, () -> new Elephant("Name", 'M', 2008, 3, aMom, null));
        assertThrows(AssertionError.class, () -> aDad.isOlder(null));

    }
}