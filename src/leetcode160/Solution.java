package leetcode160;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;

        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;

        }
        return null;
    }
    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(1);
        ListNode b5 = new ListNode(2);
        ListNode b6 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;

        System.out.println(new Solution2().getIntersectionNode(a1, b1));
    }
}
