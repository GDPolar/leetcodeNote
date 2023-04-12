import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 *
 * https://leetcode.cn/problems/partition-labels/description/
 *
 * algorithms
 * Medium (76.78%)
 * Likes:    933
 * Dislikes: 0
 * Total Accepted:    159.3K
 * Total Submissions: 207.6K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 
 * 返回一个表示每个字符串片段的长度的列表。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(1);
        } else {
            int[] lastPos = new int[26];
            Arrays.fill(lastPos, -1);
            // 获取每种字母最后出现的位置
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                lastPos[c] = i; 
            }
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                int cover = lastPos[c];
                int j;
                // 找到当前字符的覆盖范围
                for (j = i; j < cover; j++) {
                    int ci = s.charAt(j) - 'a';
                    if (lastPos[ci] > cover) {
                        // 更新覆盖范围
                        cover = lastPos[ci];
                    }
                }
                res.add(j - i + 1);
                // 设置下一子串的起点
                i = cover;
            }
        }
        return res;
    }
}
// @lc code=end

