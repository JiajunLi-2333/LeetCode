/*
 * @lc app=leetcode id=2506 lang=java
 *
 * [2506] Count Pairs Of Similar Strings
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            int mask = 0; // 初始化一个空的集合
            for (char c : s.toCharArray()) {
                mask |= 1 << (c - 'a'); // 把 c 加到集合中 // alternatively we can manually use 2^ (c - 'a') to simulate the bit manipulation
            }
            int c = cnt.getOrDefault(mask, 0);
            ans += c;
            cnt.put(mask, c + 1);
        }
        return ans;
    }
}
// @lc code=end

