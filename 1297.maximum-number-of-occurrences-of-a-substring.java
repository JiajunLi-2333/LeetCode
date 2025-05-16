/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */
import java.util.HashMap;
// @lc code=start
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] freq = new char[26];
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
            
            if(i >= minSize -1){
                //count the unique letters in freq char array
                int count = 0;
                for(int j = 0; j < 26; j++){
                    if(freq[j] > 0){
                        count++;
                    }
                }
                if(count <= maxLetters){
                    String sub = s.substring(i - minSize + 1, i + 1);
                    map.merge(sub, 1, Integer::sum);
                }
                freq[s.charAt(i - minSize + 1) - 'a']--;
            }
        }
        return map.values().stream().max(Integer::compareTo).orElse(0);
    }
}
// @lc code=end

