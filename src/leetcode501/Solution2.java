package leetcode501;

import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    int pre = 0;
    boolean isFirst = true;
    int max = 0;
    int cur = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left);
        }
        if (isFirst) {
            isFirst = false;
            cur = 1;
            pre = node.val;
            list.add(node.val);
        }
        else {
            if (pre == node.val) {
                cur++;
            }
            else {
                cur = 1;
                pre = node.val;
            }
        }
        if (cur > max) {
            max = cur;
            list.clear();
            list.add(node.val);
        }
        else if (cur == max) {
            list.add(node.val);
        }

        if (node.right != null) {
            inOrder(node.right);
        }
    }
}
