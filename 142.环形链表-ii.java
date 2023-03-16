import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            if (set.contains(head)) {
                return head;
            }
            else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
        */
        ListNode fast = head, slow = head;
        ListNode res;
        while (true) {
            if (fast == null || fast.next == null) {
                // 没有交点
                return null;
            }
            // 快指针一次走两步，慢指针一次走一步
            fast = fast.next.next;
            slow = slow.next;
            // 找到交点
            if (fast == slow) break;
        }
        res = head;
        while (slow != res) {
            slow = slow.next;
            res = res.next;
        }
        return res;
    }
}
// @lc code=end

