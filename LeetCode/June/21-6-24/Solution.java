class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int madeSatisfied = 0;
        int windowSatisfied = 0;

        for (int i = 0; i < customers.length; ++i)
        {
            if (grumpy[i] == 0)
                satisfied += customers[i];
            else
                windowSatisfied += customers[i];
            
            if (i >= minutes && grumpy[i - minutes] == 1)
                windowSatisfied -= customers[i - minutes];
            
            madeSatisfied = Math.max(madeSatisfied, windowSatisfied);
        }

        return satisfied + madeSatisfied;
    }
}
