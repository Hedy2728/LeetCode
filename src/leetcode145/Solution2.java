package leetcode145;
import zju.hm.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();

        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        Collections.reverse(list);
        return list;
    }

}
