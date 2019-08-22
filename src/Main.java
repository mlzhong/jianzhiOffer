import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Solution ss =new Solution();
        int target=5;
        //int [][]array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int []seq={1,2,3,4,8,9,9,9,9};
        int []arr={10,5,12,4,7};

        char []chartree={'1','2','3','4','5','#','6','#','#','7'};
        TreeNode root=null;
        root=create_by_arr_char(chartree);
        preOrderTraverse(root);
        PrintFromTopToBottom(root);
        int target_num=22;
        int []input={
        };
        ArrayList<Integer> res = ss.FindNumbersWithSum(seq, 11);
        System.out.println(res);

        //System.out.println(ss.VerifySquenceOfBST(seq));
    }

    public static void  preOrderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static TreeNode create_by_arr_char(char[] a) {
        ArrayList<TreeNode> tree=new ArrayList<TreeNode>();
        for(int i=0;i<a.length;i++){
            if(a[i]!='#')
                tree.add(new TreeNode(Integer.parseInt(String.valueOf(a[i]))));
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

    public static TreeNode create_by_arr(int[] a) {
        ArrayList<TreeNode> tree=new ArrayList<TreeNode>();
        for(int i=0;i<a.length;i++){
            tree.add(new TreeNode(a[i]));

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
    public static void create(int[] a, int i, TreeNode root){
//        ArrayList<TreeNode> tree=new ArrayList<TreeNode>(a.length);
//        for(int i=0;i<a.length;i++){
//            tree.get(i).val=a[i];
//        }
//        int n=a.length;
//        for(int i=0;i<=n/2-1;i++){
//            if(2*i+1<=n-1){ //节点i的左孩子2i+1,右孩子2i+2
//                tree.get(i).left=tree.
//            }
//        }
        int n=a.length;
        TreeNode newNode=new TreeNode(a[i]);
        if(root==null){
            root=newNode;
        }
        if(i<=n/2-1){  //i<=n/2-1代表有孩子的人
            if(root.left==null)
            create(a,2*i+1, root.left);

            if(root.right==null)
            create(a, 2*i+2, root.right);

        }

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



}
