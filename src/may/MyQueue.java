package may;

import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Description 用栈实现队列
 * @Date 2021/5/30
 **/
public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    public void push(int x){
        inStack.push(x);
    }
    public int pop(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    public int peek(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    public boolean empty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
