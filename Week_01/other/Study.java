package other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: ZhaoYiChen
 * @create: 2021-01-27 16:08
 **/
public class Study {
    public static void main(String[] args) {

       // testStack();//栈Demo

        //testQueue();//队列Demo

        testDeque();//双端队列


    }

    private static void testDeque() {
        Deque<String> dequeA = new LinkedList<>();
        dequeA.addFirst("a");
        dequeA.addFirst("b");
        dequeA.offerFirst("c");
        System.out.println("当前双端队列a的元素有："+dequeA);

        String removeFirstElement = dequeA.removeFirst();
        System.out.println("移除removeFirst当前双端队列第一个元素为："+removeFirstElement);

        String pollFirstElement = dequeA.pollFirst();
        System.out.println("移除pollFirst当前双端队列第一个元素为："+pollFirstElement);

        String getFirstElement = dequeA.getFirst();
        System.out.println("查询getFirst当前双端队列第一个元素："+getFirstElement);

        String peekFirstElement = dequeA.peekFirst();
        System.out.println("查询peekFirst当前双端队列第一个元素："+peekFirstElement);


        Deque<String> dequeB= new LinkedList<>();
        dequeB.addLast("A");
        dequeB.addLast("B");
        dequeB.offerLast("C");
        System.out.println("当前双端队列b的元素有："+dequeB);

        String removeLastElement = dequeB.removeLast();
        System.out.println("移除removeLast当前双端队列最后一个元素为："+removeLastElement);

        String pollLastElement = dequeB.pollLast();
        System.out.println("移除pollList当前双端队列最后一个元素为："+pollLastElement);

        String getLastElement = dequeB.getLast();
        System.out.println("查询getList当前双端队列最后一个元素："+getLastElement);

        String peekListElement = dequeB.peekLast();
        System.out.println("查询peekList当前双端队列最后一个元素："+peekListElement);
    }

    private static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("当前栈的元素有："+stack);

        Integer removeElement = stack.pop();
        System.out.println("移除当前栈顶元素为："+removeElement);

        Integer topElement = stack.peek();
        System.out.println("当前栈顶元素为："+topElement);

        int searchElement = stack.search(3);
        System.out.println("当前元素3的位置为："+ searchElement);
    }

    private static void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.add("five"); //添加失败后抛异常
        System.out.println("当前队列的元素有："+queue);

        String polledElement = queue.poll();
        System.out.println("移除poll当前队列第一个元素: "+polledElement);

        String removedElement = queue.remove(); //删除失败后抛异常
        System.out.println("移除remove当前队列第一个元素: "+removedElement);

        String peekedElement = queue.peek();
        System.out.println("查询peek当前队列第一个元素: "+peekedElement);

        String element = queue.element();
        System.out.println("查询element当前队列第一个元素: "+element);

    }
}
