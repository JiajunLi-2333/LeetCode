/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        //! Wrong answer as the array is not hashbale
        // Map<int[], Integer> map = new HashMap<>();
        // int ans = 0;
        // for(int[] domino: dominoes){
        //     if(domino[0] > domino[1]){
        //         int next = domino[0];
        //         domino[0] = domino[1];
        //         domino[1] = next;
        //     }
        //     if(map.containsKey(domino)){
        //         ans += map.get(domino);
        //         map.put(domino, map.get(domino) + 1);
        //     }
        //     map.put(domino, map.getOrDefault(domino, 0) + 1);
        // }
        // return ans; 
        
        //! Correct answer using a key based on the values of the dominoes
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] domino: dominoes){
            if(domino[0] > domino[1]){
                int next = domino[0];
                domino[0] = domino[1];
                domino[1] = next;
            }
            int key = domino[0] * 10 + domino[1];
            ans += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return ans;

    }
}
// @lc code=end

