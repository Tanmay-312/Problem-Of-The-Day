//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int[] FindExitPoint(int n, int m, int[][] matrix) 
    {
        // code here
        int i = 0, j = 0, currentDirection = 0;
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; 
        
        while(i >= 0 && i < n && j >= 0 && j < m) 
        {
            if(matrix[i][j] == 0) 
            {
                i += directions[currentDirection][0];
                j += directions[currentDirection][1];  
            }
            else 
            {
                matrix[i][j] = 0;
                currentDirection++;
                currentDirection %= 4;
                i += directions[currentDirection][0];
                j += directions[currentDirection][1];
            }
        }
        
        i -= directions[currentDirection][0];
        j -= directions[currentDirection][1];
        
        return new int[] { i, j };
    }
}
