public class SimpleQueue<T> {
    private SimpleLinkedList<T> list;
    public SimpleQueue() {
        list = new SimpleLinkedList<>();
    }
    public T poll() {
        return list.remove(list.size());
    }
    public void offer(T data) {
        list.insert(1,data);
    }
    public T peek() {
        return list.get(list.size());
    }
    public int size() { return list.size(); }
    @Override
    public String toString() {
        return list.toString();
    }
}
