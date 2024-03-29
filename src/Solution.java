import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[]args){
        Solution ss=new Solution();
        int []nums={1,2,3};
        //String []chartree={"-10","9","20","#","#","15","7"};
        String []chartree={"5","4","8","11","#","13","4","7","2","#","#","#","1"};

        TreeNode root=null;
        //root=create_by_arr_char(chartree);
        root=TreeNode.create_tree_new(chartree);
        TreeNode.preOrderTraverse(root);
        TreeNode.PrintFromTopToBottom(root);
        System.out.println("//////////");
        System.out.println(ss.maxPathSum(root));


        Stack<TreeNode> stack=new Stack<>();
        stack.add(null);
        stack.add(null);
        stack.add(new TreeNode(2));
        TreeNode top=stack.pop();
        TreeNode top2=stack.pop();

        stack.add(new TreeNode(22));



    }

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        HashMap<TreeNode, Integer> mapColor=new HashMap<>();
        Stack<TreeNode> stack=new Stack<>();
        mapColor.put(root, 0); //0 white
        stack.add(root);
        int max=Integer.MIN_VALUE;
        while (!stack.empty()){
            TreeNode topNode=stack.pop();
            if(topNode==null){
                continue;
            }
            if(mapColor.get(topNode)==0){  //后序：左右根， 入栈就反过来：根右左
                stack.add(topNode);
                mapColor.put(topNode, 1);

                if(topNode.right!=null){
                    mapColor.put(topNode.right, 0);
                    stack.add(topNode.right);
                }
                if(topNode.left!=null){
                    mapColor.put(topNode.left, 0);
                    stack.add(topNode.left);
                }
            }else{
                if(topNode.left==null && topNode.right==null){
                    max=Math.max(max, topNode.val);
                }
                int left_max=Integer.MIN_VALUE,right_max=Integer.MIN_VALUE,in_max=topNode.val;
                if(topNode.left!=null){
                    left_max=topNode.val+topNode.left.val;
                    if(topNode.left.val>=0) in_max+=topNode.left.val;
                }
                if(topNode.right!=null){
                    right_max=topNode.val+topNode.right.val;
                    if(topNode.right.val>=0) in_max+=topNode.right.val;
                }
                int node_max=Math.max(in_max,Math.max(left_max,right_max));
                topNode.val= Math.max(topNode.val,Math.max(left_max,right_max)); //必须经过topnode节点
                max=Math.max(max, node_max);

            }
        }
        return max;

    }


}
