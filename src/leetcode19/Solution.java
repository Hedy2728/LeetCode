package leetcode19;

import zju.hm.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        int length = 0;
        ListNode second = head;
        while (second != null) {
            length++;
            second = second.next;
        }

        length = length - n;
        second = first;
        while (length > 0) {
            second = second.next;
            length--;
        }
        second.next = second.next.next;

        return first.next;
    }
}