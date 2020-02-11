package leetcode19;

import zju.hm.ListNode;

public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n > 0) {
            second = second.next;
            n--;
        }
        if (second == null) {
            return head.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
