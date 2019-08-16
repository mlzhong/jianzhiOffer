import java.lang.annotation.Target;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Solution ss =new Solution();
        int target=5;
        //int [][]array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int []array={6501,6828,6963,7036,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(ss.minNumberInRotateArray(array));
    }
}
