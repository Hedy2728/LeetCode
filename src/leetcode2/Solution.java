package leetcode2;

import zju.hm.ListNode;

public class Solution {
//    这个方法不行，链表的大数问题没有得到解决，所以还是依靠最原始的链表逐位相加得到结果
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;
        long res = 0;
        int i = 0, j = 0;
        ListNode list_temp = new ListNode(0);
        ListNode list = list_temp;
        while (l1 != null) {
            num1 = num1+l1.val*(int)Math.pow(10,i++);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = num2+l2.val*(int)Math.pow(10,j++);
            l2 = l2.next;
        }
        res = (long)(num1+num2) > Integer.MAX_VALUE ? Integer.MAX_VALUE : num1+num2;

        while (res >= 10) {
            ListNode temp = new ListNode(0);
            list_temp.val = (int)res % 10;
            list_temp.next = temp;
            list_temp = temp;
            res = res / 10;
        }
        list_temp.val = (int)res % 10;
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode t1 = new ListNode(4);
        ListNode t2 = new ListNode(3);
        l1.next = t1;
        t1.next = t2;

        ListNode l2 = new ListNode(5);
        ListNode p1 = new ListNode(6);
        ListNode p2 = new ListNode(4);
        l2.next = p1;
        p1.next = p2;

        ListNode res = new Solution().addTwoNumbers(l1,l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
//        System.out.println(Math.pow(2,31));
//        System.out.println(((long)9999999991+9) > Math.pow(2,31));
    }
}
