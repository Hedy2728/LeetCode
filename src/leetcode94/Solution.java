package leetcode94;

import java.util.ArrayList;
import java.util.List;
import zju.hm.TreeNode;

public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root ==null) {
            return list;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t1.right = t2;

        System.out.println(new Solution().inorderTraversal(t1));
    }
}
