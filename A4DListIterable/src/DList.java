import java.util.Iterator;
import java.util.NoSuchElementException;

/*  Name(s):
 * Netid(s):
 * What I thought about this assignment:
 *
 *
 */

/** An instance is a doubly linked list. */
public class DList<E> implements Iterable<E>{
    /** Replace "-1" by the time you spent on A3 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= -1; 
    
    
    

    /** Number of values in the linked list. */
    private int size;
    /** First and last nodes of the linked list (null if size is 0) */
    private Node head, tail;

    /** Constructor: an empty linked list. Do need to change this. */
    public DList() {}
    
   

    /** = the number of values in this list. <br>
     * This function takes constant time. */
    public int size() {
        return size;
    }

    /** = the first node of the list (null if the list is empty). */
    public Node head() {
        return head;
    }

    /** = the last node of the list (null if the list is empty). */
    public Node tail() {
        return tail;
    }

    /** Return the value in node n of this list. <br>
     * Precondition: n is a node of this list; it may not be null. */
    public E value(Node n) {
        assert n != null;
        return n.val;
    }
    
    
    /** An instance is an iterator over this list. */
    private class DListIterator implements Iterator<E> { 
    	int n; // b[n] is next element to iterate (-1 if none) 
    	
    	/**
    	 * Constructor: iterator over list elements
    	 */
    	public DListIterator() { n = 0; } 
    	
    	/** = there is another element to enumerate */ 
    	public @Override boolean hasNext() { return n != size; }
    	
    	public @Override E next() { 
    		if(!hasNext()) throw new NoSuchElementException();
    		n = n + 1;
    		return getNode(n-1).val;
    	}
    	
    	
    }
    

    /** Return an iterator over this list. */ 
    public @Override Iterator<E> iterator() { return new DListIterator(); }
    

    /** Return a representation of this list: its values, with<br>
     * "[" at the beginning, "]" at the end, and adjacent ones separated by ", " . <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    @Override
    public String toString() {
        StringBuilder res= new StringBuilder("[");
        Node n= head;
        // inv: res contains values of nodes before node n (all of them if n = null),
        // with ", " after each (except for the last value)
        while (n != null) {
            res.append(n.val);
            n= n.succ;
            if (n != null) res.append(", ");
        }

        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with<br>
     * "[" at the beginning, "]" at the end, and adjacent ones separated by ", " . <br>
     * Note that toStringR is the reverse of toString. <br>
     * Takes time proportional to the length of this list. <br>
     * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String toStringR() { // Note:
        // TODO 1. Look at toString to see how that was written.
        // Use the same scheme. Extreme case to watch out for:
        // E is String and values are the empty string.
        // You can't test this fully until #2, append, is written.
        StringBuilder res= new StringBuilder("[");
        Node n= tail;
        // inv: res contains values of nodes after node n (all of them if n = null),
        // with ", " after each (except for the last value)
        while (n != null) {
            res.append(n.val);
            n= n.pred;
            if (n != null) res.append(", ");
        }

        return res + "]";
    }

    /** Insert v at the beginning of the list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], prepend(2) changes this list to [2, 8, 7, 4]. */
    public void prepend(E v) {
        // TODO 2. After writing this method, test this method and
        // method toStringR thoroughly before starting on the next
        // method. These two must be correct in order to be
        // able to write and test all the others.
        head= new Node(null, v, head);
        if (size == 0) tail= head;
        else head.succ.pred= head;
        size= size + 1;
    }

    /** Add v to the end of this list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], append(2) changes this list to [8, 7, 4, 2]. */
    public void append(E v) {
        // TODO 3. This is the second method to write and test.
        // Test it thoroughly before writing any others.
        tail= new Node(tail, v, null);
        if (size == 0) head= tail;
        else tail.pred.succ= tail;
        size= size + 1;
    }

    /** = node number h. <br>
     * Precondition: 0 <= h < size of the list. <br>
     * Note: If h is 0, return first node; if h = 1, return second node, ... */
    public Node getNode(int h) {
        // TODO 4. This method should take time proportional to min(h, size-h).
        // For example, if h < size/2, search from the beginning of the
        // list, otherwise search from the end of the list. If h = size/2,
        // search from either end; it doesn't matter.
        if (h <= size / 2) {
            Node n= head;
            while (h > 0) {
                n= n.succ;
                h= h - 1;
            }
            return n;
        }
        // Search from end of list
        Node n= tail;
        while (h < size - 1) {
            n= n.pred;
            h= h + 1;
        }
        return n;
    }

    /** Remove node n from this list. <br>
     * This operation must take constant time. <br>
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        // We give you this method.
        assert n != null;
        if (n.pred == null) head= n.succ;
        else n.pred.succ= n.succ;

        if (n.succ == null) tail= n.pred;
        else n.succ.pred= n.pred;

        n.pred= null;
        n.succ= null;
        size= size - 1;
    }

    /** Insert value v in a new node after node n. <br>
     * This operation takes constant time. <br>
     * Precondition: n must be a node of this list; it may not be null.<br>
     * E.g. if the list is [3, 8, 2] and n points to the node with 8 in it, <br>
     * and v is 1, the list is changed to [3, 8, 1, 2] */
    public void insertAfter(E v, Node n) {
        // TODO 6. Make sure this method takes constant time.
        assert n != null;
        Node no= new Node(n, v, n.succ);
        if (n.succ == null) tail= no;
        else n.succ.pred= no;
        n.succ= no;
        size= size + 1;
    }

    /*********************/

    /** An instance is a node of this list. */
    class Node {
        /** The value in the node */
        private E val;
        /** Previous node (predecessor) on list (null if this is first node) and<br>
         * Next node (successor) on list (null if this is last node). */
        private Node pred, succ;

        /** Constructor: an instance with predecessor p (can be null), value v, and <br>
         * successor s (can be null). */
        Node(Node p, E v, Node s) {
            pred= p;
            val= v;
            succ= s;
        }

        /** = the predecessor of this node (null if this is the first node of the list). */
        Node pred() {
            return pred;
        }

        /** = the value of this node. */
        E value() {
            return val;
        }

        /** = the next node in this list (null if this is the last node of this list). */
        Node succ() {
            return succ;
        }
    }

}
