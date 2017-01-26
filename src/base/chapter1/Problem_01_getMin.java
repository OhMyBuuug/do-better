package base.chapter1;

import java.util.Stack;

/**
 * <br> Project: do-better
 * <br> Package: base.chapter1
 * <br> Description:
 * <br> 题目:实现一个特殊的栈,在实现栈的基本功能的基础上,再实现返回栈中最小元素的操作
 * <br> 要求:
 * <br>     1. pop,push,getMin操作的时间复杂度都是O(1)
 * <br>     2. 设计的栈类型可以使用现成的栈结构
 * <br> Date: Created in 12:00 2017/1/24.
 * <br> Modified By
 *
 * @author SiGen
 */
public class Problem_01_getMin {
    // 存储栈,存储所有的输入元素,负责
    private Stack<Integer> normalStack;

    // 存储当前最小栈
    private Stack<Integer> keepMinsStack;

    // 构造方法
    public Problem_01_getMin(){
        normalStack = new Stack<Integer>();
        keepMinsStack = new Stack<Integer>();
    }
    /**
     * <br> Description: 向该特殊栈中压入一个元素
     * <br> Date: Created by SiGen in 13:11 2017/1/24.
     * <br> Modified By
     * @param integer 将要被压入栈中的元素
     */
    public void push(Integer integer){
        if (!normalStack.empty()){
            // 栈不为空时
            keepMinsStack.push(integer<=keepMinsStack.peek()?integer:keepMinsStack.peek());
        }else{
            // 当栈为空时.直接插入元素
            keepMinsStack.push(integer);
        }
        normalStack.push(integer);
        System.out.println("push: "+integer);
    }

    /**
     * <br> Description: 返回当前栈顶并将其从栈中删除
     * <br> Date: Created by SiGen in 13:12 2017/1/24.
     * <br> Modified By
     * @return Integer 栈顶元素
     */
    public Integer pop(){
        if (keepMinsStack.empty()){
            System.out.println("pop: "+normalStack.peek());
            throw new RuntimeException("Your stack is empty");
        }else{
            keepMinsStack.pop();
            return normalStack.pop();
        }
    }

    /**
     * <br> Description: 获得当前特殊栈中的最小元素的值
     * <br> Date: Created by SiGen in 13:14 2017/1/24.
     * <br> Modified By
     * @return Integer 栈中的最小元素
     */
    public Integer getMin(){
        if (keepMinsStack.empty()){
            throw new RuntimeException("Your stack is empty");
        }else{
            System.out.println("getMin:"+keepMinsStack.peek());
            return keepMinsStack.peek();
        }
    }

    public static void main(String[] args) {
        Problem_01_getMin problem_01_getMin=new Problem_01_getMin();

        problem_01_getMin.push(1);
        problem_01_getMin.push(2);
        problem_01_getMin.push(3);
        problem_01_getMin.push(1);

        problem_01_getMin.getMin();
        problem_01_getMin.pop();
        problem_01_getMin.pop();
        problem_01_getMin.push(0);


        problem_01_getMin.getMin();
    }
}
