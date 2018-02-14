import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    private SimpleStack<String> stack;
    private SimpleLinkedList<String> list;
    private SimpleQueue<String> queue;
    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
        stack = new SimpleStack<>();
        queue = new SimpleQueue<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
    }
    @Test
    public void Stack_testPeek() {
        String first = stack.pop();
        String second = stack.pop();
        String wanted = stack.peek();
        stack.push(second);
        stack.push(first);
        Assert.assertEquals(wanted,"b");
        Assert.assertEquals(stack.peek(),"d");
    }
    @Test
    public void Stack_testPush() {
        Assert.assertEquals(stack.peek(),"d");
        stack.push("e");
        Assert.assertEquals(stack.peek(),"e");
    }
    @Test
    public void Stack_testPop() {
        Assert.assertEquals(stack.pop(),"d");
        Assert.assertEquals(stack.pop(),"c");
        Assert.assertEquals(stack.pop(),"b");
        Assert.assertEquals(stack.pop(),"a");
        Assert.assertEquals(stack.size(),0);
    }
    @Test
    public void Stack_testSize() {
        Assert.assertEquals(stack.size(),4);
        stack.pop();
        Assert.assertEquals(stack.size(),3);
        stack.pop();
        Assert.assertEquals(stack.size(),2);
        stack.pop();
        Assert.assertEquals(stack.size(),1);
        stack.pop();
        Assert.assertEquals(stack.size(),0);
    }
    @Test
    public void Queue_testPeek() {
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        String d = queue.poll();
        String c = queue.poll();
        String w = queue.peek();
        queue.offer(c);
        queue.offer(d);
        Assert.assertEquals("c",w);
        Assert.assertEquals("c",queue.peek());
    }
    @Test
    public void Queue_testOffer() {
        Assert.assertEquals(queue.peek(),"a");
        queue.offer("e");
        Assert.assertEquals(queue.peek(),"a");
    }
    @Test
    public void Queue_testPoll() {
        Assert.assertEquals("a",queue.poll());
        Assert.assertEquals("b",queue.poll());
        Assert.assertEquals("c",queue.poll());
        Assert.assertEquals("d",queue.poll());
        Assert.assertEquals(0,queue.size());
    }
    @Test
    public void Queue_testSize() {
        Assert.assertEquals(queue.size(),4);
        queue.poll();
        Assert.assertEquals(queue.size(),3);
        queue.poll();
        Assert.assertEquals(queue.size(),2);
        queue.poll();
        Assert.assertEquals(queue.size(),1);
        queue.poll();
        Assert.assertEquals(queue.size(),0);
    }
    @Test
    public void List_testSize() {
        Assert.assertEquals(list.size(),4);
        list.remove(1);
        Assert.assertEquals(list.size(),3);
        list.remove(1);
        Assert.assertEquals(list.size(),2);
        list.remove(1);
        Assert.assertEquals(list.size(),1);
        list.remove(1);
        Assert.assertEquals(list.size(),0);
    }
    @Test
    public void List_testRemove() {
        Assert.assertEquals(list.remove(1),"a");
        Assert.assertEquals(list.size(),3);
        Assert.assertEquals(list.remove(3),"d");
        Assert.assertEquals(list.size(),2);
        Assert.assertEquals(list.remove(1),"b");
        Assert.assertEquals(list.size(),1);
        Assert.assertEquals(list.remove(1),"c");
        Assert.assertEquals(list.size(),0);
    }
    @Test
    public void List_testAdd() {
        SimpleLinkedList<String> n = new SimpleLinkedList<>();
        Assert.assertEquals(n.size(),0);
        Assert.assertEquals(list.size(),4);
        list.add("hi");
        Assert.assertEquals(list.size(),5);
        Assert.assertEquals(list.get(5),"hi");
        n.add("hi");
        Assert.assertEquals(n.get(1),"hi");
        Assert.assertEquals(n.size(),1);
    }
    @Test
    public void List_testInsert() {
        SimpleLinkedList<String> n = new SimpleLinkedList<>();
        Assert.assertEquals(n.size(),0);
        Assert.assertEquals(list.size(),4);
        list.insert(1,"hi");
        Assert.assertEquals(list.size(),5);
        Assert.assertEquals(list.get(1),"hi");
        Assert.assertEquals(list.get(2),"a");
        n.insert(1,"hi");
        Assert.assertEquals(n.get(1),"hi");
        Assert.assertEquals(n.size(),1);
    }
}
