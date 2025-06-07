/*
 * @lc app=leetcode id=2197 lang=java
 *
 * [2197] Replace Non-Coprime Numbers in Array
 */
import java.util.List;
import java.util.ArrayList;

// @lc code=start
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num: nums){
            ans.add(num);
            //This needs to be in a while loop
            while(ans.size() > 1){
                int a = ans.get(ans.size() -1);
                int b = ans.get(ans.size() -2);
                if (GCD(a, b) > 1 ){
                    ans.remove(ans.size() -1);
                    ans.set(ans.size() -1,(int)LCM(a, b));
                }else break;
            }
            
        }
        return ans;
    }
    private long GCD(int a, int b){
        while(b > 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    private long LCM(int a, int b){
        return (long) (a / GCD(a, b)) * b;
    }
}
// @lc code=end

 