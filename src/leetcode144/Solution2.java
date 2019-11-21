package leetcode144;
import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t1.right = t2;
        System.out.println(new Solution2().preorderTraversal(t1));
    }
}
