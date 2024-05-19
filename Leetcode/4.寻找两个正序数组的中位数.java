package Leetcode;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (42.10%)
 * Likes:    7092
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length + 1;
        // 如果是奇数，会求两次同样的 k
        return 0.5 * (f(nums1, 0, nums2, 0, k / 2) + f(nums1, 0, nums2, 0, (k + 1)/ 2));
    }

    // 左闭右开，[)
    public int f(int[] nums1, int begin1, int[] nums2, int begin2, int k) {
        int len1 = nums1.length - begin1, len2 = nums2.length - begin2;
        if (len1 == 0) {
            return nums2[begin2 + k - len1 - 1];
        } 
        if (len2 == 0) {
            return nums1[begin1 + k - len2 - 1];
        }
        if (k == 1) {
            return Math.min(nums1[begin1], nums2[begin2]);
        }
        // 当前剩余元素数量不足 k/2，则就选这不足 k/2 的所有数
        int i = Math.min(begin1 + k / 2 - 1, nums1.length - 1);
        int j = Math.min(begin2 + k / 2 - 1, nums2.length - 1);
        if (nums1[i] < nums2[j]) {
            // 本轮排除掉的数量为 i - begin1 + 1
            return f(nums1, i + 1, nums2, begin2, k - (i - begin1 + 1));
        } else {
            return f(nums1, begin1, nums2, j + 1, k - (j - begin2 + 1));
        }
    }

}
// @lc code=end

