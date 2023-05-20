/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 *
 * https://leetcode.cn/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (64.14%)
 * Likes:    822
 * Dislikes: 0
 * Total Accepted:    199.9K
 * Total Submissions: 311.7K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l)
 * 能满足：
 * 
 * 
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) +
 * (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) +
 * (-1) + 0 = 0
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * 
 * 
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    // 暴力的 O(n^4) 两两一组降为 O(n^2) 
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0, tempSum, times;
        HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            for (int j : nums2) {
                times = 1;
                tempSum = i + j;
                if (hm1.containsKey(tempSum)) {
                    times += hm1.get(tempSum);
                }
                hm1.put(tempSum, times);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                tempSum = i + j;
                if(hm1.containsKey(-tempSum)) {
                    res +=  hm1.get(-tempSum);
                }
            }
        }
        return res;
    }
}
// @lc code=end

