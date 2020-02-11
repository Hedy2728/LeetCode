package leetcode83;

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if(cur == null) {
            return head;
        }
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else{
                cur = cur.next;
            }
        }
        return head;
    }


}
