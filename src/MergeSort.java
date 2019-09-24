import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] num = { 1, 3, 4, 8, 5, 10, 22, 15, 16 };
        mergesort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }



    private static void mergesort(int []arr,int start,int end){
        int []temp=new int[arr.length];
        int mid=start+(end-start)/2;
        if(start<end){
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            merge(arr,start,mid,end,temp);
        }


    }
    private static void merge(int[] arr,int start,int mid,int end,int[] temp){
        int p1=start;
        int p2=mid+1;
        int p3=0;
        while (p1<=mid && p2<=end){
            if(arr[p1]<arr[p2]){
                temp[p3++]=arr[p1++];
            }else temp[p3++]=arr[p2++];
        }
        while (p1<=mid){
            temp[p3++]=arr[p1++];
        }
        while (p2<=end){
            temp[p3++]=arr[p2++];
        }
        int j=start;
        for(int i=0;i<p3;i++){
            arr[j++]=temp[i];
        }

    }


}

