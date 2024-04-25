class Solution 
{
    public int longestIdealString(String s, int k) 
    {
        int[] dp = new int[26];

        for (char c : s.toCharArray()) 
        {
            int i = c - 'a';
            dp[i] = 1 + getMaxReachable(dp, i, k);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    private int getMaxReachable(int[] dp, int i, int k) 
    {
        int first = Math.max(0, i - k);
        int last = Math.min(25, i + k);
        int maxReachable = 0;
        
        for (int j = first; j <= last; ++j)
            maxReachable = Math.max(maxReachable, dp[j]);
        
        return maxReachable;
    }
}
