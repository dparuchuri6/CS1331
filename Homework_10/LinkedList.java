//I worked on the homework assignment alone,
//using only course materials

/**
 * Adventurer class is template from which
 * other heroes are created from.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-18-04
 * @param <T> generic parameter
 */

public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Linked List no arg constructor.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Getter method for LL head field.
     * @return head field
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Getter method for LL tail field.
     * @return tail field
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Adds the given data to the list at the specified index.
     * For example, `add(0, "Hello")` for a List of generic type String would add `"Hello"`
     * to the beginning of the list.
     * @param index The index at which data will be added
     * @param data  the data to add
     * @throws IllegalArgumentException when invalid input entered
     */
    public void add(int index, T data) throws IllegalArgumentException {
        Node<T> node = new Node<>(data);

        if ((index < 0) || (index > size()) || (data == null)) {
            throw new IllegalArgumentException();
        } else if ((head == null) && (index == 0)) {
            head = node;
            tail = node;
        } else if (index == 0) {
            node.setNext(head);
            head = node;
        } else if (index == size()) {
            tail.setNext(node);
            tail = node;
        } else {
            Node<T> ptr = getItem(index - 1);
            node.setNext(ptr.getNext());
            ptr.setNext(node);
        }
    }

    /**
     * Removes the data at the given index from the list, and then returns it.
     * @param index the index to remove from
     * @return the removed piece of data
     * @throws IllegalArgumentException when invalid input entered
     */
    public T remove(int index) throws IllegalArgumentException {
        Node<T> ptr = head;

        if ((index < 0) || (index >= size()) || (this == null)) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            ptr = head;
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else if (index == (size() - 1)) {
            ptr = tail;
            tail = getItem(size() - 2);
            tail.setNext(null);
            return ptr.getData();
        } else if (index < size()) {
            Node<T> node;
            node = getItem(index);
            ptr = getItem(index - 1);
            ptr.setNext(ptr.getNext().getNext());
            return node.getData();
        } else {
            ptr = null;
        }
        if (ptr != null) {
            return ptr.getData();
        }
        return null;
    }

    /**
     * Returns the data at the specified index in the list.
     * @param index the index to return from
     * @return the data at the specified index
     * @throws IllegalArgumentException when invalid input entered
     */
    public T get(int index) throws IllegalArgumentException {

        if ((index < 0) || (index >= size()) || (this == null)) {
            throw new IllegalArgumentException();
        }

        return (T) (getItem(index).getData());
    }

    /**
     * returns **a new List object** containing *the first n elements in the current List*.
     * For example, if our list was [1, 2, 3, 4, 5, 6], subList(2) should
     * return a new list containing [1, 2], and subList(3)
     * should return a new list containing [1, 2, 3].
     * @param  n The amount of elements to take
     * @return a new List object containing the first n elements in the current list, as described above
     * @throws IllegalArgumentException when invalid input entered
     */
    public List<T> subList(int n) throws IllegalArgumentException {
        List<T> list = new LinkedList<T>();

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n >= size()) {
            for (int i = 0; i < size(); i++) {
                list.add(i, this.get(i));
            }
        } else {
            for (int i = 0; i < n; i++) {
                list.add(i, this.get(i));
            }
        }

        return list;
    }

    /**
     * Returns the number of items in this list.
     * @return the number of items in this list
     */
    public int size() {
        int count  = 0;
        Node<T> node = head;

        while (node != null) {
            count++;
            node = node.getNext();
        }

        return count;
    }

    /**
     * adds data to the Queue
     * Think about where in the list the data should be added in
     * order to make the ordering compatible.
     * @param data the data to add to the queue.
     */
    public void enqueue(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    /**
     * removes the oldest piece of data from our Queue; that is,
     * the first thing we added, or the item that has been waiting the longest
     * to be removed.  Think about from where in the list we should remove to
     * make this work.
     * @return the dequeued item
     */
    public T dequeue() {

        Node<T> node;
        T data;
        if (size() == 0) {
            return null;
        } else if (size() == 1) {
            data = head.getData();
            head = null;
            tail = null;
        } else {
            node = getItem(size() - 2);
            data = node.getNext().getData();
            node.setNext(null);
            tail = null;
        }
        return data;
    }

    /**
     * Returns the number of items in this list.
     * @param index index that needs to be found
     * @return node at the specified index
     */
    public Node<T> getItem(int index) {
        Node<T> node = head;
        int count  = 0;

        if (index >= size()) {
            return null;
        }

        while (node != null) {
            if (count == index) {
                return node;
            }
            node = node.getNext();
            count++;
        }
        return null;
    }
}