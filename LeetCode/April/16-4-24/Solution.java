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
    public TreeNode addOneRow(TreeNode root, int val, int depth) 
    {
        if (depth == 1) 
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        int d = 0;
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

        while (!q.isEmpty()) 
        {
            ++d;
            for (int sz = q.size(); sz > 0; --sz) 
            {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                
                if (node.right != null)
                    q.offer(node.right);
                
                if (d == depth - 1) 
                {
                    TreeNode cachedLeft = node.left;
                    TreeNode cachedRight = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = cachedLeft;
                    node.right.right = cachedRight;
                }
            }
            if (d == depth - 1)
                break;
        }

        return root;
    }
}
