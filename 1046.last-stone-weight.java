/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        //Create a max-heap using a priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(!maxHeap.isEmpty()){
            if(maxHeap.size() == 1){
                return maxHeap.poll();
            }
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if(s1 == s2){
                continue;
            }
            else{
                maxHeap.offer(s1 - s2);
            }
        }
        return 0;

    }
}
// @lc code=end

