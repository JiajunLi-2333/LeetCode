/*
 * @lc app=leetcode id=1534 lang=java
 *
 * [1534] Count Good Triplets
 */

// @lc code=start
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        //! Enumeration: brutal force solution
        // int n = arr.length;
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (Math.abs(arr[i] - arr[j]) <= a &&
        //                 Math.abs(arr[j] - arr[k]) <= b &&
        //                 Math.abs(arr[i] - arr[k]) <= c) {
        //                 ans++;
        //             }
        //         }
        //     }
        // }
        // return ans;

        //! Enumeration: Question Exploration
        //? arr[i]'s value range and prefix sum
        int mx = 0;
        for(int x : arr){
            mx = Math.max(x, mx);
        } 

        int[] prefixSum = new int[mx + 2];
        
        int n = arr.length;
        int ans = 0;
        for(int j = 0; j < n; j++){
            int y = arr[j];
            for(int k = j + 1; k < n; k++){
                int z = arr[k];
                if(Math.abs(z - y) > b){
                    continue;
                }
                int leftEnd = Math.max(Math.max(y - a, z - c), 0);
                int rightEnd = Math.min(Math.min(y + a, z + c), mx);
                ans += Math.max(prefixSum[rightEnd + 1] - prefixSum[leftEnd], 0);   
            }
            for(int x  = y + 1; x < prefixSum.length; x++){
                prefixSum[x]++;
            }
        }
        return ans;

    }
}
// @lc code=end

