package Leetcode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (56.07%)
 * Likes:    1762
 * Dislikes: 0
 * Total Accepted:    496.3K
 * Total Submissions: 884.7K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        // 记录 left 节点的前一个节点
        ListNode bg = null;
        for (int i = 1; i <= right; i++) {
            if (i <= left) {
                if (i == left) {
                    bg = prev;
                }
                prev = curr;
                curr = curr.next;
            } else if (i > left) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;


            }
        }
        // 原 left 节点的 next 指向原 right 节点的 next
        bg.next.next = curr;
        // 原 left 节点的前一个节点的 next 指向新的链表
        bg.next = prev;
        return dummy.next;


        /**
        // 方法二：遍历到待反转的节点，采取头插法
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        // 记录 left 节点的前一个节点
        ListNode bg = null;
        for (int i = 1; i <= right; i++) {
            if (i <= left) {
                if (i == left) {
                    bg = prev;
                }
                prev = curr;
                curr = curr.next;
            } else if (i > left) {
                prev.next = curr.next;
                curr.next = bg.next;
                bg.next = curr;
                curr = prev.next;
            }
        }
        return dummy.next;
        */
    }
}
// @lc code=end

