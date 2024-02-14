//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    private ArrayList<ArrayList<Integer>> ans;
    private int[] low, disc, parent;
    private int time;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ans = new ArrayList<>();
        low = new int[v];
        disc = new int[v];
        parent = new int[v];
        time = 0;
        visited = new boolean[v];

        // Calling ArticulationPoint function for each unvisited vertex
        for (int i = 0; i < v; i++) 
        {
            if (!visited[i]) {
                ArticulationPoint(i, adj);
            }
        }

        // Sorting the output in ascending order
        ans.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) 
            {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });

        return ans;
    }
    

    private void ArticulationPoint(int u, ArrayList<ArrayList<Integer>> adj) 
    {
        low[u] = time;
        disc[u] = time;
        time++;
        visited[u] = true;

        for (int v : adj.get(u)) 
        {
            if (!visited[v]) 
            {
                parent[v] = u;
                ArticulationPoint(v, adj);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) 
                {
                    ArrayList<Integer> connection = new ArrayList<>();
                    connection.add(Math.min(u, v));
                    connection.add(Math.max(u, v));
                    ans.add(connection);
                }
            }
            else if (parent[u] != v) 
            {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
