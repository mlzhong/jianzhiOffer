import java.util.ArrayList;
import java.util.Stack;

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int nowSum=0;
        DFS(root,target,nowSum);
        return res;
//        while (!stack.empty()){
//            TreeNode top=stack.peek();
//            stack.pop();
//            list.add(top.val);
//            nowSum+=top.val;
//            if(top.left==null && top.right==null){
//                if(nowSum==target){
//                    res.add(list);
//                }
//            }
//            if(top.left!=null){
//                stack.push(top.left);
//            }
//            if(top.right!=null){
//                stack.push(top.right);
//            }
//
//        }
    }
    public void DFS(TreeNode root,int target,int nowSum){
        nowSum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(nowSum==target){
                res.add(list);
            }
        }
        if(root.left!=null){
            DFS(root.left, target, nowSum);
        }
        if(root.right!=null){
            DFS(root.right, target, nowSum);
        }

        //遍历完该节点左右子树下的所有路径了，这个节点的情况已经看完了，所以要离开这个节点，回到上一层节点
        list.remove(list.size()-1);
        nowSum-=root.val;

    }
}
