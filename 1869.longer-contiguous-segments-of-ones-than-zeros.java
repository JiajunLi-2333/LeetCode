/*
 * @lc app=leetcode id=1869 lang=java
 *
 * [1869] Longer Contiguous Segments of Ones than Zeros
 */

// @lc code=start
class Solution {
    public boolean checkZeroOnes(String s) {
        int maxOne = 0, maxZero = 0;
        int cntOne = 0, cntZero = 0;
        int left = 0, n = s.length();
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            if(c == '1'){
                cntOne++;
            }
            else{
                cntZero++;
            }
            while(left <= right && cntOne > 0 && cntZero > 0){
                char leftChar = s.charAt(left);
                if(leftChar == '1'){
                    cntOne--;
                }
                else{
                    cntZero--;
                }
                left++;
            }
            if(cntOne > 0 && cntZero == 0){
                maxOne = Math.max(maxOne, cntOne);
            }
            if(cntZero > 0 && cntOne == 0){
                maxZero = Math.max(maxZero, cntZero);
            }
        }
        return maxOne > maxZero;
    }
}
// @lc code=end

