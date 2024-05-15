class Solution
{
    public int maximumSafenessFactor(List<List<Integer>> grid)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[2]-x[2]);
        Queue<int[]> q = new LinkedList();
        
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        if (grid.get(0).get(0)==1 || grid.get(m-1).get(n-1)==1)
            return 0;

        int step[][] = new int[m][n];
        
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (grid.get(i).get(j)==1)
                {
                    q.offer(new int[]{i, j});
                    step[i][j] = 1;
                }
            }
        }

        int steps = 1;

        while (!q.isEmpty())
        {
            steps++;
            int size = q.size();
            for (int s=0; s<size; s++)
            {
                int cur[] = q.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] d: dir)
                {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    
                    if (nx>=0 && nx<m && ny>=0 && ny<n)
                    {
                        if (step[nx][ny]==0)
                        {
                            q.offer(new int[]{nx, ny});
                            step[nx][ny] = steps;
                        }
                        
                    }
                }
            }
        }

        pq.offer(new int[]{0, 0, step[0][0]});
        step[0][0] = -1;
            
        while (!pq.isEmpty())
        {
            int cur[] = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x==m-1 && y==n-1)
                return dist-1;
            
            for (int[] d: dir)
            {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx>=0 && nx<m && ny>=0 && ny<n)
                {
                    if (step[nx][ny] != -1)
                    {
                        int nsf = Math.min(dist, step[nx][ny]);
                        pq.offer(new int[]{nx, ny, nsf});
                        step[nx][ny] = -1;
                    }
                }
            }
        }

        return -1;
    }
}
