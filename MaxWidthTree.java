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
    public int widthOfBinaryTree(TreeNode root) {
       HashMap<TreeNode,Integer> hp=new HashMap<>();
       List<TreeNode> ll=new LinkedList<>();
       ll.add(root);hp.put(root,0);
       int ans=0;
       while(!ll.isEmpty()){
        int siz=ll.size();
        ans=Math.max(ans,hp.getOrDefault(ll.getLast(),0)-hp.getOrDefault(ll.getFirst(),0)+1);
        while(siz-->0){
            TreeNode cur=ll.removeFirst();
            if(cur.left!=null) {
                ll.add(cur.left);hp.put(cur.left,2*hp.getOrDefault(cur,0));
            }
            if(cur.right!=null) {
                ll.add(cur.right);hp.put(cur.right,2*hp.getOrDefault(cur,0)+1);
            }
        }
       }
       return ans;
    }
}
