package Leetcode;

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
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        // 获取每种字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            lastPos[j] = Math.max(lastPos[j], i);
        }
        int end = 0;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            // 找到一个分割点
            if (i == end) {
                res.add(i - prev);
                prev = i;
            }
        }
        return res;

        /*
        // flag[i][0] 记录字母第一次出现的位置
        // flag[i][1] 记录字母最后一次出现的位置
        int[][] flag = new int[26][2];
        for (int i = 0; i < 26; ++i) {
            flag[i][0] = 666;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (flag[s.charAt(i) - 'a'][0] == 666) {
                flag[s.charAt(i) - 'a'][0] = i;
            } 
            flag[s.charAt(i) - 'a'][1] = i;
        }
        // 变成求重叠子区间组的个数
        Arrays.sort(flag, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int left = 0, right = flag[0][1];
        for (int i = 1; i < flag.length; ++i) {
            if (flag[i][0] == 666) {
                break;
            }
            if (flag[i][0] > right) {
                res.add(right - left + 1);
                left = flag[i][0];
                right = flag[i][1];
            } else if (flag[i][1] > right) {
                right = flag[i][1];
            } 
        }
        res.add(right - left + 1);
        return res;
        */
    }
}
// @lc code=end

