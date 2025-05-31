/*
 * @lc app=leetcode id=2748 lang=java
 *
 * [2748] Number of Beautiful Pairs
 */
// @lc code=start
import java.util.Arrays;
class Solution {
    public int countBeautifulPairs(int[] nums) {
        // nums[i] % 10 != 0;
        int ans = 0;
        int[] one_Coprime = {1,2,3,4,5,6,7,8,9};
        int[] two_Coprime = {1,3,5,7,9};
        int[] three_Coprime = {1,2,4,5,7,8};
        int[] four_Coprime = {1,3,5,7,9};
        int[] five_Coprime = {1,2,3,4,6,7,8,9};
        int[] six_Coprime = {1,5,7};
        int[] seven_Coprime = {1,2,3,4,5,6,8,9};
        int[] eight_Coprime = {1,3,5,7,9};
        int[] nine_Coprime = {1,2,4,5,7,8};
        int[][] coprime = {new int[0], one_Coprime, two_Coprime, three_Coprime, four_Coprime, five_Coprime, six_Coprime, seven_Coprime, eight_Coprime, nine_Coprime};
        int[] cnt = new int[10];
        Arrays.fill(cnt, 0);
        for(int num : nums){
            int lastDigit = num % 10;
            //last digit is garantueed to be non-zero already
            for(int i = 0; i < coprime[lastDigit].length; i++){
                ans += cnt[coprime[lastDigit][i]];
            }
            cnt[getFirstDigit(num)]++;
        }
        return ans;

    }
    private int getFirstDigit(int num){
        while (num >= 10) {
            num /= 10;
        }
        return num;

    }
}
// @lc code=end

