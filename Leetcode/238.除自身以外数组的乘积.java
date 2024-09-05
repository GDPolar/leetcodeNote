package Leetcode;

/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (75.50%)
 * Likes:    1821
 * Dislikes: 0
 * Total Accepted:    487.2K
 * Total Submissions: 640.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 
 * 
 * 
 * 
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 * 
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // lp[i]、rp[i] 表示 nums[i] 左侧、右侧所有数字的乘积
        int[] lp = new int[nums.length], rp = new int[nums.length];
        // 注意边界值
        lp[0] = 1;
        rp[rp.length - 1] = 1;
        for (int i = 1; i < lp.length; i++) {
            lp[i] = lp[i - 1] * nums[i - 1];
        }
        for (int i = rp.length - 2; i >= 0; i--) {
            rp[i] = rp[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = lp[i] * rp[i];
        }
        return res;
    }

    // 优化空间复杂度
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        // 先将 lp 放入 res 中
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rp = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            rp *= nums[i + 1];
            res[i] *= rp;
        }
        return res;
    }
    
}
// @lc code=end

