package base.chapter1;

import java.util.Stack;

/**
 * <br> Project: do-better
 * <br> Package: base.chapter1
 * <br> Description:
 * <br>     题目: 编写一个类,用两个栈实现队列,支持队列的基本操作(add,poll,peek)
 * <br>     Date: Created in 13:56 2017/1/24.
 * <br> Modified By
 *
 * @author SiGen
 */
public class Problem_02_StackQueue {
    // 存储中间变量
    private Stack<Integer> pushStack;
    // 存储伪队列
    private Stack<Integer> popStack;

    // 构造方法
    public Problem_02_StackQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    /**
     * <br> Description: 向伪队列中加入元素
     * <br> Date: Created by SiGen in 14:07 2017/1/24.
     * <br> Modified By
     *
     * @param newInteger 将被加入队列的元素
     */
    public void add(Integer newInteger) {
        System.out.println("push: " + newInteger);
        pushStack.push(newInteger);
    }

    /**
     * <br> Description: 返回队列的头部,并从队列中去除该元素
     * <br> Date: Created by SiGen in 14:19 2017/1/24.
     * <br> Modified By
     *
     * @return Integer 队列的第一个元素
     */
    public Integer poll() {
        if (pushStack.empty() && popStack.empty()) {
            throw new RuntimeException("Your queue is empty");
        } else if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        System.out.println("poll: " + popStack.peek());
        return popStack.pop();
    }

    /**
     * <br> Description: 返回队首元素的值
     * <br> Date: Created by SiGen in 14:20 2017/1/24.
     * <br> Modified By
     *
     * @return Integer 队首元素的值
     */
    public Integer peek() {
        if (popStack.empty() && pushStack.empty()) {
            throw new RuntimeException("Your queue is empty");
        } else if (popStack.empty()) {
            popStack.push(pushStack.pop());
        }
        System.out.println("peek: " + popStack.peek());
        return popStack.peek();
    }

    public static void main(String[] args) {
        Problem_02_StackQueue problem_02_stackQueue = new Problem_02_StackQueue();

        problem_02_stackQueue.add(0);
        problem_02_stackQueue.add(1);
        problem_02_stackQueue.add(2);
        problem_02_stackQueue.add(3);
        problem_02_stackQueue.add(4);
        problem_02_stackQueue.add(5);

        problem_02_stackQueue.poll();

        problem_02_stackQueue.poll();

        problem_02_stackQueue.peek();
    }
}
