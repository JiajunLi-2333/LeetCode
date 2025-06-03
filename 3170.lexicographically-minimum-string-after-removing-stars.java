/*
 * @lc app=leetcode id=3170 lang=java
 *
 * [3170] Lexicographically Minimum String After Removing Stars
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public String clearStars(String s) {
        @SuppressWarnings("unchecked")
        List<Integer>[] stacks = new ArrayList[26];
        Arrays.setAll(stacks, i -> new ArrayList<>());
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c);
        }
        int n = sb.length();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(s.charAt(i) == '*'){
                //Find the first non-empty stack
                for(int j = 0; j < 26; j++){
                    if(!stacks[j].isEmpty()){
                        int index = stacks[j].remove(stacks[j].size() - 1);
                        sb.setCharAt(index, '*');
                        break;
                    }
                }
            }else{
                int index = c - 'a';
                if(stacks[index] == null) {
                    stacks[index] = new ArrayList<>();
                }
                stacks[index].add(i);
            }

        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(sb.charAt(i) != '*'){
                result.append(sb.charAt(i));
            }
        }
        return result.toString();
    }
}
// @lc code=end

