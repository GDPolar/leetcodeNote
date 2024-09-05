package Leetcode;
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (54.40%)
 * Likes:    1909
 * Dislikes: 0
 * Total Accepted:    752.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,2,1]'
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        ListNode t1 = head, t2 = slow.next;
        while (t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        slow.next = reverse(slow.next);;
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            if (prev == dummy) {
                curr.next = null;
            }
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
// @lc code=end

