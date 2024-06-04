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

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    char[] path;
    int index = 0;
    public List<String> generateParenthesis(int n) {
        path = new char[n * 2];
        f(n, 0);
        return res;
    }

    // 表示从 index 后允许放 ln 个左括号和 rn 个右括号
    public void f(int ln, int rn) {
        if (index == path.length) {
            res.add(new String(path));
            return;
        }
        if (ln > 0) {
            path[index++] = '(';
            // 当前位置放了一个左括号后，右括号可放的数量加一（即与该左括号对应的右括号）
            f(ln - 1, rn + 1);
            index--;
        }
        if (rn > 0) {
            path[index++] = ')';
            // 当前位置放了一个右括号后，对左括号的数量没影响
            f(ln, rn - 1);
            index--;
        }
    }
}
// @lc code=end

