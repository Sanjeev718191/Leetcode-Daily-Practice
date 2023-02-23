class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i<n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        while(k-- > 0){
            while(curr < n && projects[curr][0] <= w){
                pq.offer(projects[curr][1]);
                curr++;
            }
            if(pq.isEmpty()){
                break;
            } 
            w += pq.poll();
        }
        return w;
    }
}