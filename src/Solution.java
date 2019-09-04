import java.util.*;

class Solution {
    int[] time_h={1,2,4,8,1,2,4,8,16,32};
    List<String> res=new ArrayList<String>();
    HashSet<Integer> set=new HashSet<Integer>();
    HashSet<String> res_set=new HashSet<String>();
    public static void main(String[] args){
        Solution ss=new Solution();
        System.out.println(ss.readBinaryWatch(7));
    }

    public List<String> readBinaryWatch(int num) {
        //int[] hour={1,2,4,8};
//        for(int i=0;i<12;i++){
//            for(int j=0;j<60;j++){
//                if(Integer.bitCount(i)+Integer.bitCount(j)==num){
//                    res.add(String.format("%d.%02d",i,j));
//                }
//            }
//        }

        DFS(0,0,0,num);
        res.addAll(res_set);
        return res;

    }
    private void DFS(int lighted,int hour,int min,int num){
        if(lighted==num){
            //递归出口
            if(legalTime(hour,min)){
                //res.add(String.format("%d:%02d",hour,min));
                res_set.add(String.format("%d:%02d",hour,min));
            }
            return;
        }
        for(int i=0;i<time_h.length;i++){
            if(i < 4){
                if(!set.contains(i)){
                    set.add(i);
                    DFS(lighted + 1, hour + time_h[i], min,num);
                    //DFS结束，返回上一层要还原状态
                    set.remove(i);
                }
            }else{
                if(!set.contains(i)){
                    set.add(i);
                    DFS(lighted + 1, hour, min+time_h[i], num);
                    set.remove(i);
                }
            }


        }
    }
    private boolean legalTime(int hour,int min){
        if(hour<12 && min<60){
            return true;
        }
        return false;
    }
}
