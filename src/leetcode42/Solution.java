package leetcode42;

import zju.hm.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> linkedList = new LinkedList<>();
        if (s > e) {
            linkedList.add(null);
            return linkedList;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generateTrees(s, i-1);
            List<TreeNode> right = generateTrees(i+1, e);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    linkedList.add(root);
                }
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateTrees(3).size());
    }
}
