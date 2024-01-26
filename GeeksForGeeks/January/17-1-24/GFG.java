//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static Set<ArrayList<Integer>> ans;

    static void helper(int idx, ArrayList<Integer> arr) 
    {
        int n = arr.size();
        if (idx >= n) 
        {
            ArrayList<Integer> temp = new ArrayList<>(arr);
            ans.add(temp);
            return;
        }
        
        for (int i = idx; i < n; i++) 
        {
            Collections.swap(arr, i, idx);
            helper(idx + 1, arr);
            Collections.swap(arr, i, idx);
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) 
    {
        ans = new HashSet<>();
        Collections.sort(arr);
        helper(0, arr);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(ans);

        Collections.sort(result, (a, b) -> {
            for (int i = 0; i < n; i++) 
            {
                if (!a.get(i).equals(b.get(i))) 
                {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;       });

        return result;
    }
}
