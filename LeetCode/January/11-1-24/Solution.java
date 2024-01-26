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
class Solution 
{
    public int maxAncestorDiff(TreeNode root) 
    {
        return maxAncestorDiff(root, root.val, root.val);
    }

    // Returns |the maximum - the minimum| of the tree.
    private int maxAncestorDiff(TreeNode root, int min, int max) 
    {
        if (root == null)
            return 0;
        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        final int l = maxAncestorDiff(root.left, min, max);
        final int r = maxAncestorDiff(root.right, min, max);
        
        return Math.max(max - min, Math.max(l, r));
    }
}
