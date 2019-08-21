import java.util.logging.Level;


//归并排序代码
/*  分治法代码的典型代表， 先分左右两半（mergeSort自己），再合并
优点：稳定的，时间也稳定nlogn
缺点：占内存，需要temp数组存放临时的数组，待会整个排好序全部copy到arr
 */

public class Solution {
    int count=0;
    public int InversePairs(int [] array) {
        if(array.length>1){
            int []temp=new int[array.length];
            mergeSort(array, temp,0,array.length-1);
            return count%1000000007;

        }
        return 0;

    }
    private void mergeSort(int[] arr,int[] temp, int left, int right){
        if(left<right){ //分治到最后叶子节点的合理条件， 反之就不能再继续分治下去
            int mid=left+(right-left)/2;
            mergeSort(arr,temp,left, mid);
            mergeSort(arr,temp,mid+1,right);
            count+=merge(arr, temp, left, mid, right);
        }

    }

    private int merge(int[] arr,int[] temp,int left,int mid, int right){
        int p1=mid;
        int p2=right;
        int p3=0;  //temp数组是从大到小的
        int res=0; //逆序对个数
        while (p1>=left && p2>=mid+1){
            if(arr[p1]>arr[p2]){
                temp[p3++]=arr[p1--];
                res+=(p2-mid);
            }else{
                temp[p3++]=arr[p2--];
            }
        }
        while (p1>=left){
            temp[p3++]=arr[p1--];
        }


        //copy temp->arr
        int i,j;
        for(i=left, j=temp.length-1;i<=right;i++,j--){
            arr[i]=temp[j];
        }
        return res;
    }
}
