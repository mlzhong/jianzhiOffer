import java.util.*;

class 全排列 {
    ArrayList<List<Integer>> res=new ArrayList<>();
    public static void main(String[]args){
        全排列 ss=new 全排列();
        int []nums={1,2,3};
        System.out.println(ss.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();//用过的元素放这里
        Stack<Integer> stack=new Stack<Integer>();//结果一条root到叶子的path放这里
        dfs(nums,stack,set);
        return res;
    }
    private void dfs(int[] nums,Stack<Integer> stack,HashSet<Integer> set){
        if(stack.size()==nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                stack.push(nums[i]);
                dfs(nums, stack, set);
                //恢复现场
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                set.remove(nums[i]);
                stack.pop();
            }
        }
    }


}
