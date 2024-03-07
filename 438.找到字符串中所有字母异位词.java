/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (53.91%)
 * Likes:    1391
 * Dislikes: 0
 * Total Accepted:    383K
 * Total Submissions: 711K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 
        int[] count = new int[26];
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()) {
            return res;
        }
        
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int differ = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0) {
                differ++;
            }
        }
        if (differ == 0) {
            res.add(0);
        }
        // 根据以 i+1 为起点的子序列滑动前的状态来处理
        for (int i = 0; i < s.length() - p.length(); i++) {
            // if (count[s.charAt(i) - 'a'] == 1) {  
            //     //窗口中s子串左边减少一个s[i]的数量(把原来多出来的1个s[i]去掉，变得相同)
            //     //两个字符串字母差距缩小
            //     --differ;
            // } else if (count[s.charAt(i) - 'a'] == 0) {  
            //     //窗口中s子串左边减少一个s[i]的数量(把原来相同数量的s[i]的减少了1个，数量变得不相同)
            //     //两个字符串字母差距增大
            //     ++differ;
            // }
            // //窗口中s子串左边减少一个字母s[i]
            // --count[s.charAt(i) - 'a'];

            //添加时只考虑count[x]==-1与count[x]==0的情况，原因分析与缩减时类似
            //右添加一位，i+pLen
            // ++count[s.charAt(i + p.length()) - 'a'];
            // if (count[s.charAt(i + p.length()) - 'a'] == 0) {  
            //     //窗口中s子串右边增加一个s[i+pLen]的数量(把原来缺少的1个s[i]加上，数量变得相同)
            //     //两个字符串字母差距缩小
            //     --differ;
            // } else if (count[s.charAt(i + p.length()) - 'a'] == 1) {  
            //     //窗口中s子串右边增加一个s[i+pLen]的数量(把原来相同数量的s[i]多加了1个，变得不相同)
            //     //两个字符串字母差距增大
            //     ++differ;
            // }


            //窗口中s子串右边增加一个字母s[i+pLen]
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] == 0) {
                differ--;
            } else if (count[s.charAt(i) - 'a'] == -1) {
                differ++;
            }

            count[s.charAt(i + p.length()) - 'a']++;
            if (count[s.charAt(i + p.length()) - 'a'] == 0) {
                differ--;
            } else if (count[s.charAt(i + p.length()) - 'a'] == 1) {
                differ++;
            }
            if (differ == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
// @lc code=end

