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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        ind=0;
        return helper(preorder,inorder,mp,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder,Map<Integer,Integer> mp,
                int l,int r){
            if(l>r||ind>=preorder.length||ind<0) return null;
            TreeNode cur=new TreeNode(preorder[ind++]);
            cur.left=helper(preorder,inorder,mp,l,mp.get(cur.val)-1);
            cur.right=helper(preorder,inorder,mp,mp.get(cur.val)+1,r);
            return cur;
    }
}
