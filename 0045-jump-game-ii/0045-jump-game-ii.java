class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<=Math.min(i+nums[i], nums.length-1); j++){
                dp[j] = Math.min(dp[i]+1, dp[j]);
                if(j == nums.length-1)
                    return dp[j];
            }
        }
        return dp[nums.length-1];
    }
}