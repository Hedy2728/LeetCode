package SwordToOffer.offer28;

import SwordToOffer.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
       return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);

    }
}
