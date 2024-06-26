package Leetcode;

/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 *
 * https://leetcode.cn/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (55.13%)
 * Likes:    481
 * Dislikes: 0
 * Total Accepted:    111.7K
 * Total Submissions: 202.5K
 * Testcase Example:  '1'
 *
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * 
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * 
 * 
 * 
 * 
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: 1
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 2
 * 输出: [2,8]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: 3
 * 输出: [3,8,10]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= n <= 10^5
 * 
 * 
 * 
 * 
 * 进阶:
 * 
 * 
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 * 
 * 
 */

import java.util.Random;

class SolBase{
    Random random = new Random();

    public int rand7() {
        return random.nextInt(7) + 1;
    }
}

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    // rand(x) 随机生成 [1, X]
    // X 倍数的随机生成 rand(n*x) = (rand(n) - 1) * x + rand(x) 
    // X 因数的随机生成 rand(x/m) = rand(x) % (x/m) + 1
    public int rand10() {
        while (true) {
            // [1, 49]
            int rand49 = (rand7() - 1) * 7 + rand7();
            if (rand49 < 41) {
                return rand49 % 10 + 1;
            }   
            // 优化：利用 [41, 49] 作为 rand(9)
            int rand9 = rand49 - 40;
            int rand63 = (rand9 - 1) * 7 + rand7();
            if (rand63 < 61) {
                return rand63 % 10 + 1;
            }
            // 利用 [61, 63] 作为 rand(3)
            int rand3 = rand63 - 60;
            int rand21 = (rand3 - 1) * 7 + rand7();
            if (rand21 < 21) {
                return rand21 % 10 + 1;
            }
            // [21, 21] 无法优化，重新生成
        }
    }
}
// @lc code=end

