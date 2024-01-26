class Solution 
{
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Map<Integer, Integer> lossesCount = new TreeMap<>();

        for (int[] m : matches) 
        {
            int winner = m[0];
            int loser = m[1];
            
            if (!lossesCount.containsKey(winner))
                lossesCount.put(winner, 0);
            
            lossesCount.merge(loser, 1, Integer::sum);
        }

        for (final int player : lossesCount.keySet()) 
        {
            int nLosses = lossesCount.get(player);
            if (nLosses < 2)
                ans.get(nLosses).add(player);
        }

        return ans;
    }
}
