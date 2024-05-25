class Solution 
{
    List<String> ans=new ArrayList<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        HashSet<String> hs=new HashSet<>();
        for(String str:wordDict)
            hs.add(str);
        
        findAns(0,s,hs,"");
        return ans;
    }

    public void findAns(int index,String s,HashSet hs,String temp)
    {
        if(index==s.length())
        {
            ans.add(temp.substring(0,temp.length()-1));
            return;
        }
        
        for(int i=index;i<s.length();i++)
        {
            String st=s.substring(index,i+1);
            if(hs.contains(st))
                findAns(i+1,s,hs,temp+st+" ");
        }
    }
}
