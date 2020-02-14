package SwordToOffer.Offer7;

import SwordToOffer.TreeNode;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return reconstruct(pre, in);
    }

    private TreeNode reconstruct(int [] pre, int [] in) {
        int start = pre[0];
        TreeNode root = new TreeNode(start);
        root.left = null;
        root.right = null;

        int leftNum = 0;
        for (int i = 0; i < in.length; i++) {
            if (start == in[i]) {
                break;
            }
            else {
                leftNum++;
            }
        }

        int rightNum = in.length - 1 - leftNum;

        if (leftNum > 0) {
            int[] preOrderLeft = new int[leftNum];
            int[] inOrderLeft = new int[leftNum];

            for (int i = 0; i < leftNum; i++) {
                preOrderLeft[i] = pre[i+1];
                inOrderLeft[i] = in[i];
            }

            TreeNode rootLeft = reconstruct(preOrderLeft, inOrderLeft);
            root.left = rootLeft;
        }

        if (rightNum > 0) {
            int[] preOrderRight = new int[rightNum];
            int[] inOrderRight = new int[rightNum];

            for (int i = 0; i < rightNum; i++) {
                preOrderRight[i] = pre[i+1+leftNum];
                inOrderRight[i] = in[i+1+leftNum];
            }

            TreeNode rootRight = reconstruct(preOrderRight, inOrderRight);
            root.right = rootRight;
        }
        return root;
    }
}
