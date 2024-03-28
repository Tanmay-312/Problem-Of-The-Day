//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int min=101;
          int ans=-1;
          int[][] mat=new int[n][n];
          
          for(int[] mm: mat)
              Arrays.fill(mm,10001);
          
          for(int i=0;i<n;i++)
              mat[i][i]=0;
          
          for(int[] edge: edges)
              mat[edge[0]][edge[1]]=mat[edge[1]][edge[0]]=edge[2];
          
          for(int k=0;k<n;k++)
          {
              for(int i=0;i<n;i++)
              {
                  for(int j=0;j<n;j++)
                  {
                      mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                  }
              }
          }
          
          for(int i=0;i<n;i++)
          {
              int cnt=0;
              for(int j=0;j<n;j++)
              {
                  if(mat[i][j]<=distanceThreshold)
                      cnt++;
              }
              
              min=Math.min(cnt,min);
              
              if(min==cnt)
                  ans=i;
          }
          
          return ans;
      }
}
