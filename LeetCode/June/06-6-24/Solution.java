class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int card : hand)
            count.merge(card, 1, Integer::sum);

        for (int start : count.keySet()) 
        {
            int value = count.getOrDefault(start, 0);
            if (value > 0)
                for (int i = start; i < start + groupSize; ++i)
                    if (count.merge(i, -value, Integer::sum) < 0)
                        return false;
        }

        return true;
    }
}
