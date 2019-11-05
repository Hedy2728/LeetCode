package leetcode112;

import zju.hm.TreeNode;

import java.util.Stack;

public class Solution2 {
    //使用先序遍历将二叉树过一遍，并使用一个数字栈存储值
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);

        while (!stack.isEmpty()) {
            int value = sums.pop();
            TreeNode node = stack.pop();

            if (node.right == null && node.left == null && node.val == value) {
                return true;
            }

            if (node.left != null) {
                stack.push(node.left);
                sums.push(value-node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                sums.push(value-node.val);
            }
        }
        return false;
    }
}
