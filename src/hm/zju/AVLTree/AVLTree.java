package hm.zju.AVLTree;

public class AVLTree<T extends Comparable<T>> {
    class TreeNode<T extends Comparable<T>> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;
        private int height;
        TreeNode (T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private TreeNode<T> root;

    AVLTree() {
        root = null;
    }

    /**
     * 将数组内的数据存储进二叉树
     * @param nodeValues 需要录入二叉树的数组
     * @return 返回已录入数据的二叉树的根节点
     */

    static  AVLTree<Integer> initTreeAndShowData(int[] nodeValues) {
        AVLTree<Integer> tree = new AVLTree<>();
        for (int i = 0; i < nodeValues.length; i++) {
            tree.insert(nodeValues[i]);
            System.out.println(nodeValues[i] + " ");
        }
        System.out.println();
        return tree;
    }

    /**
     * 给定数据插入节点
     * @param data 需要插入树中的节点数据
     */
    public void insert(T data) {
        root = insetNode(root, data);
    }

    /**
     * 插入二叉树的内部实现
     * @param root 指定的根节点
     * @param data 需要插入的数据
     * @return 返回插入数据后的树
     */
    private TreeNode<T> insetNode(TreeNode<T> root, T data) {
        if (null == root) {
            root = new TreeNode<>(data);
        } else {
            int cmp = data.compareTo(root.data);

            if (cmp < 0) {
                root.left = insetNode(root.left, data);
                if (isLargerThanRoot(root)) {
                    if (data.compareTo(root.left.data) < 0) {
                        root = singleLeftRotation(root);
                    } else {
                        root = doubleLeftRightRoatation(root);
                    }
                } else if (cmp > 0){
                    root.right = insetNode(root.right, data);
                    if (isLargerThanRoot(root)) {
                        if (data.compareTo(root.right.data) > 0) {
                            root = singleRightRotation(root);
                        } else {
                            root = doubleRightLeftRotation(root);
                        }
                    }
                } else {
                    System.out.println("已存在相同节点");
                }
            }
        }

        root.height = Math.max(getHeightRecursion(root.left), getHeightRecursion(root.right)) + 1;
        return root;
    }

    /**
     * 平衡因子
     * @param tree 根节点
     * @return 返回是否失衡
     */
    private boolean isLargerThanRoot(TreeNode tree) {
        return Math.abs(getHeightRecord(tree.left) - getHeightRecord(tree.right)) > 1;
    }

    private int getHeightRecord(TreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return tree.height;
    }

    /**
     * 计算树的高度
     * @param tree 根节点
     * @return 树的高度
     */
    private int getHeightRecursion(TreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return Math.max(getHeightRecursion(tree.left), getHeightRecursion(tree.right)) + 1;
    }

    private TreeNode<T> singleLeftRotation(TreeNode tree) {
        TreeNode root = tree.left;
        tree.left = root.right == null ? null : root.right;
        root.right = tree;
        return root;
    }

    private TreeNode<T> singleRightRotation(TreeNode tree) {
        TreeNode root = tree.right;
        tree.right = root.left == null ? null : root.left;
        root.left = tree;
        return root;
    }

    private TreeNode<T> doubleLeftRightRoatation(TreeNode tree) {
        tree.left = singleRightRotation(tree.left);
        return singleLeftRotation(tree);
    }

    private TreeNode<T> doubleRightLeftRotation(TreeNode tree) {
        tree.right = singleLeftRotation(tree.right);
        return singleRightRotation(tree);
    }

}
