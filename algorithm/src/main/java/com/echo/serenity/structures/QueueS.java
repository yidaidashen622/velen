package com.echo.serenity.structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xushu.
 * 两个队列实现一个栈
 */
public class QueueS<T> {
    private final Queue<T> queue;
    private T top;

    public QueueS() {
        this.queue = new LinkedList<>();
    }

    /**
     * 添加元素到栈顶
     */
    public void push(T element) {
        top = element;
        queue.offer(element);
    }

    /**
     * 删除栈顶的元素并返回
     */
    public T pop() {
        int size = queue.size();
        for (int i = 0; i < size - 2; i++) {
            queue.offer(queue.poll());
        }
        top = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    /**
     * 返回栈顶元素
     */
    public T top() {
        return top;
    }

    /**
     * 判断栈是否为空
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
