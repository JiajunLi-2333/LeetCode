/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;
class BrowserHistory {
    private final List<String> history = new ArrayList<>();
    private int curIndex = 0;
    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        curIndex++;
        // Remove all forward history
        history.subList(curIndex, history.size() ).clear();
        history.add(url);
    }
    
    public String back(int steps) {
        curIndex = Math.max(0, curIndex - steps);
        return history.get(curIndex);
    }
    
    public String forward(int steps) {
        curIndex = Math.min(history.size()-1, curIndex + steps);
        return history.get(curIndex);
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

