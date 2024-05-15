//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class DisjointSet
{
public:
    vector<int> root, rank;

    DisjointSet(int n)
    {
        root.resize(n + 1);
        rank.resize(n + 1);
        for (int i = 0; i <= n; i++)
        {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int findUP(int node)
    {
        if (node == root[node])
        {
            return node;
        }
        return root[node] = findUP(root[node]);
    }

    void unionBySize(int u, int v)
    {
        int root_u = findUP(u);
        int root_v = findUP(v);
        if (rank[root_u] < rank[root_v])
        {
            root[root_u] = root_v;
            rank[root_v] += rank[root_u];
        }
        else
        {
            root[root_v] = root_u;
            rank[root_u] += rank[root_v];
        }
        return;
    }
};

class Solution
{
public:
    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts)
    {
        int n = accounts.size();
        DisjointSet ds(n);
        vector<string> consolidated[n];
        unordered_map<string, int> email_to_index;

        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < accounts[i].size(); j++)
            {
                string email = accounts[i][j];
                if (email_to_index.find(email) == email_to_index.end())
                {
                    email_to_index[email] = i;
                }
                else
                {
                    ds.unionBySize(i, email_to_index[email]);
                }
            }
        }

        for (auto it : email_to_index)
        {
            string email = it.first;
            int parentIndex = ds.findUP(it.second);
            consolidated[parentIndex].push_back(email);
        }

        vector<vector<string>> result;

        for (int i = 0; i < n; i++)
        {
            if (consolidated[i].empty())
                continue;
            sort(consolidated[i].begin(), consolidated[i].end());
            vector<string> temp;
            temp.push_back(accounts[i][0]);
            for (auto &email : consolidated[i])
            {
                temp.push_back(email);
            }
            result.push_back(temp);
        }
        return result;
    }
};



//{ Driver Code Starts.
int main()
{
  int t;
  cin >> t;
  while (t--)
  {
    int n;
    cin >> n;
    vector<vector<string>> accounts;

    for (int i = 0; i < n; i++)
    {
      vector<string> temp;
      int x;
      cin >> x;

      for (int j = 0; j < x; j++)
      {
        string s1;
        cin >> s1;
        temp.push_back(s1);
      }
      accounts.push_back(temp);
    }

    Solution obj;
    vector<vector<string>> res = obj.accountsMerge(accounts);
    sort(res.begin(), res.end());
    cout << "[";
    for (int i = 0; i < res.size(); ++i)
    {
      cout << "[";
      for (int j = 0; j < res[i].size(); j++)
      {
        if (j != res[i].size() - 1)
          cout << res[i][j] << ","
               << " ";
        else
          cout << res[i][j];
      }
      if (i != res.size() - 1)
        cout << "], " << endl;
      else
        cout << "]";
    }
    cout << "]"
         << endl;
  }
}
// } Driver Code Ends
