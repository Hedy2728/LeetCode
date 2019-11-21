package leetcode144;
import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t1.right = t2;
        System.out.println(new Solution().preorderTraversal(t1));
    }
}
