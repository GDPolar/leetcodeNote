package Leetcode;

/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode.cn/problems/add-strings/description/
 *
 * algorithms
 * Easy (54.52%)
 * Likes:    824
 * Dislikes: 0
 * Total Accepted:    325K
 * Total Submissions: 596.3K
 * Testcase Example:  '"11"\n"123"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        // num1 更长
        if (num1.length() < num2.length()) {
            String s = num1;
            num1 = num2;
            num2 = s;
        }
        // num2 添加前导 0
        int a = num1.length() - num2.length();
        StringBuilder sb = new StringBuilder(a);
        for (int i = 0; i < a; i++) {
            sb.append('0');
        }
        num2 = sb.append(num2).toString();
        // 逐位相加
        char[] cs = new char[num1.length()];
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';
            cs[i] = (char) ((n1 + n2 + carry) % 10 + '0');
            carry = (n1 + n2 + carry) / 10;
        }
        if (carry == 0) {
            return new String(cs);
        } else {
            return "1" + new String(cs);
        }
    }
}
// @lc code=end

