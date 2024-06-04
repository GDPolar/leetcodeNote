package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (45.61%)
 * Likes:    2890
 * Dislikes: 0
 * Total Accepted:    561.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 。
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * ^m == s.length
 * ^n == t.length
 * 1 <= m, n <= 10^5
 * s 和 t 由英文字母组成
 * 
 * 
 * 
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 表示每个字符待需要的数量
        Map<Character, Integer> need = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 判断窗口是否包含了 t 的所有元素，避免每次去遍历 need，增加耗时
        int needCnt = t.length();
        int resBegin = 0;
        int resEnd = Integer.MAX_VALUE;

        // 滑动窗口右边界开始移动
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // 包含t，待需要的数量减一
            if (need.getOrDefault(c, 0) > 0) {
                needCnt--;
            }
            need.put(c, need.getOrDefault(c, 0) - 1);

            // 都包含了，此时右边界不动，开始移动左边界，尝试缩小窗口
            if (needCnt == 0) {
                while (true) {
                    c = s.charAt(i);
                    // 左边界字符已经满足了，则退出循环，没法继续缩小
                    if (need.get(c) == 0) {
                        break;
                    }
                    need.put(c, need.getOrDefault(c, 0) + 1);
                    i++;
                }
                if (j - i < resEnd - resBegin) {
                    resBegin = i;
                    resEnd = j;
                }
            }
        }
        // resEnd 未更新过，即不存在
        if (resEnd > s.length()) {
            return "";
        } else {
            return s.substring(resBegin, resEnd + 1);
        }
    }
}
// @lc code=end

