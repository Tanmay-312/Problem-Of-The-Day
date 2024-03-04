class Solution 
{
    public int bagOfTokensScore(int[] tokens, int power) 
    {
        int ans = 0;
        int score = 0;
        int i = 0;
        int j = tokens.length - 1;

        Arrays.sort(tokens);

        while (i <= j && (power >= tokens[i] || score > 0)) 
        {
            while (i <= j && power >= tokens[i]) 
            {
                power -= tokens[i++];
                ++score;
            }
            
            ans = Math.max(ans, score);
            if (i <= j && score > 0) 
            {
                power += tokens[j--];
                --score;
            }
        }

        return ans;
    }
}
