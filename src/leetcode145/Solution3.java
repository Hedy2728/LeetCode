package leetcode145;

import zju.hm.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        TreeNode last = null;

        Stack<TreeNode> stack = new Stack<TreeNode>();


        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right != null && cur.right != last) {
//                visit the root, and then visit the right node anf its sub-left-tree, a root node is visited unless
//                its right node is null or it was visited
                stack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

            }
            else {
                list.add(cur.val);
                last = cur;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t1.right = t2;

        System.out.println(new Solution3().postorderTraversal(t1));
    }
}
