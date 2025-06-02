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
        long ans = 0;
        Map<Character, Stack<Integer>> charIndices = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char mirrorChar = (char)('z' - (c - 'a'));
            if(charIndices.containsKey(mirrorChar)){
                int j = charIndices.get(mirrorChar).pop();
                ans += (i - j);
                if(charIndices.get(mirrorChar).isEmpty()) {
                    charIndices.remove(mirrorChar);
                }
            }else{
                charIndices.putIfAbsent(c, new Stack<>());
                charIndices.get(c).push(i);
            }

            
        }
        return ans;

    }
}
// @lc code=end

