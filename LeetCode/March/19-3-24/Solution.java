class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int[] count = new int[26];

        for (char task : tasks)
            ++count[task - 'A'];

        int maxFreq = Arrays.stream(count).max().getAsInt();
        int maxFreqTaskOccupy = (maxFreq - 1) * (n + 1);
        int nMaxFreq = (int) Arrays.stream(count).filter(c -> c == maxFreq).count();
    
        return Math.max(maxFreqTaskOccupy + nMaxFreq, tasks.length);
    }
}
