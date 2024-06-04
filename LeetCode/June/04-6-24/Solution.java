class Solution 
{
    public int longestPalindrome(String s) 
    {
        int ans = 0;
        int[] count = new int[128];

        for (char c : s.toCharArray())
            ++count[c];

        for (int freq : count)
            ans += freq % 2 == 0 ? freq : freq - 1;

        boolean hasOddCount = Arrays.stream(count).anyMatch(freq -> freq % 2 == 1);
        return ans + (hasOddCount ? 1 : 0);
    }
}
