/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */
import java.util.Stack;
// @lc code=start
class CustomStack {
    private Stack<Integer> stack = new Stack<>();
    private int sizeCount = 0;
    private int maxSize;
    private int[] inc = new int[1000]; // Assuming maxSize won't exceed 1000
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(sizeCount < maxSize){
            stack.push(x);
            sizeCount++;
        }

    }
    
    public int pop() {
        if (sizeCount == 0){
            return -1;
        }
        int value = stack.pop() + inc[sizeCount - 1];
        if(sizeCount > 1) {
            inc[sizeCount - 2] += inc[sizeCount - 1];
        }
        inc[sizeCount - 1] = 0; // Reset the increment for the popped element
        sizeCount--;
        return value;
    }
    
    public void increment(int k, int val) {
        //You can definitely use a for loop to increment the first k elements, but that would be O(k) time complexity.
        //Instead, we can use an array to store the increment values for each index.
        int index = Math.min(sizeCount, k) -1 ;
        if(index >= 0) {
            inc[index] += val;
        }
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

