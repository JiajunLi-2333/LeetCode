/*
 * @lc app=leetcode id=2336 lang=java
 *
 * [2336] Smallest Number in Infinite Set
 */
import java.util.Arrays;
import java.util.PriorityQueue;
// @lc code=start
class SmallestInfiniteSet {
    private final int[] map = new int[1010];
    private final PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        Arrays.fill(map, 0);//0 means the number is not used 
        for(int i = 1; i <= 1000; i++){
            pq.offer(i);
            map[i] = 1; //Mark as used here
        }
    }
    
    public int popSmallest() {
        int cur = pq.poll();
        map[cur] = 0; //mark as unused
        return cur;
        
    }
    
    public void addBack(int num) {
        if(map[num] == 0){
            pq.offer(num);
            map[num] = 1; //mark as used
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// @lc code=end

