/*
 * @lc app=leetcode id=3412 lang=java
 *
 * [3412] Find Mirror Score of a String
 */
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Deque;
// @lc code=start
class Solution {
    public long calculateScore(String s) {
        //clarification 
        //string
        // for each index i, need want index j < i st s[i] and s[j] are reversed to each other. once an index is marked, we cannot used it again.
        //valid j: unmarked && closest

        //constraints 
        // 1 <= s.length <= 10^5
        // s :: only lowercase letters

        //edge cases
        //s = "aaaaaaaa" -> 0
        //s = "zza" -> 1
        //s = "zzzzaaa" -> 
        //s = 
        
        //solution
        //two pointers, a nested for loop, boolean[] tracks whether the index has been marked yet.
        //O(n^2) O(n)

        //Better solution: map + stack
        Map<Character, Deque<Integer>> map = new HashMap<>();
        long ans = 0; 
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            char complement = (char) ('a' + 'z' - c[i]);
            if(map.containsKey(complement) && !map.get(complement).isEmpty()){
                int j = map.get(complement).pop();
                ans += i - j;
            }
            else{
                map.computeIfAbsent(c[i], k -> new ArrayDeque<Integer>()).push(i);
            }

        }
        return ans;
        
    }
}
// @lc code=end

