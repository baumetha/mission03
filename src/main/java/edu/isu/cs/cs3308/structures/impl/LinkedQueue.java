package edu.isu.cs.cs3308.structures.impl;

 import edu.isu.cs.cs3308.structures.Queue;

/**
 * @author Isaac Griffith
 */
public class LinkedQueue<E> implements Queue<E> {

    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    /**
     * @return The number of elements in the queue
     */
    public int size(){return list.size();}

    /**
     * @return tests whether the queue is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Inserts an element at the end of the queue.
     *
     * @param element Element to be inserted.
     */
    public void offer(E element){
        if (element == null)
            return;
        else
            list.addLast(element);
    }

    /**
     * @return The value first element of the queue (with out removing it), or
     * null if empty.
     */
    public E peek(){
        if (list.isEmpty())
            return null;
        else
            return list.first();
    }

    /**
     * @return The value of the first element of the queue (and removes it), or
     * null if empty.
     */
    public E poll(){
        if(list.isEmpty())
            return null;
        else
            return list.removeFirst();
    }

    /**
     * Prints the contents of the queue starting at top, one item per line. Note
     * this method should not empty the contents of the queue.
     */
    public void printQueue(){
        list.printList();
    }

    /**
     * Tranfers the contents of this queue into the provided queue. The contents
     * of this queue are to found in reverse order at the top of the provided
     * queue. This queue should be empty once the transfer is completed. Note
     * that if the provided queue is null, nothing is to happen.
     *
     * @param into The new queue onto which the reversed order of contents from
     * this queue are to be transferred to the top of, unless the provided queue
     * is null.
     */
    public void transfer(Queue<E> into){
        if(isEmpty() || into == null) return;
        while (!into.isEmpty()){
            offer(into.poll());
        }
        reverse();
        while (!isEmpty()){
            into.offer(poll());
        }
    }
    /**
    /**
     * Reverses the contents of this queue.
     */
    public void reverse() {
        LinkedStack<E> stack = new LinkedStack<>();
        while (!isEmpty()){
            stack.push(poll());
        }
        while (!stack.isEmpty()){
            offer(stack.pop());
        }
    }

    /**
     * Merges the contents of the provided queue onto the bottom of this queue.
     * The order of both queues must be preserved in the order of this queue
     * after the method call. Furthermore, the provided queue must still contain
     * its original contents in their original order after the method is
     * complete. If the provided queue is null, no changes should occur.
     *
     * @param from Queue whose contents are to be merged onto the bottom of
     * this queue.
     */
    public void merge(Queue<E> from){
        if (from == null) return;
        while (!from.isEmpty()){
            offer(from.poll());
        }
    }
}
