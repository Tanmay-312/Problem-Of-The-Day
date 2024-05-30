class Solution 
{
    public int numSteps(String s) 
    {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.charAt(sb.length() - 1) == '0') 
        {
            sb.deleteCharAt(sb.length() - 1);
            ++ans;
        }

        if (sb.toString().equals("1"))
            return ans;

        // `s` is now odd, so add 1 to `s` and cost 1 step.
        ++ans;

        // All the 1s will become 0s and can be popped by 1 step.
        // All the 0s will become 1s and can be popped by 2 steps (adding 1 then dividing by 2).
        for (char c : sb.toString().toCharArray())
            ans += c == '1' ? 1 : 2;

        return ans;
    }
}
