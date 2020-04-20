package SwordToOffer.offer26;

import SwordToOffer.TreeNode;

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = judgeEqual(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2) ^ HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean judgeEqual(TreeNode t1, TreeNode t2) {
        if (t2 ==null) {
            return true;
        }
        if (t1 ==null) {
            return false;
        }

        if (t1.val == t2.val) {
            return judgeEqual(t1.left, t2.left) && judgeEqual(t1.right, t2.right);
        }

        return false;
    }

}
