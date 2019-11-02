package leetcode110;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int Height(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(Height(root.left), Height(root.right)) + 1;
    }

}
