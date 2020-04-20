package leetcode257;

import zju.hm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

//        backtrace(root, list, "");
        backtrace(root, list, "");

        return list;
    }

    private void backtrace(TreeNode node, List<String> list, String sb) {

        if (node != null) {
//            sb.append(node.val);
            sb += Integer.toString(node.val);
            if (node.left == null && node.right == null) {
                list.add(sb.toString());
            } else {
                sb += "->";
//                sb.append("->");
                // 在此解法中，不能用Stringbuilder来代替String，因为Stirngbuilder他会一直传递，在形参中不改变，
                // 但是由于String的不可变性，所以每次sb操作都会new一个新的String，不会存在传递依赖性

                backtrace(node.left, list, sb);
                backtrace(node.right,list, sb);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        Solution s = new Solution();
        System.out.println(s.binaryTreePaths(root));
    }
}
