package a7;

/* NetId(s): djg17

 * Name(s): gries
 * What I thought about this assignment:
 *
 *
 */

import java.lang.reflect.Array;
import java.util.*;

/** An instance is a max-heap or a min-heap of distinct values of type T <br>
 * with priorities of type double. */
public final class Heap<T> {

	/** Replace "-1" by the time you spent on A2 in hours.<br>
	 * Example: for 3 hours 15 minutes, use 3.25<br>
	 * Example: for 4 hours 30 minutes, use 4.50<br>
	 * Example: for 5 hours, use 5 or 5.0 */
	public static double timeSpent= -1;

	/** Class Invariant: <br>
	 * 1. b[0..size-1] represents a complete binary tree.<br>
	 * b[0] is the root; <br>
	 * For k > 0, (k-1)/2 (using int division) is the index in b of the parent of b[k]<br>
	 * For k >= 0, 2k+1 and 2k+2 are the indexes in b of left and right children of b[k].<br>
	 *
	 * 2. For k in 0..size-1, b[k] contains the value and its priority.
	 *
	 * 3. The values in b[0..size-1] are all different.
	 *
	 * 4. For k in 1..size-1, <br>
	 * .. if isMinHeap, (b[k]'s priority) >= (b[k]'s parent's priority),<br>
	 * .. if !isMinHeap, (b[k]'s priority) <= (b[k]'s parent's priority).
	 *
	 * map and the tree are in sync, meaning:
	 *
	 * 5. The keys of map are the values in b[0..size-1]. This implies that size = map.size().
	 *
	 * 6. if value v is in b[k], then map.get(v) = k. */
	protected final boolean isMinHeap;
	protected Pair[] b;
	protected int size;
	protected HashMap<T, Integer> map;

	/** Constructor: an empty heap with capacity 10. <br>
	 * It is a min-heap if isMin is true and a max-heap if isMin is false. */
	public Heap(boolean isMin) {
		isMinHeap= isMin;
		b= createPairArray(10);
		map= new HashMap<>();
	}

	/** If size = length of b, double the length of array b. <br>
	 * The worst-case time is proportional to the length of b. */
	protected void ensureSpace() {
		// TODO #1. We ask you to write this method because it shows you
		// how class ArrayList can "increase" the size of its backing array.
		// When its capacity is reached (its backing array is filled), it creates
		// an array of twice the size, copies the old array into it, and
		// uses the new array from then on.

		// Any method that increases the size of the heap must call
		// this method FIRST, BEFORE increasing the size.

		// After this method is written, this testing procedure should work.
		// test01EnsureSpace1. Please read the hint in that method to learn how
		// we can test this method without calling method imsert, which is below.

		// The body is most easily written using a method in Collections Framework
		// class Arrays. Look for methods that copy arrays and choose a suitable one.

		if (size == b.length) b= Arrays.copyOf(b, 2 * b.length);
	}

	/** Insert v with priority p to the heap. <br>
	 * Throw an illegalArgumentException if v is already in the heap. <br>
	 * The expected time is logarithmic and <br>
	 * the worst-case time is linear in the size of the heap. */
	public void insert(T v, double p) throws IllegalArgumentException {
		// TODO #2: Write this whole method. Note that bubbleUp is not implemented,
		// so calling it has no effect (yet). The first tests of insert, using
		// test10Insert, ensures that this method maintains fields c and map properly,
		// without worrying about bubbling up.

		// Testing procedures test10Insert, test14InsertAndEnsureSpace, and
		// test16InsertAndEnsureSpace should work. Look at their specifications.

		// Do NOT call bubbleUp until the class invariant is true
		// (except for the need to bubble up).
		// Calling bubbleUp is the last thing to be done.
		if (map.containsKey(v)) throw new IllegalArgumentException("v already in the heap");

		ensureSpace();
		map.put(v, size);
		b[size]= new Pair(v, p);
		size= size + 1;
		bubbleUp(size - 1);
	}

	/** Return the size of this heap. <br>
	 * This operation takes constant time. */
	public int size() { // Do not change this method
		return size;
	}

