/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
// @lc code=start
class FreqStack {
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    private final List<Stack<Integer>> stacks = new ArrayList<>();
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int count = freqMap.getOrDefault(val, 0);
        if(count == stacks.size()){
            stacks.add(new Stack<>());
        }
        stacks.get(count).push(val);
        freqMap.put(val, count + 1);
    }
    
    public int pop() {
        int lastIndex = stacks.size() - 1;
        int val = stacks.get(lastIndex).pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if(stacks.get(lastIndex).isEmpty()) {
            stacks.remove(lastIndex);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

