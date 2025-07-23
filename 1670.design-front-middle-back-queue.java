/*
 * @lc app=leetcode id=1670 lang=java
 *
 * [1670] Design Front Middle Back Queue
 */
import java.util.ArrayList;
import java.util.List;
// @lc code=start
class FrontMiddleBackQueue {
    private List<Integer> queue;

    public FrontMiddleBackQueue() {
        queue = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        queue.add(0, val);
        
    }
    
    public void pushMiddle(int val) {
        int mid = queue.size() / 2;
        queue.add(mid, val);
    }
    
    public void pushBack(int val) {
        queue.add(val);
    }
    
    
    public int popFront() {
        if(queue.isEmpty()){
            return -1;
        }
        else{
            return queue.remove(0);
        }
        
    }
    
    public int popMiddle() {
        if(queue.isEmpty()){
            return -1;
        }
        if(queue.size() % 2 == 0){
            return queue.remove(queue.size() / 2 - 1);
        } else {
            return queue.remove(queue.size() / 2);
        }
    }
    
    public int popBack() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.remove(queue.size() - 1);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
// @lc code=end

