/*
 * @lc app=leetcode id=2024 lang=java
 *
 * [2024] Maximize the Confusion of an Exam
 */
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int left = 0, ans = 0;
        int[] cnt = new int[2];
        for(int right = 0; right < n; right++){
            char c = answerKey.charAt(right);
            if(c == 'T'){
                cnt[0]++;
            } else {
                cnt[1]++;
            }
            while(cnt[0] > k && cnt[1] > k){
                char leftChar = answerKey.charAt(left);
                if(leftChar == 'T'){
                    cnt[0]--;
                } else {
                    cnt[1]--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

