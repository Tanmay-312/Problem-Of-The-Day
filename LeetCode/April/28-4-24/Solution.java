class Solution 
{
    public int[] sumOfDistancesInTree(int n, int[][] edges) 
    {
        int[] ans = new int[n];
        int[] count = new int[n];
        Set<Integer>[] tree = new Set[n];

        Arrays.fill(count, 1);

        for (int i = 0; i < n; ++i)
            tree[i] = new HashSet<>();

        for (int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }

        postorder(tree, 0, -1, count, ans);
        preorder(tree, 0, -1, count, ans);
        return ans;
    }

    private void postorder(Set<Integer>[] tree, int node, int parent, int[] count, int[] ans) 
    {
        for (int child : tree[node])
        {
            if (child == parent)
                continue;
            
            postorder(tree, child, node, count, ans);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }

    private void preorder(Set<Integer>[] tree, int node, int parent, int[] count, int[] ans) 
    {
        for (int child : tree[node]) 
        {
            if (child == parent)
                continue;
      
            ans[child] = ans[node] - count[child] + (tree.length - count[child]);
            preorder(tree, child, node, count, ans);
        }
    }
}
