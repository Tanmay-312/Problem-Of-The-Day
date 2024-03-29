class Solution 
{
    public long countSubarrays(int[] nums, int k) 
    {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0;

        for (int l = 0, r = 0; r < nums.length; ++r) 
        {
            if (nums[r] == maxNum)
                ++count;
            
            while (count == k)
                if (nums[l++] == maxNum)
                    --count;
            
            ans += l;
        }

        return ans;
    }
}
