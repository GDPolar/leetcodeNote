import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (73.41%)
 * Likes:    1441
 * Dislikes: 0
 * Total Accepted:    275.1K
 * Total Submissions: 375K
 * Testcase Example:  '"aab"'
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 
 * 回文串 是正着读和反着读都一样的字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "a"
 * 输出：[["a"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[] array;
    int[][] dp;
    public List<List<String>> partition(String s) {
        // 类似 45.组合问题所用的回溯，只不过组合问题中 path 每次添加的为当前选择的单个元素
        // 而此处添加是从 start 开始到当前选择的位置的子串
        array = s.toCharArray();
        dp = new int[array.length + 1][array.length + 1];
        f(0);
        return res;
    }
    private void f(int begin) {
        if (begin >= array.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < array.length; i++) {
            if (isPalindrome(begin, i) > 0) {
                list.add(new String(array, begin, i - begin + 1));
                f(i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private int isPalindrome(int begin, int end) {
        if (dp[begin][end] != 0) {
            return dp[begin][end];
        }
        if (begin >= end) {
            dp[begin][end] = 1;
        } else if (array[begin] == array[end]) {
            dp[begin][end] = isPalindrome(begin + 1, end - 1);
        } else {
            dp[begin][end] = -1;
        }
        return dp[begin][end];
    }
}
// @lc code=end

