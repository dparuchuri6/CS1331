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


public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Node two arg constructor.
     * @param data data that node holds
     * @param next pointer to next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Node one arg constructor.
     * @param data data that node holds
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Getter method for node data field.
     * @return data field
     */
    public T getData() {
        return this.data;
    }

    /**
     * Getter method for node next field.
     * @return pointer to next node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Setter method for next pointer.
     * @param next pointer to node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}