public class Node<T> {
    public T data;
    public Node next;


    public Node(T data) { // Node head = new Node("Hello")
        // data passed in to constructor
        // data declared in class Node
        this.data = data;
        // obj.something
        // means obj's something
        // . == 's
        // node1.next.next.next.data
        // node1's next's next's next's data
    }
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
