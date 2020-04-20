package SwordToOffer.offer18;

import zju.hm.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode temp = dummy;
        ListNode pre = temp.next;

        while (pre != null) {
            ListNode next = pre.next;
            if (next != null && next.val == pre.val) {
                while (next != null && next.val == pre.val) {
                    pre = next;
                    next = pre.next;
                }
                temp.next = next;
                pre = next;
            } else {
                temp = pre;
                pre = pre.next;
            }
        }
        return dummy.next;


    }
}
