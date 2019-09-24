import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] num = { 1, 3, 4, 8, 5, 10, 22, 15, 16 };
        QuickSort.quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    private static void quickSort(int[] a,int start,int end){
        //int[] temp=new int[a.length];
        if(start<end){
            int position=cal_Position(a,start,end);
            quickSort(a,start,position);
            quickSort(a,position+1,end);
        }
    }

    private static int cal_Position(int[]a,int low,int high){
        int ref=a[low];
        //int p1=low;
        //int p2=high;
        int p3=0;
        while (low<high){
            while (low<high && a[high]>=ref){
                high--;
            }
            if(low<high){
                a[low++]=a[high];
            }
            while (low<high && a[low]<=ref){
                low++;
            }
            if(low<high){
                a[high--]=a[low];
            }
        }
        //当循环结束说明左指针和右指针已经相遇。并且相遇的位置是一个空出的位置，
        //这时候将基准数填入该位置，并返回该位置的下标，为分区做准备
        a[low]=ref;
        return low;

    }

}

