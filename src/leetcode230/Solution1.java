package leetcode230;

import zju.hm.TreeNode;

public class Solution1 {
    int val;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return res;

    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        val++;
        if (val==k) {
            res = node.val;
            return;
        }
        inOrder(node.right, k);
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
