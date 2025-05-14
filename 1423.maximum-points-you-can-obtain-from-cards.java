/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //Reverse Logic Thinking
        // int n = cardPoints.length;
        // int winSize = n - k;
        // int result = 0;
        // int sum = Arrays.stream(cardPoints).sum();
        // if(n == k){
        //     return sum;
        // }
        // for(int i = 0; i < n; i++){
        //     sum -= cardPoints[i];
        //     if(i < winSize - 1){
        //         continue;
        //     }
        //     result = Math.max(result, sum);
        //     int out = cardPoints[i - winSize + 1];
        //     sum += out;

        // }
        // return result;


        //Forward Logic Thinking too intuitive to be written
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }

        int result = sum;
        for(int i = 1; i <= k; i++){
            sum -= cardPoints[k - i];
            sum += cardPoints[cardPoints.length - i];
            result = Math.max(result, sum);
        }
        return result;
    }
}
// @lc code=end

