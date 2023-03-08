class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0, low = 1;
        for(int x : piles){
            high = Math.max(high, x);
            //low = Math.min(low, x);
        }        
        if(h == piles.length) return high;
        while(low<high){
            int mid = low + (high-low)/2;
            if(checker(mid, piles, h)) high = mid;
            else low = mid+1;
        }
        return low;
    }
    private boolean checker(int t, int[] piles, int h){
        int count = 0;
        for(int x : piles){
            count += x/t;
            if(x%t > 0) count++;
        }
        if(count <= h) return true;
        return false;
    }
}