package Leetcode;


/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 *
 * https://leetcode.cn/problems/decode-string/description/
 *
 * algorithms
 * Medium (57.51%)
 * Likes:    1800
 * Dislikes: 0
 * Total Accepted:    339.4K
 * Total Submissions: 585.3K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300] 
 * 
 * 
 */
import java.util.Stack;

// @lc code=start

class Solution {

    public String decodeString(String s) {
        Stack<Integer> nstack = new Stack<>();
        Stack<StringBuilder> restack = new Stack<>();

        int n = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                n = c - '0' + n * 10;
            } else if (c == '[') {
                // 记录 n 和当前 res
                nstack.push(n);
                restack.push(res);
                // 重新初始化
                n = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 出最近的一个左括号入的k,当前res进行计算不入栈
                int curn = nstack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curn; i++) {
                    // 此时 res 记录的是上一个 [ 到 ] 之间的结果
                    temp.append(res);
                }
                // 与括号外合并
                res = restack.pop().append(temp);
            } else {
                // 普通字符，直接添加
                res.append(c);
            }
        }
        return res.toString();
    }

    public String decodeString1(String s) {
        return f(s, 0, s.length() - 1);
    }

    public String f(String s, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        int i = begin;
        while (i <= end && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            sb.append(s.charAt(i));
            i++;
        }
        if (i <= end) {
            int n = 0;
            while (s.charAt(i) != '[') {
                n *= 10;
                n += s.charAt(i) - '0';
                i++;
            }
            int cnt = 0;
            for (int j = i; j <= end; j++) {
                // 输入的字符串合法，[] 一定是成对出现
                if (s.charAt(j) == '[') {
                    cnt++;
                } else if (s.charAt(j) == ']') {
                    cnt--;
                }
                if (cnt == 0) {
                    String sub = f(s, i + 1, j - 1);
                    while (n-- > 0) {
                        sb.append(sub);
                    }
                    sb.append(f(s, j + 1, end));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end
