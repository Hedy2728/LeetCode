package SwordToOffer.offer9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

public class TwoQueueToStack {
    /*实现了两个队列实现一个栈
    * 思路：两个队列相互捣腾，类似于Survivor的思想，保证非空队列有一个元素时pop即可*/
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
        } else if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.add(node);
        } else if (!queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
        }
    }

    public int pop() {
        int res = 0;
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                if (queue1.size() == 1) {
                    res = queue1.poll();
                    break;
                }
                queue2.add(queue1.poll());
            }
        } else if (!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                if (queue2.size() == 1) {
                    res = queue2.poll();
                    break;
                }
                queue1.add(queue2.poll());
            }
        }



        return res;
    }

    public static void main(String[] args) {
        TwoQueueToStack s = new TwoQueueToStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
