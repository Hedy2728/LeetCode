package leetcode92;

import zju.hm.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode pcur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = pcur.next;
            pcur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;//为何不能返回head？因为在指针移动的过程中，head也会随之移动，所以需要返回dummy.next，选择一个固定的指针
    }
}
