/*
 * @lc app=leetcode id=2055 lang=java
 *
 * [2055] Plates Between Candles
 */

// @lc code=start
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {

        //! prefix Sum is just a method of memorization where we store the cumulation or other properties as needed
        //use an array to store the index of candle closest to the left of each index
         int lastIdx = -1;
         int n = s.length(), m = queries.length;
         int[] leftCandle = new int[n], rightCandle = new int[n], ans = new int[queries.length], preSum = new int[n + 1];

         //populate the leftCandle array
         for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|'){
                lastIdx = i;
            }
            leftCandle[i] = lastIdx;
         }

        lastIdx = -1;
         //populate the rightCandle array
        for(int i = n -1; i >= 0; i--){
            if(s.charAt(i) == '|'){
                lastIdx = i;
            }
            rightCandle[i] = lastIdx;
        }

        //calculate the prefix sum of the number of plates
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        for(int i = 0; i < m; i++){
            int left = queries[i][0], right = queries[i][1];
            int rightIndex = rightCandle[left], leftIndex = leftCandle[right];
            if(rightIndex != -1 && leftIndex != -1 && rightIndex < leftIndex){
                ans[i] = preSum[leftIndex + 1] - preSum[rightIndex];
            }
            else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

