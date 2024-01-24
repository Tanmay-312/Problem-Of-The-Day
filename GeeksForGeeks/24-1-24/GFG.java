//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{
    public boolean isCyclePresent(int node,List<List<Integer>> adj,Set<Integer> vis,int p)
    {
        vis.add(node); 
        for(int i:adj.get(node))
        {
            if(!vis.contains(i))
            {
                if(!isCyclePresent(i,adj,vis,node))
                    return false;
            }
            
            else if(p!=i)
                return false;
        }
        
        return true;
    }
    
    
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> e:edges)
        {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        } 
        
        Set<Integer> vis = new HashSet<>();
        boolean b = isCyclePresent(0,adj,vis,-1);
        
        if(vis.size()!=n)
            return false;
        
        return b;
    }
}
