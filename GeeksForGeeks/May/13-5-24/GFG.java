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

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++)
            adj.add(new ArrayList<Integer>());
        
        for (int[] edge : edges) 
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int ans = 0;
        int[] visited = new int[v + 1];
        
        for (int i = 1; i <= v; i++) 
        {
            if (visited[i] == 0) 
            {
                int[] vertices = { 0 };
                int[] edgeCount = { 0 };
                
                dfs(i, vertices, edgeCount, adj, visited);
                edgeCount[0] /= 2;
                
                if (edgeCount[0] == (vertices[0] * (vertices[0] - 1)) / 2)
                    ans++;
            }

        }

        return ans;
    }
    
    
    private static void dfs(int v, int[] vertices, int[] edges, ArrayList<ArrayList<Integer>> adj, int[] visited) 
    {
        visited[v] = 1;
        vertices[0]++;
        edges[0] += adj.get(v).size();
        
        for (int to : adj.get(v))
            if (visited[to] == 0)
                dfs(to, vertices, edges, adj, visited);
    }
}
