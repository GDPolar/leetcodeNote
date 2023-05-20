/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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
    // 让快指针先移动n步，然后让两指针同时移动，直到快指针指向链表末尾时，删掉慢指针所指向的节点即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = slow;
        /// 快指针先走 n 步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时慢指针所指即为待删除的节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// @lc code=end

