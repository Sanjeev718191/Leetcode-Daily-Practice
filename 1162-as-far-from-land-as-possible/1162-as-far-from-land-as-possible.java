class Solution {
    public int maxDistance(int[][] grid) {
        int arr[][] = new int[][]{{0,-1}, {-1,0}, {1,0}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }
        int dis = -1;
        while(!q.isEmpty()){
            int s = q.size();
            for(int x = 0; x<s; x++){
                int[] curr = q.poll();
                for(int ind[] : arr){
                    int i = curr[0]+ind[0];
                    int j = curr[1]+ind[1];
                    if(i>=0 && j>=0 && i<grid.length && j<grid.length && grid[i][j] != 1){
                        grid[i][j] = 1;
                        q.offer(new int[]{i,j});
                    }
                }
            }
            dis++;
        }
        return dis == 0? -1: dis;
    }
}