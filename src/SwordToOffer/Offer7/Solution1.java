package SwordToOffer.Offer7;

import SwordToOffer.TreeNode;

public class Solution1 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length ==0) {
            return null;
        }

        return reconstruct(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode reconstruct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = reconstruct(pre, preStart+1, preStart+i-inStart, in, inStart, i-1);
                root.right = reconstruct(pre, preStart+i+1-inStart, preEnd, in, i+1, inEnd);
            }
        }
        return root;
    }
}
