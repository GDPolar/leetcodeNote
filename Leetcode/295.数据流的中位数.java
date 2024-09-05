package Leetcode;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode.cn/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (54.39%)
 * Likes:    1032
 * Dislikes: 0
 * Total Accepted:    163.7K
 * Total Submissions: 297.3K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n' +
  '[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 
 * 
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 
 * 
 * 实现 MedianFinder 类:
 * 
 * 
 * 
 * MedianFinder() 初始化 MedianFinder 对象。
 * 
 * 
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * 
 * 
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10^-5 以内的答案将被接受。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * 
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 
 * 提示:
 * 
 * 
 * -10^5 <= num <= 10^5
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 10^4 次调用 addNum 和 findMedian
 * 
 * 
 */

// @lc code=start

import java.util.PriorityQueue;

class MedianFinder {

    // 分别存储前一半和后一半
    // 由于求中位数只需要知道中间两个数，即前一半的最大和后一半的最小，因此不需要全部排序
    // 用堆存储
    PriorityQueue<Integer> pqBig;
    PriorityQueue<Integer> pqSmall;

    public MedianFinder() {
        pqBig = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pqSmall = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // 规定当总数量为奇数时，pqBig 元素数量多一个
        if (pqBig.size() == pqSmall.size()) {
            if (!pqSmall.isEmpty() && num > pqSmall.peek()) {
                pqBig.offer(pqSmall.poll());
                pqSmall.offer(num);
            } else {
                pqBig.offer(num);
            }
        } else {
            if (num < pqBig.peek()) {
                pqSmall.offer(pqBig.poll());
                pqBig.offer(num);
            } else {
                pqSmall.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (pqBig.size() == pqSmall.size()) {
            return (pqBig.peek() + pqSmall.peek()) / 2.0;
        } else {
            return (double) pqBig.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

