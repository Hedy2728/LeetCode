package leetcode107;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        return res;
    }

    public List<Integer> leafOutput(TreeNode treeNode) {
        List<Integer> list = new LinkedList<Integer>();
        if (treeNode.left != null && treeNode.right != null) {
            if (treeNode.left != null) {
                list.add(treeNode.left.val);
            }
            if (treeNode.right != null){
                list.add(treeNode.right.val);
            }
        }
        return list;
    }
}
