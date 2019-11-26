package leetcode145;

import zju.hm.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack1.push(cur.left);
            }

            if (cur.right != null){
                stack1.push(cur.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode temp = stack2.pop();
            list.add(temp.val);
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
