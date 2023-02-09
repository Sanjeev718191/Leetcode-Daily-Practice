class Solution {
    public long distinctNames(String[] ideas) {
        //solution -> https://www.youtube.com/watch?v=mmyvicUaBNU
        HashSet<String> grp[] = new HashSet[26];
        for(int i = 0; i<26; i++) grp[i] = new HashSet<>();
        for(String idea : ideas) grp[idea.charAt(0) - 'a'].add(idea.substring(1));
        long count = 0;
        for(int i = 0; i<25; i++){
            for(int j = i+1; j<26; j++){
                long same = 0;
                for(String idea : grp[i]){
                    if(grp[j].contains(idea)) same++;
                }
                count += 2*(grp[i].size()-same)*(grp[j].size()-same);
            }
        }
        return count;
        
    }
}