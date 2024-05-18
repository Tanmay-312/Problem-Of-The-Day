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
    public int distributeCoins(TreeNode root) 
    {
        dfs(root);
        return ans;
    }

    private int ans = 0;

    // Returns the number of coins I can give (positive) / take (negative).
    private int dfs(TreeNode root) 
    {
        if (root == null)
            return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);
        ans += Math.abs(l) + Math.abs(r);

        return (root.val - 1) + l + r;
    }
}
