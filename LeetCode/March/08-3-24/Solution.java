class Solution 
{
    public int maxFrequencyElements(int[] nums) 
    {
        int kMax = 100;
        int ans = 0;
        int[] count = new int[kMax + 1];

        for (int num : nums)
            ++count[num];

        int maxFreq = Arrays.stream(count).max().getAsInt();

        for (int freq : count)
            if (freq == maxFreq)
                ans += maxFreq;

        return ans;
    }
}
