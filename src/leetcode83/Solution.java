package leetcode83;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next;
        while (cur != null && cur.val == head.val) cur = cur.next;
        head.next = deleteDuplicates(cur);
        return head;
    }
}
