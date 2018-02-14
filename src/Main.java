import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter filename: ");
       // String filename = keyboard.nextLine();
        //System.out.println(new File(filename).getAbsolutePath());
        //SimpleLinkedList<String> words = new SimpleLinkedList<>(new File(filename));
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);
        // [a, b, c, d]
        //  ^-- top
        String first = stack.pop();
        String second = stack.pop();
        String wanted = stack.peek();
        stack.push(second);
        stack.push(first);
        System.out.println(wanted + " should be b");

        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        String d = queue.poll();
        String c = queue.poll();
        String w = queue.peek();
        queue.offer(c);
        queue.offer(d);
        System.out.println(w + " should be c");


    }
}
