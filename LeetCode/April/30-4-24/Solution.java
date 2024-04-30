class Solution 
{
    public long wonderfulSubstrings(String word) 
    {
        long ans = 0;
        int prefix = 0;
        int[] count = new int[1024];
        count[0] = 1;

        for (char c : word.toCharArray()) 
        {
            prefix ^= 1 << c - 'a';
            ans += count[prefix];
            
            for (int i = 0; i < 10; ++i)
                ans += count[prefix ^ 1 << i];
            
            ++count[prefix];
        }

        return ans;
    }
}
