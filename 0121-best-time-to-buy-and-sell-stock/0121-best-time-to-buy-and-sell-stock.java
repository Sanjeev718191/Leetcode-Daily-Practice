class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int diff = Integer.MIN_VALUE;
        for(int i = 0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, prices[i]-min);
        }
        return diff;
    }
}