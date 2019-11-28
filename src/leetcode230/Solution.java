package leetcode230;

import zju.hm.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int temp = 0;
        stack.push(cur);
        while(!stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                temp++;
                if (temp == k) {
                    return cur.val;
                }
                cur = cur.right;

            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;

        System.out.println(new Solution().kthSmallest(t1,5));
    }
}
