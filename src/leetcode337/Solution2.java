package leetcode337;
import zju.hm.TreeNode;

import java.util.Stack;

public class Solution2 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        int res1 = 0;
        int res2 = 0;
        stack1.push(root);
        if (root.left != null) {
            stack2.push(root.left);
        }

        if (root.right != null) {
            stack2.push(root.right);
        }
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            res1 += node.val;
            if (node.left != null) {
                if (node.left.left != null) {
                    stack1.push(node.left.left);
                }
                if (node.left.right != null) {
                    stack1.push(node.left.right);
                }
            }

            if (node.right != null) {
                if (node.right.left != null) {
                    stack1.push(node.right.left);
                }
                if (node.right.right != null) {
                    stack1.push(node.right.right);
                }
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            res2 += node.val;
            if (node.left != null) {
                if (node.left.left != null) {
                    stack2.push(node.left.left);
                }
                if (node.left.right != null) {
                    stack2.push(node.left.right);
                }
            }

            if (node.right != null) {
                if (node.right.left != null) {
                    stack2.push(node.right.left);
                }
                if (node.right.right != null) {
                    stack2.push(node.right.right);

                }
            }
        }
        return Math.max(res1, res2);
    }
}
