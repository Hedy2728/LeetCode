package leetcode141;
import zju.hm.ListNode;

import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode p=head;
        HashSet hashSet = new HashSet();
        while(p.next != null) {
            p = p.next;
            if (hashSet.contains(p.hashCode())) {
                return true;
            }
            else {
                hashSet.add(p.hashCode());
            }
        }


        return false;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p2;
        System.out.println(new Solution().hasCycle(p1));

    }
}
