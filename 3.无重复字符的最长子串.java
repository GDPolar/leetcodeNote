
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // last 数组的下标表示字符的 ASCII 码值
        // 数组中存储的值表示该字符上次出现的位置，初始化 -1
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        // 滑动窗口起始位置
        int start = 0; 
        for(int i = 0; i < n; i++) {
            // 获取当前字符的 ASCII 码值
            int index = s.charAt(i);
            // ⭐ 通过比较当前字符上次出现的位置和窗口的起始位置的大小
            // 更新 start 的值为两者中的较大值，确保窗口中没有重复的字符
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            // 更新 last[index] 的值为当前位置
            last[index] = i + 1;
        }
    return res;
    }
}

// @lc code=end

