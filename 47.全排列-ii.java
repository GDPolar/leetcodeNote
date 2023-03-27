import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode.cn/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (65.46%)
 * Likes:    1326
 * Dislikes: 0
 * Total Accepted:    436.3K
 * Total Submissions: 666.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] set;
    public List<List<Integer>> permuteUnique(int[] nums) {
        set = new int[nums.length];
        // 排序，方便通过横向相邻的节点来判断重复
        Arrays.sort(nums);
        backTracking(nums);
        return res;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // set[i - 1] != 0 树层上去重
            if (i > 0 && set[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (set[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            set[i] = 1;
            backTracking(nums);
            path.remove(path.size() - 1);
            set[i] = 0;
        }
    }
}
// @lc code=end

