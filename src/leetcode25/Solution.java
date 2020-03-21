package leetcode25;

import zju.hm.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int count = 0;
        ListNode he = dummy;
        while (he.next != null) {
            count++;
            he = he.next;
            if (count % k == 0) {
                temp = reverse(temp, k);
                count = 0;
                he = temp;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode temp, int k) {
        ListNode cur = temp.next;
        ListNode next = temp.next.next;

        while (k > 1) {
            cur.next = next.next;
            next.next = temp.next;
            temp.next = next;
            next = cur.next;
            k--;
        }
        return cur;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Solution s = new Solution();
        ListNode l = s.reverseKGroup(l1, 3);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }
}
