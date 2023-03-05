class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            hm.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean vis[] = new boolean[n];
        vis[0] = true;
        int count = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int y = 0; y<s; y++){
                int curr = q.poll();
                if(curr == n-1) return count;
                List<Integer> ls = hm.get(arr[curr]);
                ls.add(curr-1);
                ls.add(curr+1);
                for(int x : ls){
                    if(x >= 0 && x < n && !vis[x]){
                        q.offer(x);
                        vis[x] = true;
                    }
                }
                ls.clear();
            }
            count++;
        }
        return -1;
    }
}