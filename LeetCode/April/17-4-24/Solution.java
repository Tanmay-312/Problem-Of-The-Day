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
    public String smallestFromLeaf(TreeNode root) 
    {
        dfs(root, new StringBuilder());
        return ans;
    }

    private String ans = null;

    private void dfs(TreeNode root, StringBuilder sb) 
    {
        if (root == null)
            return;

        sb.append((char) (root.val + 'a'));

        if (root.left == null && root.right == null) 
        {
            String path = sb.reverse().toString();
            sb.reverse();

            if (ans == null || ans.compareTo(path) > 0)
                ans = path;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
