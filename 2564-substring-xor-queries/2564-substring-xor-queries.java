class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        hm.put(0, new int[]{s.indexOf("0"), s.indexOf("0")});
        int n = s.length();
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '0') continue;
            for(int j = i+1; j<=n; j++){
                String curr = s.substring(i, j);
                if(curr.length() > Integer.toBinaryString(Integer.MAX_VALUE).length()) break;
                hm.putIfAbsent(Integer.parseInt(curr, 2), new int[]{i, j-1});
            }
        }
        int[][] res = new int[queries.length][];
        for(int i = 0; i<queries.length; i++){
            int xor = queries[i][0]^queries[i][1];
            if(hm.containsKey(xor)){
                res[i] = hm.get(xor);
            } else {
                res[i] = new int[]{-1, -1};
            }
        }
        return res;
    }
}