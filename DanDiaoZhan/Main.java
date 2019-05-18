package DSandAL.DanDiaoZhan;

import java.util.HashMap;
import java.util.Stack;

/*
   单调栈求它最近的更大或者更小的元素
 */
public class Main {
    public static void main(String[] args) {
        int[]  A = {10,9,2,5,3,7,101,18};
        int[]  res = nextBigger(A);
        for(int i:res)
            System.out.print(i + " ");
        System.out.println();
        int[]  res1 = nextSmaller(A);
        for(int i:res1)
            System.out.print(i + " ");
        System.out.println();
        int[]  res2 = lastSmaller(A);
        for(int i:res2)
            System.out.print(i + " ");
       

    }
    private static int[] nextBigger(int[] A){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i = A.length - 1;i >= 0;i--){
            while(!stack.isEmpty() && A[i] > stack.peek())   stack.pop();
            if(stack.isEmpty())  res[i] = -1;
            else   res[i] = stack.peek();
            stack.add(A[i]);
        }
        return res;
    }
    private static int[] nextSmaller(int[] A){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i = A.length - 1;i >= 0;i--){
            while(!stack.isEmpty() && A[i] < stack.peek())  stack.pop();
            if(stack.isEmpty())  res[i] = -1;
            else   res[i] = stack.peek();
            stack.add(A[i]);
        }
        return res;
    }
    private static int[] lastSmaller(int[] A){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i = 0;i < A.length;i++){
            while(!stack.isEmpty() && A[i] < stack.peek())  stack.pop();
            if(stack.isEmpty())  res[i] = -1;
            else   res[i] = stack.peek();
            stack.add(A[i]);
        }
        return res;
    }
    //求后面离它最远的，也可以用单调栈，但是是否能求数组。
    public int maxWidthRamp(int[] A) {
        Stack<Integer> s = new Stack<>();
        //保证前面离它最远的一定在栈里
        for(int i = 0;i < A.length;i++)
            if(s.isEmpty() || A[i] < A[s.peek()])
                s.add(i);
        int res = 0;
        for(int i = A.length - 1;i >= 0;i--){
            while(!s.isEmpty() && A[i] >= A[s.peek()]) {
                int j = s.pop();
                res = Math.max(i - j,res);
            }
        }
        return res;
    }

}
