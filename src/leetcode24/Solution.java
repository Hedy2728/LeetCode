package leetcode24;

import zju.hm.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummy = pre;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode res = new Solution().swapPairs(p1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
