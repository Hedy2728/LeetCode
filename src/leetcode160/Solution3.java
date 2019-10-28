package leetcode160;

public class Solution3 {
    /*this solution is really really amazing
    * https://www.acwing.com/solution/leetcode/content/2962/
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
