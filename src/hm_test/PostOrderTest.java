package hm_test;


import java.util.Stack;

public class PostOrderTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        four.right = six;
        PostOrder(root);
    }
    public static void PostOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            if (left == null && right == null) {
                // 都为空root出栈（打印）
                System.out.println(temp.val);
                while (!stack.isEmpty()) {

                    System.out.println(stack.pop().val);
                }
                break;
            }
            // 只要有不为空的root重新进栈（不出栈）
            stack.push(temp);
            // 先右孩子再左孩子
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
