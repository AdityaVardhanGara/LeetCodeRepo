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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> ll=new LinkedList<>();
        boolean flag=true;
        if(root!=null) ll.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        while(!ll.isEmpty()){
            int siz=ll.size();
            List<Integer> curList=new ArrayList<>();
            System.out.println(ll.size());
            if(flag){
                while(siz>0){
                    TreeNode cur=ll.removeFirst();
                    curList.add(cur.val);
                    if(cur.left!=null) ll.add(cur.left);
                    if(cur.right!=null) ll.add(cur.right);
                    siz=siz-1;
                }
            }else{
                while(siz>0){
                    TreeNode cur=ll.removeLast();
                    curList.add(cur.val);
                    if(cur.right!=null) ll.addFirst(cur.right);
                    if(cur.left!=null) ll.addFirst(cur.left);
                    siz=siz-1;
                }
                // Collections.reverse(ll);
            }
            flag=!flag;
            ans.add(curList);
        }
    return ans;
    }
}
