class Solution {
    public long maximumHappinessSum(int[] happiness, int k) 
    {
        Arrays.sort(happiness);
        int i=0, j = happiness.length-1;
        long ans=0;
        
        while (i<k)
        {
            ans += Math.max(0, happiness[j]-i);
            i++;
            j--;
        }
        
        return ans;
    }
}
