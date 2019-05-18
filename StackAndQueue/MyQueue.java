package DSandAL.StackAndQueue;

import java.sql.SQLOutput;
import java.util.Stack;

class Main{
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());

    }
}

class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
        //myPoll();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        myPoll();
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        myPoll();
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        myPoll();
        return s2.isEmpty();
    }
    private void myPoll(){
        if(s2.isEmpty()){
            while(!s1.isEmpty())
                s2.add(s1.pop());
        }
    }
}
