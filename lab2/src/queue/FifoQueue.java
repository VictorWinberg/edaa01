package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		last = null;
		size = 0;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> e = new QueueNode<E>(x);
		if (last == null) {
			e.next = e;
		} else {
			e.next = last.next;
			last.next = e;
		}
		last = e;
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		E temp = null;
		if (size == 1) {
			temp = last.element;
			last = null;
		} else if (size > 1){
			temp = last.next.element; // last.next = first
			last.next = last.next.next;
		}
		size--;
		return temp;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null)
			return null;
		return last.next.element;
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		/* Konstruktor */
		private QueueIterator() {
			pos = last;
		}

		public boolean hasNext() {
			return size != 0 && pos != null;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E temp = pos.next.element;
			pos = pos.next;
			if (pos == last)
				pos = null;
			return temp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

}