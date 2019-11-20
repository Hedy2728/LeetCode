package leetcode637;
import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> quene = new LinkedList<>();
        quene.offer(root);
        while (!quene.isEmpty()) {
            int len = quene.size();
            double sum = 0.;
            for (int i = 0; i < len; i++) {
                TreeNode node = quene.poll();
                sum += node.val;
                if (node.left != null) {
                    quene.offer(node.left);
                }
                if (node.right != null) {
                    quene.offer(node.right);
                }
            }
            list.add(sum/len);

        }
        return list;
    }
}
