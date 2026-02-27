/*
 * @lc app=leetcode id=3412 lang=java
 *
 * [3412] Find Mirror Score of a String
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
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

        Map<Character, Stack<Integer>> map = new HashMap<>();
        char[] c = s.toCharArray();
        long ans = 0;
        for(int i = 0; i < c.length; i++){
            char mirror =  (char)('a' + 25 - (c[i] - 'a'));
            if(map.containsKey(mirror)){
                int j = map.get(mirror).pop();
                ans += i - j;
                if(map.get(mirror).isEmpty()){
                    map.remove(mirror);
                }
            }else{
                if(!map.containsKey(c[i])){
                map.put(c[i], new Stack<Integer>());
                }
                map.get(c[i]).push(i);
            }
            
        }
        return ans;
    }
}
// @lc code=end

