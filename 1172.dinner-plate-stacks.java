/*
 * @lc app=leetcode id=1172 lang=java
 *
 * [1172] Dinner Plate Stacks
 */
import java.util.*; 
// @lc code=start
class DinnerPlates {
    //min-heap
    PriorityQueue<Integer> minHeap;
    List<Deque<Integer>> row;
    int capacity;
    public DinnerPlates(int capacity) {
        this.minHeap = new PriorityQueue<>();
        this.row = new ArrayList<>();
        this.capacity = capacity;
    }
    public void push(int val) {
        if(!minHeap.isEmpty() && minHeap.peek() >= row.size()){
            minHeap.clear();
        }        
        if(minHeap.isEmpty()){
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(val);
            row.add(stack);
            if(capacity > 1){
                minHeap.offer(row.size() - 1);
            }
        }else{
            var stack = row.get(minHeap.peek());
            stack.push(val);
            if(stack.size() == capacity){
                minHeap.poll();
            }
        }
    }  
    public int pop() {
        return popAtStack(row.size() -1);
    }
    public int popAtStack(int index) {
        if(index < 0 || index >= row.size() || row.get(index).isEmpty()){
            return -1;
        }

        var stack = row.get(index);
        if(stack.size() == capacity){
            minHeap.offer(index);
        }
        int val = stack.pop();
        while(!row.isEmpty() && row.get(row.size() - 1).isEmpty()){
            row.remove(row.size() -1);
        }
        return val;
    }
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
// @lc code=end

