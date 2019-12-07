package jrJava.barbarianAttack3_linkedList;

import java.util.Iterator;

/**
 * 
 * @author Shashin Gupta
 *
 */

public class LinkedList<E> {

	public Link<E> first;

	public void insert(E obj) {
		Link<E> link = new Link<E>(obj);
		link.next = first;
		first = link;
	}

	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		public Link<E> current;
		public Link<E> previous;

		public void remove() {
			if (current == null)
				throw new UnsupportedOperationException("Removal-Op");
			if (current == first) {
				first = current.next;
				current = null;
				return;
			}
			previous.next = current.next;
			current = previous;
		}

		public boolean hasNext() {
			if (current == null)
				return first != null;
			return current.next != null;
		}

		public E next() {
			if (current == null) {
				current = first;
				return current.obj;
			}
			previous = current;
			current = current.next;
			return current.obj;
		}

	}

	private class Link<B> {

		public Link<B> next;
		public B obj;

		public Link(B obj) {
			this.obj = obj;
		}

		public void add(Link<B> next) {
			this.next = next;
		}

		public String toString() {
			return obj.toString();
		}

		public boolean equals(Object o) {
			if (!(o instanceof Link))
				return false;
			Link<B> other = (Link<B>) o;
			return obj.equals(other.obj);
		}
	}

}
