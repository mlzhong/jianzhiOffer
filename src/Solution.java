import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<Integer>();
        int p1=0,p2=0;
        for(int i=0;i<pushA.length; i++){
            stack.push(pushA[i]);
            int top=stack.peek();
            while (!stack.empty() && popA[p2]==stack.peek()){
                stack.pop();
                p2++;
            }
            if(p2==pushA.length){
                return true;
            }
        }

        return false;

    }
}
