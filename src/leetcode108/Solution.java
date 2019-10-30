package leetcode108;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 ){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        int mid = left + (right - left) /2;

        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, right);

        return root;
    }
}
