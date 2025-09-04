/*
 * @lc app=leetcode id=2105 lang=java
 *
 * [2105] Watering Plants II
 */

// @lc code=start
class Solution {
    public int minimumRefill(int[] plants, int A, int B) {
        //最直观的双指针模拟
        int n = plants.length;
        int left = 0, right = n -1;
        int Alice = A, Bob = B;
        int ans = 0;
        while(left < right){
            if(Alice < plants[left]){
                ans++;
                Alice = A;
            }
            Alice -= plants[left];
            left++;
            if(Bob < plants[right]){
                ans++;
                Bob = B;
            }
            Bob -= plants[right];
            right--;
        }
        if(left == right && Math.max(Alice, Bob) < plants[left]) ans++;
        return ans;
    }
}
// @lc code=end

