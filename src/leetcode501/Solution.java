package leetcode501;

import zju.hm.TreeNode;

import java.util.*;

public class Solution {
    Map<Integer, Integer> map =new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        inOrder(root);

        List<Integer> list = new ArrayList<>();


        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        if (map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
            max = Math.max(max, map.get(root.val));
        }
        else {
            map.put(root.val,1);
            max = Math.max(max, 1);
        }
        if (root.right != null) {
            inOrder(root.right);
        }
    }

}
