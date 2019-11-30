package leetcode538;

import zju.hm.TreeNode;

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        tranverse(root);
        return root;
    }

    public void tranverse(TreeNode node) {
        if (node == null) {
            return;
        }
        tranverse(node.right);
        sum += node.val;
        node.val = sum;

        
        tranverse(node.left);
    }
}
