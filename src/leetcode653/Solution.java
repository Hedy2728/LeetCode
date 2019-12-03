package leetcode653;

import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        inOrder(root);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) > k) {
                j--;
            }
            else if (list.get(i) + list.get(j) < k) {
                i++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }

    }
}
