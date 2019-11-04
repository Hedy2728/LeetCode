package TreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BFS {
    public ArrayList<Integer> BreadthFirstSearch(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            if(tree.left!=null)
                queue.offer(tree.left);
            if(tree.right!=null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }
        return lists;
    }
}
