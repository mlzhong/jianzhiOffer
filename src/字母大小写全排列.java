import java.util.ArrayList;
import java.util.List;

class 字母大小写全排列 {
    public static void main(String[] args){
        字母大小写全排列 ss=new 字母大小写全排列();
        System.out.println(ss.letterCasePermutation("a1b2"));
    }
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        dfs(S.toCharArray(), ans, 0);
        return ans;
    }

    public void dfs(char[] arr, List<String> e, int index) {
        if (index == arr.length) {
            e.add(String.valueOf(arr));
            return;
        }
        dfs(arr, e, index + 1);
        if (arr[index] < '0' || arr[index] > '9') {
            arr[index] ^= 32;
            dfs(arr, e, index + 1);
        }
    }
}
