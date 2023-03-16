import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {0, 0};
        // key 是值，value 是序号
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hashMap.get(target - nums[i]);
                return res;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }
}
// @lc code=end

