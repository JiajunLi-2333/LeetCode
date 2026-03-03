/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */
// @lc code=start
class CustomStack {
    int[] stack;
    int[] inc;
    int curSize = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
    }

    public void push(int x) {
        if(curSize < stack.length){
            stack[curSize] = x;
            curSize++;
        }
    }

    public int pop() {
        if(curSize == 0) return -1;
        curSize--;
        int val = stack[curSize] + inc[curSize];
        if(curSize > 0) inc[curSize - 1] += inc[curSize];
        inc[curSize] = 0;
        return val;
    }

    public void increment(int k, int val) {
        int idx = Math.min(k, curSize) - 1;
        if(idx >= 0) inc[idx] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end

