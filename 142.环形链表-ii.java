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

        // 假设从头结点到环形入口节点的节点数为 x
        // 环形入口节点到快指针与慢指针相遇节点节点数为 y
        // 从相遇节点再到环形入口节点节点数为 z
        // 则 (x + y) * 2 = x + y + n (y + z)
        // =>  x = (n - 1) (y + z) + z
        // 当 n 为 1 的时候，公式就化为 x = z，即
        // 从头结点出发一个指针，从相遇节点也出发一个指针，这两个指针每次只走一个节点，那么当这两个指针相遇的时候就是环形入口的节点
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

