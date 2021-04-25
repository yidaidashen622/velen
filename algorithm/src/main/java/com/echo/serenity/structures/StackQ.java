package com.echo.serenity.structures;

import java.util.Stack;

/**
 * Created by xushu.
 * 两个栈实现一个队列
 */
public class StackQ<T> {

    private final Stack<T> stack1, stack2;

    public StackQ() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 添加元素到队尾
     */
    public void push(T element) {
        stack1.push(element);
    }

    /**
     * 返回队头元素
     */
    public T peek() {
        if (stack2.isEmpty()) {
            reverseElement();
        }
        return stack2.peek();
    }

    /**
     * 删除队头的元素并返回
     */
    public T pop() {
        if (stack2.isEmpty()) {
            reverseElement();
        }
        return stack2.pop();
    }


    /**
     * 判断队列是否为空
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void reverseElement() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
