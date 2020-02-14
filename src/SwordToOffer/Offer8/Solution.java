package SwordToOffer.Offer8;

import zju.hm.TreeNode;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) {
            return null;
        }
        TreeLinkNode pNext = null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        }
        else if (pNode.next != null) {
            TreeLinkNode pParrent = pNode.next;
            while (pParrent != null && pNode == pParrent.right) {
                pNode = pParrent;
                pParrent = pParrent.next;
            }
            pNext = pParrent;
        }
        return pNext;
    }
}
