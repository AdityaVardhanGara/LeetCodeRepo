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
    int ind=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ind=inorder.length-1;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        return helper(postorder,inorder,0,ind,mp);
    }
    public TreeNode helper(int[] postorder,int[] inorder,int left,int right,Map<Integer,Integer> mp){
        if(left>right||ind<0||ind>=inorder.length) return null;
        TreeNode root=new TreeNode(postorder[ind--]);
        root.right=helper(postorder,inorder,mp.get(root.val)+1,right,mp);
        root.left=helper(postorder,inorder,left,mp.get(root.val)-1,mp);
        return root;
    }
}
