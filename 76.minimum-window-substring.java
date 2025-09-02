/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];

        for(char c : t.toCharArray() ){
            cntT[c]++;
        }

        char[] sArr = s.toCharArray();
        int left = 0;
        int m = sArr.length;
        int leftAns = -1;
        int rightAns = m;
        
        for(int i = 0; i < m; i++){
            cntS[sArr[i]]++;
            while(left < m && check(cntS, cntT)){
                if(i - left < rightAns - leftAns){
                    leftAns = left;
                    rightAns = i;
                }
                cntS[sArr[left]]--;
                left++;
            }
        }
        return leftAns == -1 ? "" : s.substring(leftAns, rightAns + 1);
    }
    private boolean check(int[] cntS, int[] cntT){
        for(int i = 0; i < 128; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

