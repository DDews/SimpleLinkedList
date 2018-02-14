public class SimpleStack<T> {
    private SimpleLinkedList<T> list;
    public SimpleStack() {
        list = new SimpleLinkedList<>();
    }
    public T peek() {
        return list.get(list.size());
    }
    public T pop() {
        return list.remove(list.size());
    }
    public void push(T data) {
        list.add(data);
    }
    public int size() {
        return list.size();
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
