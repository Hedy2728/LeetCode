package leetcode109;

import zju.hm.ListNode;
import zju.hm.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head,null);

    }

    public TreeNode helper(ListNode head, ListNode tail) {
        if (head ==null || head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
