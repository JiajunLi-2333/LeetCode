/*
 * @lc app=leetcode id=2260 lang=java
 *
 * [2260] Minimum Consecutive Cards to Pick Up
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int minimumCardPickup(int[] cards) {
        //TODO clarification
        //Given an integer array, the goal here is to find a subarray that has the same beginning and ending element
        //we care about the min len of such arrays.

        //TODO edge case
        //cards = [1] -> -1
        //cards = [1,2,3,4,5] -> -1
        //cards = [3,3,3,3,3,3] -> 2
        //cards = [1,2,3,1,4,1] -> 3

        //TODO solution
        Map<Integer, Integer> map = new HashMap<>();//tracks the most recent occurence location of each element in the array
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++){
            if(map.containsKey(cards[i])){
               int len = i - map.get(cards[i]) + 1;
               ans = Math.min(ans, len); 
            }
            map.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

