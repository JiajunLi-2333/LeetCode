/*
 * @lc app=leetcode id=923 lang=java
 *
 * [923] 3Sum With Multiplicity
 */
import java.util.*;
// @lc code=start
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long ans = 0;
        int mod = (int)1e9 + 7;
        int n = arr.length;
        for(int i = 0; i < n - 2; i++){
            int T = target - arr[i];
            int j = i + 1, k = n -1;
            while(j < k){
                if(arr[j] + arr[k] < T) j++;
                else if (arr[j] + arr[k] > T) k--;
                else{
                    if(arr[j] != arr[k]){
                        int left = 1, right = 1;
                        while(j + 1 < k && arr[j] == arr[j + 1]){
                            left++;
                            j++;
                        }
                        while(k - 1 > j && arr[k] == arr[k - 1]){
                            right++;
                            k--;
                        }
                        ans += left * right;
                        ans %= mod;
                        j++;
                        k--;
                    } else {
                        int m = k - j + 1;
                        ans += (m * (m - 1) / 2);
                        ans %= mod;
                        break;
                    }
                }
            }

        
        }
        return (int) ans; 
    }
 }
// @lc code=end

