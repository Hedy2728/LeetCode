package leetcode2;

import zju.hm.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;

        while (true) {
            if (l1 != null) {
                temp.val = temp.val + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp.val = temp.val + l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(temp.val /10);
            temp.val = temp.val % 10;

            if (l1 == null && l2 == null) {
                temp.next = temp.next.val == 0 ? null : temp.next;
                break;
            }
            temp = temp.next;
        }
        return res;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode p1 = new ListNode(9);
        ListNode p2 = new ListNode(9);
        ListNode p3 = new ListNode(9);
        ListNode p4 = new ListNode(9);
        ListNode p5 = new ListNode(9);
        ListNode p6 = new ListNode(9);
        ListNode p7 = new ListNode(9);
        ListNode p8 = new ListNode(9);
        ListNode p9 = new ListNode(9);
        l2.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        p8.next = p9;

        ListNode res = new Solution2().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
