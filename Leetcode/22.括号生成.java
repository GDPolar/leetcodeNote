package Leetcode;
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.63%)
 * Likes:    3561
 * Dislikes: 0
 * Total Accepted:    829.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start


class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        char[] path = new char[n * 2];
        f(path, n, 0, 0);
        return res;
    }

    // ln、rn 分别表示剩余可放的左括号和右括号的数量
    public void f(char[] path, int ln, int rn, int index) {
        if (index == path.length) {
            res.add(new String(path));
            return;
        }
        if (ln > 0) {
            path[index++] = '(';
            ln--;
            rn++;
            f(path, ln, rn, index);
            ln++;
            rn--;
            index--;
        }
        if (rn > 0) {
            path[index++] = ')';
            rn--;
            f(path, ln, rn, index);
            rn++;
            index--;
        }
    }
}
// @lc code=end

