import java.io.File;
import java.util.Scanner;

public class SimpleLinkedList<T> {
    public Node<T> head;
    public int size = 0;
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }
    public SimpleLinkedList(File inputFile) {
        head = null;
        size = 0;
        try {
            Scanner in = new Scanner(inputFile);
            while (in.hasNext()) {
                String line = in.nextLine();
                add((T)line);
            }
        } catch (Exception e) {
            // oops
            e.printStackTrace();
        }
    }
    public T remove(int index) {
        if (head == null) return null;
        if (index < 1 || index > size) return null;
        size--;
        if (index == 1) {
            T data = head.data;
            head = head.next;
            return data;
        }
        T data = null;
        Node current = head;
        int i = 2;
        while (current.next != null && i < index) {
            current = current.next;
            i++;
        }
        if (i == index + 1) {
            data = (T)current.next.data;
            if (current.next != null) {
                current.next = current.next.next;
            }
            if (i == 1) head = current.next;
            return data;
        } else {
            data = (T)current.next.data;
            current.next = null;
            return data;
        }
    }
    public void insert(int index, T data) {
        if (index < 1 || index > size + 1) return;
        if (index == 1) {
            Node after = head;
            head = new Node(data);
            head.next = after;
        }
        else {
            int i = 1;
            Node current = head;
            while (i < index && current.next != null) {
                i++;
                current = current.next;
            }
            Node after = current.next;
            current.next = new Node(data);
            current.next.next = after;
        }
        size++;
    }
    public T get(int index) { //list.get(2) == 2nd item in list
        if (head == null) return null;
        if (index == 1) return head.data;
        T data = null;
        Node current = head;
        int i = 1;
        while (current.next != null && i < index) {
            current = current.next;
            i++;
        }
        if (i == index) {
            return (T) current.data;
        }
        return null;
    }
    public void add(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
        size++;
    }
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        Node current = head;
        b.append(current.data);
        while (current.next != null) {
            current = current.next;
            b.append(", ");
            b.append(current.data);
        }
        b.append("]");
        return b.toString();
    }
}
