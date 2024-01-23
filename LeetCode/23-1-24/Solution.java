class Solution 
{
    int max;
    
    public int maxLength(List<String> arr) 
    {
        max=0;    
        int ans=helper(0,"",arr);
        return ans;
    }

    private int helper(int idx,String tillnow,List<String> arr)
    {
        if(idx==arr.size()-1)
        {
            if(isUnique(arr.get(idx),tillnow))
            {
                tillnow +=arr.get(idx);
                return tillnow.length();
            }
            
            else
            {
                return tillnow.length();
            }
        }
        
        int ans1=0;
        int ans2=0;
        if(isUnique(arr.get(idx),tillnow))
            ans1=helper(idx+1,tillnow+arr.get(idx),arr);
            
        ans2=helper(idx+1,tillnow,arr);
            
        return Math.max(ans1,ans2);
    }
    
    
    private boolean isUnique(String str1,String str2)
    {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<str2.length();i++)
        {
           if(set.contains(str2.charAt(i)))
               return false;
           
           else
               set.add(str2.charAt(i));
       }

       for(int i=0;i<str1.length();i++)
       {
           if(set.contains(str1.charAt(i)))
               return false;
           
           else
               set.add(str1.charAt(i));
       }

       return true;
    }
}
