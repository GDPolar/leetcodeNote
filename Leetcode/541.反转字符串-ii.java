package Leetcode;

/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 *
 * https://leetcode.cn/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (57.56%)
 * Likes:    579
 * Dislikes: 0
 * Total Accepted:    258.2K
 * Total Submissions: 448.6K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 
 * 
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i += 2 * k) {
            reverse(array, i, i + k > array.length ? array.length : i + k);
        }
        return new String(array);
    }

    public void reverse(char[] s, int begin, int end) {
        int length = end - begin + 1;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i + begin];
            s[i + begin] = s[end - i - 1];
            s[end - 1 - i] = temp;
        }
    }
}
// @lc code=end

