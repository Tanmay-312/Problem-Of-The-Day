class Solution 
{
    public int kInversePairs(int n, int k) 
    {
        final int kMod = 1_000_000_007;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; ++i)
            dp[i][0] = 1;

        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= k; ++j) 
            {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % kMod;
                
                if (j - i >= 0)
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + kMod) % kMod;
            }

        return dp[n][k];
    }
}
