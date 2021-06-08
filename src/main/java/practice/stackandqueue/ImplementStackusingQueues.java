package practice.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/04 11:15
 */
public class ImplementStackusingQueues {
    Queue<Integer> queue = new LinkedList<>();

    public void push(Integer num) {
        queue.add(num);
    }

    public Integer pop() {
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public Integer peek() {
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
        Integer peek = queue.peek();
        queue.add(queue.poll());
        return peek;
    }

    public Integer size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}