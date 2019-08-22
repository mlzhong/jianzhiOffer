import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int p1=0;
        int p2=array.length-1;
        ArrayList<Integer> a1list=new ArrayList<Integer>();
        ArrayList<Integer> a2list=new ArrayList<Integer>();
        while (p1<p2){
            if(array[p1]+array[p2]==sum){
                a1list.add(array[p1]);
                a2list.add(array[p2]);
                p1++;
            }else if(array[p1]+array[p2]<sum){
                p1++;
            }else p2--;
        }
        int min=Integer.MAX_VALUE;
        int res1=0;
        int res2=0;
        int flag=0;
        for(int i = 0; i<a1list.size(); i++){
            if(a1list.get(i)*a2list.get(i)<min){
                min=a1list.get(i)*a2list.get(i);
                res1=a1list.get(i);
                res2=a2list.get(i);
                flag=1;
            }
        }
        if(flag==0) return res;
        res.add(res1);
        res.add(res2);
        return res;

    }
}
