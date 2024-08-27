/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        TreeNode right=helper(root.right);
        root.right=helper(root.left);
        root.left=null;
        TreeNode cur=root;
        while(cur.right!=null) cur=cur.right;
        cur.right=right;
        return root;
    }
}
