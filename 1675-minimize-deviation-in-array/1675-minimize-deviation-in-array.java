class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            if(x%2 == 1) x *= 2;
            pq.offer(x);
            min = Math.min(min, x);
        }
        int minDiff = Integer.MAX_VALUE;
        while(true){
            int max = pq.poll();
            minDiff = Math.min(minDiff, max - min);
            if(max%2 == 1) break;
            max = max/2;
            min = Math.min(min, max);
            pq.offer(max);
        }
        return minDiff;
    }
}