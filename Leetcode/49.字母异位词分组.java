/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.90%)
 * Likes:    1833
 * Dislikes: 0
 * Total Accepted:    628K
 * Total Submissions: 924.9K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        // 包含的字母相同，故两字符串排序后得到的字符串一定相同
        // 故可将排序后的字符串作为哈希表的 key
        // 也可将字符串中包含的字母出现次数这一信息作为 key
        // 有多种实现方式，一种可行的方式为按序拼接字符串，如 "cat" -> "a1c1t1"
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            /*
            // 按字母出现次数有序拼接的字符串作为 key
            int[] record = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                record[strs[i].charAt(j) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < record.length; j++) {
                if (record[j] != 0) {
                    sb.append((char)('a' + j));
                    sb.append(record[j]);
                }
            }
            String s = sb.toString();
            */

            String s = strs[i];
            char[] array = s.toCharArray();
            Arrays.sort(array);
            s = new String(array);
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            } else {
                map.get(s).add(strs[i]);
            }
        }
        // 只用到所有的值
        // map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
// @lc code=end

