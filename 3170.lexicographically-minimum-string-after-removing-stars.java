/*
 * @lc app=leetcode id=3170 lang=java
 *
 * [3170] Lexicographically Minimum String After Removing Stars
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
class Solution {
    public String clearStars(String s) {
        //clarification
        //string, goal is to remove the *
        //remove two things: leftmost * and smallest non * character on the left
        //If we delete from left to right, delete the * when we meet one and the smallest non * character
        
        //! we are trying to keep the result lexicographically smallest
        //we also want to delete the closest one
        //"a-----a----*" by induction proof method, the condition holds

        Deque<Integer>[] stacks = new ArrayDeque[26];
        Arrays.setAll(stacks, i -> new ArrayDeque<>());
        String ans = "";
        
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(c != '*'){
                stacks[c - 'a'].push(i);
                continue;
            }

            for(int j = 0; j < stacks.length; j++){
                if(!stacks[j].isEmpty()){
                    int remove = stacks[j].pop();
                    sb.setCharAt(remove, '/');
                    break;
                }
            }
            sb.setCharAt(i, '/');
        }
        String[] intermediate = sb.toString().split("/");
        for(String str : intermediate){
            ans += str;
        }
        return ans;
    }
}
// @lc code=end

