/*
 * @lc app=leetcode id=1172 lang=java
 *
 * [1172] Dinner Plate Stacks
 */
import java.util.*; 
// @lc code=start
class DinnerPlates {
    //TODO Clarification
    //? Push: we need to know what is the leftmost stack with size less than capacity. Moreover, assume the valid stack is S. If S after the push operation is has size bigger than capacity, S stops being the valid leftmost stack.
    //? Pop: Assume R is the valid rightmost stack. If R is empty after the pop operation, then R stops to be the valid stack to pop items.
    //? popAtStack: Assume S and R are the two valid leftmost and rightmost stacks, then popAtStack might just de-valid one of them.

    //TODO Brutal Force
    //? initialize a stack array and use a for loop every time to find right stack to pop or push. Time Complexity: O(n)?  

    //TODO Optimization: Use MinHeap
    //? Initialize a list of stacks. The pop operation needs not to be maintained as we are always poping from the last non-empty stack in the list. Therefore, a minheap is needed to find the leftmost stack with size less than capacity.
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int capacity;
    private List<Deque<Integer>> stacks = new ArrayList<>();
    
    public DinnerPlates(int capacity) {
       this.capacity = capacity;
    }

    public void push(int val) {
        if(!minHeap.isEmpty() && stacks.size() <= minHeap.peek()){
            minHeap.clear();
        }
        if(minHeap.isEmpty()){
            var stack = new ArrayDeque<Integer>();
            stack.push(val);
            stacks.add(stack);
            if(capacity > 1){
                minHeap.offer(stacks.size() - 1);
            }
        }else{
            var stack = stacks.get(minHeap.peek());
            stack.push(val);
            if(stack.size() == capacity){
                minHeap.poll();
            }   
        }
    }  
    public int pop() {
        return popAtStack(stacks.size() - 1);
    }
    public int popAtStack(int index) {
        if(index >= stacks.size() || index < 0 || stacks.get(index).isEmpty()){
            return -1; // invalid operations
        }
        var stack = stacks.get(index);
        if(stack.size() == capacity){
            minHeap.offer(index);
        } 
        int val = stack.pop();
        while(!stacks.isEmpty() && stacks.get(stacks.size() -1).isEmpty()){
            stacks.remove(stacks.size() -1);
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

 