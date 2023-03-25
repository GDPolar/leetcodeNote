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
    // acabbaca
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 类似 45.组合问题所用的回溯，只不过组合问题中 path 每次添加的为当前选择的单个元素
        // 而此处添加是从 start 开始到当前选择的位置的子串
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int start) {
        if (start >= s.length()) {
            // 添加前的验证，保证了 path 中的字符串都是回文串
            res.add(new ArrayList<>(path));
            return;
        }
        String stemp;
        for (int i = start; i < s.length(); i++) {
            stemp = s.substring(start, i + 1);
            // 若待加入的子串不是回文串，跳过当前位置
            // 定义条件c：从 start 开始到当前选择的位置的子串是回文串
            // 与组合问题不同，此处不可以跳过后面位置，因为即使当前位置不满足条件c，但后续位置仍有可能满足条件c
            // 故不能 break
            if (!isPalindrome(stemp)) {
                continue;
            }
            path.add(stemp);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String p) {
        int start = 0, end = p.length() - 1;
        while (start < end) {
            if (p.charAt(start) != p.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

