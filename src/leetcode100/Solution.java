package leetcode100;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q ==null) return true;
        if ((p ==null && q != null) || (p !=null && q == null)) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;

        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = null;
        TreeNode t5 = new TreeNode(2);
        t3.left = t4;
        t3.right = t5;

        System.out.println(new Solution().isSameTree(t1, t3));
    }
}
