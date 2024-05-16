//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution 
{
    public int minimumEdgeRemove(int n, int[][] edges) 
    {
        // code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n+1; i++)
            map.put(i, new ArrayList<>());
            
        for(int [] edge : edges)
        {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        } 
       
        boolean [] vis = new boolean[n+1];
        int [] ans = new int[1];
        
        dfs(1, map, vis, ans);
        
        return ans[0];
    }
    
    
    private int dfs(int root, Map<Integer, List<Integer>> map, boolean[] vis, int[] ans)
    {
        vis[root] = true;
        int len = 1;
        for(int child : map.get(root))
        {
            if(vis[child] == false)
            {
                int res = dfs(child, map, vis, ans);
                
                if(res % 2 == 0)
                    ans[0]++;
                else
                    len += res;
            }
        }
        
        return len;
    }
}
