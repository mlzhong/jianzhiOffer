import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class 皇后n {

    // 不生成 nums 数组，并且使用成员变量

    private Set<Integer> col; //用set记录不可重复的，描述棋盘状态
    private Set<Integer> master;
    private Set<Integer> slave;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        backtrack(0, stack);
        return res;
    }

    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);

                backtrack(row + 1, stack);

                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }
}
 //链接：https://leetcode-cn.com/problems/n-queens/皇后n/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/

