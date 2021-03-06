package linkedlist;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.util.*;

class DListTest {
	
  

    
    void testReverse() {
    	  DList<Integer> ll = new DList<>(); 
    	    ll.append(8);
    	    ll.append(7);
    	    ll.append(4);
    	    assertEquals("[8, 7, 4]", ll.toStringR());
    	   
    	    
    	
    }
    
    @Test
    public void testConstructor() { 
    	DList<Integer> d= new DList<>();
    	assertEquals("[]", d.toString());
    	assertEquals("[]", d.toStringR());
    	assertEquals(0, d.size());
    	
    }
    
    @Test
    public void testPrependAndToStringR() { 
    	DList<String> dl= new DList<String>();
    	dl.prepend("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringR());
        assertEquals(1, dl.size());
    }
    
    @Test
    public void testGetNode() { 
    	DList<Integer> d= new DList<>();
    	d.prepend(3);
    	d.prepend(8);
    	d.prepend(2);
    	assertEquals(2, d.getNode(0).value());
    	
    	DList<Integer> x= new DList<>();
    	

    	
    	
    }
    
    @Test
    public void testInsertAfter() { 
    	DList<Integer> d= new DList<>();
    	d.prepend(3);
    	d.prepend(8);
    	d.prepend(2);
    	assertEquals("[2, 8, 3]", d.toString());
    	assertEquals("[3, 8, 2]", d.toStringR());
    	
    	
    	d.insertAfter(1, d.getNode(1));
    	assertEquals("[2, 8, 1, 3]", d.toString());
    	
    	d.remove(d.getNode(3));
    	assertEquals("[2, 8, 1]", d.toString());
    	d.insertAfter(3, d.getNode(1));
    	assertEquals("[2, 8, 3, 1]", d.toString());    	
    	d.remove(d.getNode(0));
    	assertEquals("[8, 3, 1]", d.toString()); 
    	d.insertAfter(4, d.getNode(1));
    	assertEquals("[8, 3, 4, 1]", d.toString());
    	assertEquals("[1, 4, 3, 8]", d.toStringR());
    	d.insertAfter(2, d.getNode(4));
    	assertEquals("[8, 3, 4, 1, 2]", d.toString());
    	assertEquals(5, d.size());
    	
    }
    

    

}
