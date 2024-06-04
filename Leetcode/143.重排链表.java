package Leetcode;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode.cn/problems/reorder-list/description/
 *
 * algorithms
 * Medium (66.13%)
 * Likes:    1463
 * Dislikes: 0
 * Total Accepted:    312.1K
 * Total Submissions: 471.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * 
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * 
 * 
 * 请将其重新排列后变为：
 * 
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }
        // 1、找到中点 
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow 为中点或中点前一个
        // 2、反转后半段
        ListNode prev = slow, curr = slow.next;
        while (curr != null) {
            ListNode temp = curr.next;
            if (prev == slow) {
                curr.next = null;
            } else {
                curr.next = prev;   
            }
            prev = curr;
            curr = temp;
        }
        // 断开两个链表
        slow.next = null;

        // 3、合并
        ListNode hd1 = head, hd2 = prev;
        while (hd2 != null) {
            ListNode temp = hd2.next;
            hd2.next = hd1.next;
            hd1.next = hd2;
            hd1 = hd1.next.next;
            hd2 = temp;
        }
    }
}
// @lc code=end

