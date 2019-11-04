package TreeTraversal;

public class BinarySortTreeTest {
    public static void main(String[] args) {

        BinarySortTree tree = new BinarySortTree();

        tree.insertNode(35);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(16);
        tree.insertNode(29);
        tree.insertNode(28);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(50);
        tree.insertNode(45);
        tree.insertNode(55);

        System.out.print("先序遍历（递归）：");
        tree.preOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.print("中序遍历（递归）：");
        tree.midOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.print("后序遍历（递归）：");
        tree.postOrderTraverse(tree.getRoot());
        System.out.println();
//
        System.out.print("先序遍历（非递归）：");
        tree.preOrderTraverseNoRecursion(tree.getRoot());
        System.out.println();
        System.out.print("中序遍历（非递归）：");
        tree.midOrderTraverseNoRecursion(tree.getRoot());
        System.out.println();
        System.out.print("后序遍历（非递归）：");
        tree.postOrderTraverseNoRecursion_1(tree.getRoot());
        System.out.println();

//        System.out.print("广度优先遍历：");
//        tree.breadthFirstTraverse(tree.getRoot());
    }
}