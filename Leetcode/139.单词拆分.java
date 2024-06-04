package Leetcode;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 *
 * https://leetcode.cn/problems/word-break/description/
 *
 * algorithms
 * Medium (54.10%)
 * Likes:    2135
 * Dislikes: 0
 * Total Accepted:    442.5K
 * Total Submissions: 817.3K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // f[i] 表示从 [0, i] 区间的子串是否已经判断过
        boolean[] f = new boolean[s.length()];
        return dfs(s, wordDict, 0, f);
    }

    // dfs() 表示 beginIndex 前的字串符合要求（不含 beginIndex），开始判断之后的字串
    public boolean dfs(String s, List<String> wordDict, int beginIndex, boolean[] f) {
        if (beginIndex == s.length()) {
            return true;
        }
        // 很重要
        // f[beginIndex] 为 true，表示曾经遍历过这个位置之后的且未找到匹配的，若有匹配早就返回了
        if (f[beginIndex] == true) {
            return false;
        }
        f[beginIndex] = true;
        for (String str : wordDict) {
            if (s.startsWith(str, beginIndex)) { 
                // s 从 beginIndex 开始到 beginIndex + str.length() 匹配成功
                // 从 beginIndex + str.length() 继续匹配
                if (dfs(s, wordDict, beginIndex + str.length(), f)) {
                    return true;
                }
            }
        }
        return false;
    }


    // HashSet<String> set;
    // int[][] dp;
    // String str;
    // public boolean wordBreak1(String s, List<String> wordDict) {
    //     set = new HashSet<>();
    //     for (int i = 0; i < wordDict.size(); i++) {
    //         set.add(wordDict.get(i));
    //     }
    //     dp = new int[s.length()][s.length() + 1];
    //     str = s;
    //     return f(0, s.length());
    // }

    // public boolean f(int begin, int end) {
    //     if (dp[begin][end] != 0) {
    //         return dp[begin][end] > 0;
    //     }
    //     if (begin == end) {
    //         dp[begin][end] = -1;
    //         return false;
    //     }
    //     if (set.contains(str.substring(begin, end))) {
    //         dp[begin][end] = 1;
    //         return true;
    //     }
    //     for (int i = begin + 1; i < end; i++) {
    //         if(f(begin, i) && f(i, end)) {    
    //             dp[begin][end] = 1;
    //             return true;
    //         }
    //     }
    //     dp[begin][end] = -1;
    //     return false;
    // }
}
// @lc code=end

