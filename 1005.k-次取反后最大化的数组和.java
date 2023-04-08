import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 *
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 *
 * algorithms
 * Easy (51.08%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    121.9K
 * Total Submissions: 238.8K
 * Testcase Example:  '[4,2,3]\n1'
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 
 * 
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 
 * 
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        int negativeIndex = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[negativeIndex] < 0) {
                nums[negativeIndex] *= -1;
                if (nums[negativeIndex] >= Math.abs(nums[negativeIndex + 1])) {
                    negativeIndex++;
                }
                continue;
            }
            nums[negativeIndex] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
        
        /*
        int sum = 0;
        nums = IntStream.of(nums)
        .boxed()
        .sorted((a, b) -> Math.abs(b) - Math.abs(a))
        .mapToInt(a -> Integer.valueOf(a))
        .toArray();
        for (int i = 0; i < nums.length - 1; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
            sum += nums[i];
        }
        // k 还没用完，逮着绝对值最小的元素使劲薅
        if (k % 2 == 1) {
            nums[nums.length - 1] *= -1;
        }
        sum += nums[nums.length - 1];
        return sum;
         */
    }
}
// @lc code=end

