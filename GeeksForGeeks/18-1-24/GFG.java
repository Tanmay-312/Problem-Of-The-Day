//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class pair 
{
    int x;
    int y;
    pair(int x1, int y1)
    {
        x = x1;
        y = y1;
    }
}


class Solution
{
    int min_sprinklers(int arr[], int N)
    {
        ArrayList<pair> V = new ArrayList<pair>();
 
        // Traverse the array arr[]
        for (int i = 0; i < N; i++) 
        {
            if (arr[i] > -1) 
            {
                V.add(new pair(i - arr[i], i + arr[i]));
            }
        }
 
        Collections.sort(V, new Comparator<pair>()  {
            @Override public int compare(pair p1, pair p2)
            {
                return p1.x - p2.x;
            }});
 
        int maxRight = 0;
        int res = 0;
        int i = 0;
 
        while (maxRight < N) 
        {
            if (i == V.size() || V.get(i).x > maxRight)
                return -1;
        
            int currMax = V.get(i).y;
 
            while (i + 1 < V.size() && V.get(i + 1).x <= maxRight) 
            {
                i++;
                currMax = Math.max(currMax, V.get(i).y);
            }
            
            if (currMax < maxRight)
                return -1;
            
            res++;
            maxRight = currMax + 1;
            i++;
        }
 
        return res;
    }
}
