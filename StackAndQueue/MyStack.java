package DSandAL.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int res = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
