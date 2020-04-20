package SwordToOffer.offer23;

import zju.hm.ListNode;

import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    /*本题也是很有意思的一道题，思路如下：
    * 首先判断是否成环：快慢指针判断，此时应该注意的点事当slow或者fast或者fast.next为null时直接返回null
    * 若成环，计算环中节点数量：从相遇节点开始，一个指针开始挪，知道再次相遇，用个计数器计数
    * 算出环中节点数量后，两个指针从首节点开始以相同的速度开始挪，直到相遇*/
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast= fast.next.next;
            }
        }
        if (slow == null || fast ==null || fast.next == null) {
            return null;
        }

        int count = 1;
        ListNode temp = slow;
        while (slow.next != temp) {
            slow = slow.next;
            count++;
        }

        slow = pHead;
        fast = pHead;

        while (count > 0) {
            slow = slow.next;
            count--;
        }

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
//        l6.next = l3;
        System.out.println(new Solution().EntryNodeOfLoop(l1) == null);
    }
}
