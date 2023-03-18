class BrowserHistory {

    ArrayList<String> history;
    int curr, last;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        last = 0;
    }
    
    public void visit(String url) {
        curr++;
        if(history.size() > curr){
            history.set(curr, url);
        } else {
            history.add(url);
        }
        last = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr-steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */