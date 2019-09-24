import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;

    }

    public TreeNode() {
    }


    public static TreeNode create_tree(String[] a) {
        ArrayList<TreeNode> tree=new ArrayList<TreeNode>();
        for(int i=0;i<a.length;i++){
            if(a[i]!="#")
                tree.add(new TreeNode(Integer.parseInt(a[i])));
            else tree.add(null);

        }
        int n=a.length;
        for(int i=0;i<=n/2-1;i++){
            if(2*i+1<=n-1){ //节点i的左孩子2i+1,右孩子2i+2
                tree.get(i).left=tree.get(2*i+1);
            }
            if(2*i+2<=n-1){
                tree.get(i).right=tree.get(2*i+2);
            }
        }
        return tree.get(0);

    }

    //        Queue<String> queue = new LinkedList<String>();
    //添加 queue.offer("a");
    //queue.poll();  //返回第一个元素，并在队列中删除
    public static TreeNode create_tree_new(String[] a) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(a.length==0) return null;
        int k=0;
        String root_str=a[k++];
        TreeNode root=new TreeNode(Integer.parseInt(root_str));
        queue.add(root);
        String null_str="#";
        while (!queue.isEmpty()){
            if(k==4) {
                int i=9;
            }
            TreeNode top=queue.poll();
            if(top==null){
                continue;
            }
            String left=null_str;
            String right=null_str;
            if(k<a.length){
                left=a[k++];
            }
            if(k<a.length){
                right=a[k++];
            }

            TreeNode leftnode=null;
            TreeNode rightnode=null;
            if(!null_str.equals(left) ){
                leftnode=new TreeNode(Integer.parseInt(left));
            }
            if(!null_str.equals(right)){
                rightnode=new TreeNode(Integer.parseInt(right));
            }
            queue.offer(leftnode);
            queue.offer(rightnode);
            top.left=leftnode;
            top.right=rightnode;


        }
        return root;


    }


    public static void PrintFromTopToBottom(TreeNode root) {
        //Queue<Integer> queue=new Queue<Integer>();
        ArrayList<Integer> res = new ArrayList<java.lang.Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return ;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode top=queue.peek();
            res.add(top.val);
            queue.poll();
            if(top.left!=null) queue.add(top.left);
            if(top.right!=null) queue.add(top.right);
        }
        System.out.println(res.toString());

    }


    public static void  preOrderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

}

