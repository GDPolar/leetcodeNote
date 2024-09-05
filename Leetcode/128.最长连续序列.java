package Leetcode;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (52.48%)
 * Likes:    1991
 * Dislikes: 0
 * Total Accepted:    555.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^9 
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        // 去重
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            // 当前元素位于序列的起点时，计算序列长度
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(num++)) {
                length++;
            }
            res = Math.max(res, length);
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        // 哈希表的 val 表示以 key 作为左/右边界的序列长度
        HashMap<Integer, Integer> m = new HashMap<>();  
        int res = 0;  
          
        for (int n : nums) {  
            if (m.containsKey(n)) {
                continue;  
            }

            // 类似 dp 的思想，
            // 当 n 的左/右至少一边不存在时，即 n-1 或 n+1 未放入，此时 n 在左侧/右侧作为只有一个节点的序列边界，长度为 1
            // 当 n 的左右都存在时，即 n-1 和 n+1 放入，此时 n 作为序列的中间，其 val 已经无所谓了，所以放 1 也没事
            // 例如：
            // if (left != 0 && right != 0) {
            //     m.put(n,9999); 
            // 或是 m.put(n, null);
            // 都不会影响结果
            // } else {
            //     m.put(n, 1);
            // }
            m.put(n, 1);  
              
            // 获取左邻居作为右边界的序列长度
            int left = m.getOrDefault(n - 1, 0);  
            // 获取右邻居作为左边界的序列长度
            int right = m.getOrDefault(n + 1, 0);  
            // 获取当前元素 n 作为左边界或右边界的序列长度
            int len = left + right + 1;  
              

            // 维护序列边界为放入 n 后，新的序列长度
            m.put(n - left, len);   
            m.put(n + right, len); 
              
            res = Math.max(res, len);  
        }  
          
        return res;  
    }
}
// @lc code=end

