/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */
import java.util.*;
// @lc code=start
class FreqStack {
    private Map<Integer, Deque<Integer>> freqGroup; //key: frequency, value: stack which stores value. 
    private Map<Integer, Integer> freqMap;
    private int maxFreq;
    public FreqStack() {
        this.maxFreq = 0;
        this.freqGroup = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqMap.merge(val, 1, Integer::sum);
        freqGroup.computeIfAbsent(freq, i -> new ArrayDeque<>()).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int val = freqGroup.get(maxFreq).pop();
        freqMap.merge(val, -1, Integer::sum);
        if(freqGroup.get(maxFreq).isEmpty()){
            maxFreq--;
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

