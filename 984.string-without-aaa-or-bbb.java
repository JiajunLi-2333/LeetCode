/*
 * @lc app=leetcode id=984 lang=java
 *
 * [984] String Without AAA or BBB
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int a, int b) {
        //从题目入手：确定贪心策略
        //从a和b的数量入手 可以直接想到结果
        StringBuilder ans = new StringBuilder();
        while(a > 0 && b > 0){
            if(a > b){
                ans.append( "aab");
                a -= 2;
                b -= 1;
            }
            else if (b > a){
                ans.append("bba");
                a -= 1;
                b -= 2;
            }
            else{
                ans.append("ab");
                a--;
                b--;
            }
        }
        while(a > 0){
            ans.append('a');
            a--;
        }
        while(b > 0){
            ans.append('b');
            b--;
        }
        return ans.toString();
        
    }
}
// @lc code=end

