package leetcode513;
import zju.hm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        int ret = root.val;

        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
            root = queue.poll();
//            ret = node.val;
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }
}
