/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */
import java.util.List;
import java.util.ArrayList;
// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans = new ArrayList<>();
        for(int ast : asteroids){
            boolean attach = true;
            while(attach && !ans.isEmpty() && ans.get(ans.size() -1) > 0 && ast < 0){
                int last = ans.get(ans.size() - 1), asteroid = -ast;
                if(last <= asteroid) ans.remove(ans.size() -1); 
                if(last >= asteroid) attach = false;
            }
            if(attach) ans.add(ast);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
// @lc code=end

