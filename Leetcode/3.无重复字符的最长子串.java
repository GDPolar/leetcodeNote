package Leetcode;


/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // 数组中存储的值表示该字符是否出现过，有为 -1，无为 0
        int[] set = new int[128];
        // HashSet<Character> set = new HashSet<>();
        // 左闭右闭
        int i = 0, j = 0;    
        while (j < s.length()) {
            if (i > j) {
                j = i;
            } else {
                if (set[s.charAt(j)] == 0) {
                    set[s.charAt(j)] = 1;
                    res = Math.max(res, j - i + 1);
                    j++;
                } else {
                    set[s.charAt(i)] = 0;
                    i++;
                }
            }
        }
        return res;
    }
}

// @lc code=end

