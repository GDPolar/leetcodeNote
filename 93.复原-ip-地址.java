import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Background;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 *
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (57.83%)
 * Likes:    1178
 * Dislikes: 0
 * Total Accepted:    318.1K
 * Total Submissions: 549.4K
 * Testcase Example:  '"25525511135"'
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * 
 * 
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能
 * 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    // 类比组合问题，每次添加从 start 开始到当前选择的位置的子串，可用回溯
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return res;
        }
        backTracking(s,  0);
        return res;
    }

    public void backTracking(String s, int startIndex) {
        if (path.size() == 4) {
            // s 正好分出了四个字段，且字符串处理完毕
            if (startIndex == s.length()) {
                res.add(pathToRes(path));
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub;
            // 剪枝。当前位置不合法，后续的位置也不合法，直接跳出
            if (s.length() - i > 3 * (4 - path.size()) || !isLegal(sub = s.substring(startIndex, i + 1))) {
                break;
            }
            path.add(sub);
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isLegal(String s) {
        if (s.length() > 3) {
            return false;
        }
        // 字段不应该有前导零
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    // 格式化结果
    public String pathToRes(List<String> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(path.get(i)).append('.');
        }
        sb.append(path.get(3));
        return sb.toString();
    }
}
// @lc code=end

