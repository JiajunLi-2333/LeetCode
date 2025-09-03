/*
 * @lc app=leetcode id=3298 lang=java
 *
 * [3298] Count Substrings That Can Be Rearranged to Contain a String II
 */

// @lc code=start
class Solution {
    public long validSubstringCount(String word1, String word2) {
        if(word1.length() < word2.length()){
            return 0;
        }
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int[] diff = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
        for (char c : t) {
            diff[c - 'a']++;
        }

        // 统计窗口内有多少个字母的出现次数比 t 的少
        int less = 0;
        for (int d : diff) {
            if (d > 0) {
                less++;
            }
        }

        long ans = 0;
        int left = 0;
        for (char c : s) {
            diff[c - 'a']--;
            if (diff[c - 'a'] == 0) {
                // c 移入窗口后，窗口内 c 的出现次数和 t 的一样
                less--;
            }
            while (less == 0) { // 窗口符合要求
                char outChar = s[left++]; // 准备移出窗口的字母
                if (diff[outChar - 'a'] == 0) {
                    // outChar 移出窗口之前检查出现次数，
                    // 如果窗口内 outChar 的出现次数和 t 的一样，
                    // 那么 outChar 移出窗口后，窗口内 outChar 的出现次数比 t 的少
                    less++;
                }
                diff[outChar - 'a']++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end

