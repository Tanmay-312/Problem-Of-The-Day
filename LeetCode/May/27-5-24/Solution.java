class Solution 
{
    public int specialArray(int[] nums) 
    {
        int n = nums.length;

        for(int i =0; i<=n; i++)
        {
            int count = 0;
            
            for (int j : nums)
                if (j >= i)
                    count++;
            
            if (i == count)
                return i;
        }
        return -1;
    }
}
