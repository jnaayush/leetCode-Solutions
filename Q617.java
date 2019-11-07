/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1,t2);
    }
    
    private TreeNode helper(TreeNode t1, TreeNode t2){
        if(t1==null && t2 == null){
            return null;
        }
        
        if(t1 == null){
            return t2;
        }if(t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = helper(t1.left,t2.left);
        root.right = helper(t1.right,t2.right);
        return root;
    }
}
