package leetcode107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

}
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null)
            return ret;
        // 直接插入在头部，或者最后翻转链表
        levelOrderCore(root, ret);
        return ret;
    }

    public void levelOrderCore(TreeNode root, List<List<Integer>> ret) {
        int nextCount = 0;
        int curCount = 1;
        // 队列，层次遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> tmp = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
            curCount--;
            if (node.left != null) {
                q.offer(node.left);
                nextCount++;
            }
            if (node.right != null) {
                q.offer(node.right);
                nextCount++;
            }
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                // 把结点添加到头部，使用双向链表LinkedList
                ret.add(0, new LinkedList<>(tmp));
                tmp.clear();

            }
        }
    }
}
