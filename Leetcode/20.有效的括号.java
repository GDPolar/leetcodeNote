import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.20%)
 * Likes:    3836
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.2M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {

        // 巧解
        // 若 s 合法，s最中间必定是成对的括号
        // int length = s.length() / 2;
        // for (int i = 0; i < length; i++) {
        //     s = s.replace("()", "").replace("{}", "").replace("[]", "");
        // }
        // return s.length() == 0;


        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char t;
        for (int i = 0; i < s.length(); i++) {
            t = s.charAt(i);
            if (t == '(') {
                stack.push(')');
            } 
            else if (t == '{') {
                stack.push('}');
            }
            else if (t == '[') {
                stack.push(']');
            }
            // 此时 t 是右括号
            else {
                // 若此时栈空，右括号没有找到对应的左括号
                // 若栈不空，放入的右括号应与上次放入的对应
                if (stack.isEmpty() || stack.pop() != t) {
                    return false;
                }
            }
        }
        // 有相应的左括号没有右括号来匹配
        return stack.isEmpty();
    }
}
// @lc code=end

