//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int[] matrixDiagonally(int[][] mat) 
    {
        int n = mat.length, mode = 0, it = 0, lower = 0; 
        ArrayList<Integer> arr = new ArrayList<>();
  
        for (int t = 0; t < (2 * n - 1); t++) 
        { 
            int t1 = t; 
            if (t1 >= n) 
            { 
                mode++; 
                t1 = n - 1; 
                it--; 
                lower++; 
            } 
            else 
            { 
                lower = 0; 
                it++; 
            } 
            
            for (int i = t1; i >= lower; i--) 
            { 
                if ((t1 + mode) % 2 == 0) 
                { 
                    arr.add(mat[i][t1 + lower - i]);
                } 
                else
                { 
                    arr.add(mat[t1 + lower - i][i]); 
                } 
            } 
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}
