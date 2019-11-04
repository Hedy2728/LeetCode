package TreeTraversal;

import java.util.LinkedList;

public class BinarySortTree {
    private TreeNode root;

    BinarySortTree() {
        root = null;
    }

    public void insertNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode currentNode = root;

        /*build binary search tree*/
        while (true) {
            if (value > currentNode.val) {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(value);
                    break;
                }
                currentNode = currentNode.right;
            }

            else {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(value);
                    break;
                }
                currentNode = currentNode.left;
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    /**先序遍历二叉树（递归）
    * @param treeNode*/
    public void preOrderTraverse(TreeNode treeNode) {
        System.out.print(treeNode.val + " ");
        if (treeNode.left != null) {
            preOrderTraverse(treeNode.left);
        }
        if (treeNode.right != null) {
            preOrderTraverse(treeNode.right);
        }
    }

    /**
     * 中序遍历二叉树（递归）
     * @param treeNode*/
    public void midOrderTraverse(TreeNode treeNode) {
        if (treeNode.left != null) {
            midOrderTraverse(treeNode.left);
        }
        System.out.print(treeNode.val + " ");
        if (treeNode.right != null) {
            midOrderTraverse(treeNode.right);
        }
    }

    /**
     * 后序遍历二叉树（递归）
     * @param treeNode
     * */
    public void postOrderTraverse(TreeNode treeNode) {
        if (treeNode.left != null) {
            postOrderTraverse(treeNode.left);
        }
        if (treeNode.right != null) {
            postOrderTraverse(treeNode.right);
        }
        System.out.print(treeNode.val + " ");
    }

    /**
     *先序遍历二叉树（非递归）
     * @param root
     */
    public void preOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    /**
     * 中序遍历二叉树（非递归）
     * @param root
     */
    public void midOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }

    /**
     * 后序遍历二叉树（非递归）
     * @param root
     */
    public void postOrderTraverseNoRecursion(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        TreeNode rightNode = null;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            while (currentNode.right != null || currentNode.right == rightNode) {
                System.out.print(currentNode.val+" ");
                rightNode = currentNode;
                if (stack.isEmpty()) {
                    return;
                }
                currentNode = stack.pop();
            }

            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    public void postOrderTraverseNoRecursion_1(TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
            LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);

                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().val + " ");
            }

        }
    }

}
