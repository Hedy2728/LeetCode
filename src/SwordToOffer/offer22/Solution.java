package SwordToOffer.offer22;

import zju.hm.ListNode;

public class Solution {
    /*需要注意两点：
    * 1、使用双指针解决
    * 2、注意另外一个指针初始化时应该让temp的next指向head，避免NullPointerException*/
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <=0 ) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while (k > 0 && temp != null) {
            temp = temp.next;
            k--;
        }
        if (temp == null) {
            return null;
        }
        while (temp.next != null) {
            temp = temp.next;
            head = head.next;
        }

        return head;
    }
}
