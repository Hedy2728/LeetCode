package leetcode101;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTwo(root.left, root.right);
    }

    public boolean isSymmetricTwo(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 ==null) {
            return true;
        }

        if ((t1 == null && t2 != null) || (t1 != null && t2 == null)){
            return false;
        }

        if (t1.val == t2.val) {
            return  isSymmetricTwo(t1.left, t2.right) && isSymmetricTwo(t1.right, t2.left);
        }
        else {
            return false;
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

        System.out.println(new Solution().isSymmetric(t1));
    }
}
