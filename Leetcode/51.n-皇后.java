import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (74.15%)
 * Likes:    1699
 * Dislikes: 0
 * Total Accepted:    292.2K
 * Total Submissions: 394K
 * Testcase Example:  '4'
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * 
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 
 * 
 * 
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[["Q"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    char[][] board;
    List<List<String>> res = new ArrayList<>();
    // 方法一：用二维数组模拟棋盘
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backTracking(n, n);
        return res;
    }

    private List<String> boardToStrings() {
        ArrayList<String> res = new ArrayList<>();    
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public void backTracking(int n, int left) {
        if (left == 0) {
            res.add(boardToStrings());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(n - left, i)) {
                board[n - left][i] = 'Q';      
                backTracking(n, left - 1);
                board[n - left][i] = '.';  
            }
        }
    }

    private boolean check(int curX, int curY) {
        for (int i = curX - 1; i >= 0; i--) {
            if (board[i][curY] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= curX && i <= curY; i++) {
            if (board[curX - i][curY - i] == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= curX && curY + i < board.length; i++) {
            if (board[curX - i][curY + i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 方法二：用 path 存储，index 为纵坐标，get(index) 为横坐标
    // List<List<String>> res = new ArrayList<>();
    // ArrayList<Integer> path = new ArrayList<>();
    // public List<List<String>> solveNQueens(int n) {
    //     backTracking(n, n);
    //     return res;
    // }

    // public void backTracking(int n, int left) {
    //     if (left == 0) {
    //         res.add(formatRes(path, n));
    //         return;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         if (check(path, i)) {
    //             path.add(i);        
    //             backTracking(n, left - 1);
    //             path.remove(path.size() - 1);
    //         }
    //     }
    // }

    // private boolean check(ArrayList<Integer> path, int cur) {
    //     for (int i = 0; i < path.size(); i++) {
    //         if (path.get(i) == cur || (Math.abs(cur - path.get(i)) == Math.abs(path.size() - i))) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    // private List<String> formatRes(ArrayList<Integer> path, int n) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < n; i++) {
    //         sb.append(".");
    //     }
    //     ArrayList<String> res = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         int pos = path.get(i);
    //         sb.replace(pos, pos + 1, "Q");
    //         res.add(sb.toString());
    //         sb.replace(pos, pos + 1, ".");
    //     }
    //     return res;
    // }


}
// @lc code=end