	/** Swap b[h] and b[k]. <br>
	 * Precondition: 0 <= h < heap-size, 0 <= k < heap-size. */
	void swap(int h, int k) {
		assert 0 <= h && h < size && 0 <= k && k < size;
		// TODO 3: When bubbling values up or down, two values,
		// say b[h] and b[k], will have to be swapped. At the same time,
		// the definition of map has to be maintained.
		// In order to always get this right, use this method swap to do this.

		// When method swap is correct, testing procedure test20Swap
		// will find no errors.
		//
		// Read the Assignment A5 note about map.put(...).
		Pair temp= b[h];
		b[h]= b[k];
		b[k]= temp;
		map.put(b[h].value, h);
		map.put(b[k].value, k);
	}

	/** If a value with priority p1 belongs above a value with priority p2 in the heap, <br>
	 * return 1.<br>
	 * If priority p1 and priority p2 are the same, return 0. <br>
	 * If a value with priority p1 should be below a value with priority p2 in the heap,<br>
	 * return -1.<br>
	 * This is based on what kind of a heap this is, <br>
	 * ... E.g. a min-heap, the value with the smallest priority is in the root.<br>
	 * ... E.g. a max-heap, the value with the largest priority is in the root. */
	public int compareTo(double p1, double p2) {
		if (p1 == p2) return 0;
		if (isMinHeap) { return p1 < p2 ? 1 : -1; }
		return p1 > p2 ? 1 : -1;
	}

	/** If b[h] should be above b[k] in the heap, return 1. <br>
	 * If b[h]'s priority and b[k]'s priority are the same, return 0. <br>
	 * If b[h] should be below b[k] in the heap, return -1. <br>
	 * This is based on what kind of a heap this is, <br>
	 * ... E.g. a min-heap, the value with the smallest priority is in the root. <br>
	 * ... E.g. a max-heap, the value with the largest priority is in the root. */
	public int compareTo(int h, int k) {
		return compareTo(b[h].priority, b[k].priority);
	}

	/** If h >= size, return.<br>
	 * Otherwise, bubble b[h] up the heap to its right place. <br>
	 * Precondition: 0 <= h and, if h < size, <br>
	 * ... the class invariant is true, except perhaps that <br>
	 * ... b[h] belongs above its parent (if h > 0) in the heap. */
	void bubbleUp(int h) {
		// TODO #4 This method should be called within insert in order
		// to bubble a value up to its proper place, based on its priority.

		// Do not use recursion. Use iteration.

		// Use the compareTo methods to test whether value h is in its right place.
		// That way, YOU don't have to worry about whether it is a min- or max-heap!

		// If this method is correct, these testing procedures should not find errors:
		// test30InsertMinHeap_BubbleUp,
		// test32InsertMaxHeap_BubbleUp,
		// test34InsertMin_BubbleUpDuplicatePriorities,
		// test36InsertMax_BubbleUpDuplicatePriorities
		if (h >= size) return;
		// Inv: 0 <= h < size and<br>
		// The class invariant is true, except perhaps<br>
		// that b[h] belongs above its parent (if h > 0) in the heap, not below it.
		while (h > 0) {
			int p= (h - 1) / 2; // p is h's parent
			if (compareTo(h, p) <= 0) return;
			swap(h, p);
			h= p;
		}
	}

	/** If this is a min-heap, return the heap value with lowest priority. <br>
	 * If this is a max-heap, return the heap value with highest priority.<br>
	 * Do not change the heap. <br>
	 * This operation takes constant time. <br>
	 * Throw a NoSuchElementException if the heap is empty. */
	public T peek() {
		// TODO 5: Do peek. This is an easy one.

		// If this method is correct, these testing procs will show no errors:
		// test40MinPeek and test42MaxPeek
		if (size <= 0) throw new NoSuchElementException("heap is empty");
		return b[0].value;
	}

