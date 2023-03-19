class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isWord;
    TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {

    TrieNode head;

    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = head;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, word.length(), head);
    }
    private boolean search(String word, int ind, int n, TrieNode curr){
        if(curr == null) return false;
        if(ind == n){
            if(curr.isWord){
                return true;
            } 
            return false;
        }
        char c = word.charAt(ind);
        if(c == '.'){
            for(TrieNode child : curr.children.values()){
                if(search(word, ind+1, n, child)) return true;
            }
            return false;
        } 
        if(curr.children.containsKey(c)){
            return search(word, ind+1, n, curr.children.get(c)); 
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */