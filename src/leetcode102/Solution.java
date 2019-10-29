package leetcode102;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
           return result;
        }
        outLeaf(root, 0);
        return result;
    }

    public void outLeaf(TreeNode treeNode, int p) {
        if (result.size() == p) {
            result.add(new ArrayList<Integer>());
        }
        result.get(p).add(treeNode.val);
        if (treeNode.left != null) {
            outLeaf(treeNode.left, p+1);
        }
        if (treeNode.right != null) {
            outLeaf(treeNode.right, p+1);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new Solution().levelOrder(t1));
    }
}
