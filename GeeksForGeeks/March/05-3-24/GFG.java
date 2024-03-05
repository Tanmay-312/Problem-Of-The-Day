//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution
{
    static int maxIndexDiff(int arr[], int n) 
    { 
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);
 
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
 
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) 
        {
            if (LMin[i] <= RMax[j]) 
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }
 
        return maxDiff;
        
    }
    
    static int max(int x, int y)
    {
        return x > y ? x : y;
    }
 
    static int min(int x, int y)
    {
        return x < y ? x : y;
    }
}


