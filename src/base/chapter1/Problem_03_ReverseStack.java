package base.chapter1;

import java.util.Stack;

/**
 * <br> Project: do-better
 * <br> Package: base.chapter1
 * <br> Description:
 * <br> 题目: 如何仅用递归函数和栈操作逆序一个栈
 * <br>           一个栈依次压入1,2,3,4,5 , 那么从栈顶到栈底分别为5,4,3,2,1 . 将这个栈转置后,从栈顶到栈底为1,2,3,4,5 ,
 * <br>       也就是实现栈中元素的逆序,但是只能用递归函数来实现,不能使用其他数据结构
 * <br> Date: Created in 15:03 2017/1/24.
 * <br> Modified By
 *
 * @author SiGen
 */
public class Problem_03_ReverseStack {
    public static Integer getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();

        if(stack.empty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);

            return last;
        }
    }
    public static void doReverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }else{
            int last = getAndRemoveLastElement(stack);
            doReverse(stack);
            stack.push(last);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        doReverse(stack);

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
