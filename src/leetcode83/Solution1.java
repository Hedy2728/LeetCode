package leetcode83;

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) cur = cur.next; //第一步，寻找第一个非重复节点
            else {
                pre.next = cur; //找到后进行第二步，即让当前节点pre的next指向找到的节点cur
                pre = cur; //之后重复之前的过程
                cur = pre.next;
            }
        }
        pre.next = cur; //迭代到最后因为cur为null的时候就跳出循环了，没有执行最后的去重，所以加一句让链表末尾没有重复节点
        return head;
    }
}