	/** If h < 0 or size <= h, return.<br>
	 * Otherwise, Bubble b[h] down in heap until the class invariant is true. <br>
	 * If there is a choice to bubble down to both the left and right children <br>
	 * (because their priorities are equal), choose the left child. <br>
	 *
	 * Precondition: If 0 <= h < size, the class invariant is true except that <br>
	 * perhaps b[h] belongs below one or both of its children. */
	void bubbleDown(int h) {
		// TODO 6: DO NOT USE RECURSION. Use iteration.
		// When this method is correct, these testing procedures will find no errors:
		// test50MinBubbleDown thru test54MinBubble_DownRight
		// test56MaxBubbleDown thru test57MaxBubbleDownRight
		if (h < 0 || size <= h) return;
		int k= 2 * h + 1;
		// Invariant: k is h's left child and
		// .......... Class invariant is true except that perhaps
		// .......... b[h] belongs below one or both of its children
		while (k < size) { // while b[h] has a child
			// Set uc to the child to bubble with
			int uc= k + 1 == size || compareTo(k, k + 1) >= 0 ? k : k + 1;

			if (compareTo(h, uc) >= 0) return;
			swap(h, uc);
			h= uc;
			k= 2 * h + 1;
		}
	}

	/** If this is a min-heap, remove and return heap value with lowest priority. <br>
	 * If this is a max-heap, remove and return heap value with highest priority. <br>
	 * Expected time: logarithmic. Worst-case time: linear in the size of the heap.<br>
	 * Throw a NoSuchElementException if the heap is empty. */
	public T poll() {
		// TODO 7: When this method correct, these testing procedure will find no errors:
		// test60Poll_BubbleDown_NoDups thru
		// test66testDuplicatePriorities

		if (size <= 0) throw new NoSuchElementException("heap is empty");
		T v= b[0].value;
		swap(0, size - 1);
		map.remove(v);
		size= size - 1;
		bubbleDown(0);
		return v;
	}

	/** Change the priority of value v to p. <br>
	 * Expected time: logarithmic. Worst-case time: linear in the size of the heap.<br>
	 * Throw an IllegalArgumentException if v is not in the heap. */
	public void changePriority(T v, double p) {
		// TODO 8: When this method is correct, all testing procedures
		// will find no errors.

		Integer index= map.get(v);
		if (index == null) throw new IllegalArgumentException("v is not in the heap");
		double oldP= b[index].priority;
		b[index].priority= p;
		int t= compareTo(p, oldP);
		if (t == 0) return;
		if (t < 0) bubbleDown(index);
		else bubbleUp(index);
	}

	/** Return the heap values (only, not the priorities) in form [5, 3, 2]. */
	public String toStringValues() {
		StringBuilder resb= new StringBuilder("[");
		for (int h= 0; h < size; h= h + 1) {
			if (h > 0) resb.append(", ");
			resb.append(b[h].value);
		}
		return resb.append(']').toString();
	}

	/** Return the heap priorities in form [5.0, 3.0, 2.0]. */
	public String toStringPriorities() {
		StringBuilder resb= new StringBuilder("[");
		for (int h= 0; h < size; h= h + 1) {
			if (h > 0) resb.append(", ");
			resb.append(b[h].priority);
		}
		return resb.append(']').toString();
	}

	/** Create and return an array of size m. <br>
	 * This is necessary because generics and arrays don't inter-operate nicely. <br>
	 * A student in CS2110 would not be expected to know about the need for this <br>
	 * method and how to write it. <br>
	 * We searched the web to find out how to do it. */
	Pair[] createPairArray(int m) {
		return (Pair[]) Array.newInstance(Pair.class, m);
	}

	/** An object of class Pair houses a value and a priority. */
	class Pair {
		protected T value;             // The value
		protected double priority;   // The priority

		/** An instance with value v and priority p. */
		protected Pair(T v, double p) {
			value= v;
			priority= p;
		}

		/** Return a representation of this object. */
		@Override
		public String toString() {
			return "(" + value + ", " + priority + ")";
		}

		/** = "this and ob are of the same class and have equal val and priority fields." */
		@Override
		public boolean equals(Object ob) {
			if (ob == null || getClass() != ob.getClass()) return false;
			Pair obe= (Pair) ob;
			return value == obe.value && priority == obe.priority;
		}
	}
}