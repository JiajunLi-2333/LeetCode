/*
 * @lc app=leetcode id=1652 lang=java
 *
 * [1652] Defuse the Bomb
 */
class Solution {
    public int[] decrypt(int[] code, int k) {
        // Brutal force solution
        // List<Integer> code_integer = new ArrayList<>();
        // int[] result = new int[code.length];
        // for(int i = 0; i < code.length; i++){
        //     code_integer.add(code[i]);
        // }
        // if(k == 0){
        //     return result;
        // }
        
        // if (k > 0){
        //     for(int i = 0; i < k; i++){
        //         code_integer.add(code_integer.get(i));
        //     }
        //     for(int i = 0; i < code.length; i++){
        //         int sum = 0;
        //         for(int j = i + 1; j <= i + k; j++){
        //             sum += code_integer.get(j);
        //         }
        //         result[i] = sum;
        //     }
        // }else{
        //     for(int i = 0; i < -k; i++){
        //         code_integer.add(0, code_integer.get(code_integer.size() -1 - i));
        //     }
        //     for(int i = 0; i < code.length; i++){
        //         int sum = 0;
        //         for(int j = i; j < i-k; j++){
        //             sum += code_integer.get(j);
        //         }
        //         result[i] = sum;
        //     }
        // }
        // return result;

        // Better solution
        // int n = code.length;
        // int[] result = new int[n];
        // if (k == 0) {
        //     return result;
        // }
        // int right_start = k > 0 ? k + 1 : n; // confirm the right start index of the sliding window
        // k = Math.abs(k);
        // int sum = 0;
        // for(int i = right_start - k; i < right_start; i++){
        //     sum += code[i];
        // }
        // for(int i = 0; i < n; i++){
        //     result[i] = sum;
        //     sum += code[right_start % n] - code[(right_start - k) % n];
        //     right_start++;
        // }
        // return result;

        //! The answers are formed by continuous subarrays of length k -> Enumeration and sliding window technique.
        //TODO the sliding window is used to avoid repeated calculation of sum and validdate the status of the window
        //? the modular arithmetic is used to simulate the circular array
        int n = code.length;
        int[] ans = new int[n];
        if(k == 0) return ans;
        int rightEnd = 0;
        if(k > 0){
            rightEnd = k + 1;
        }
        else{
            rightEnd = n;
            k = -k;
        }

        int sum = 0;
        for(int i = rightEnd - k; i < rightEnd; i++){
            sum += code[i];
        }
        for(int i = 0; i < n; i++){
            ans[i] = sum;
            sum += code[rightEnd % n];
            sum -= code[(rightEnd - k) % n];
            rightEnd++;
        }
        return ans;
        



    }
}
// @lc code=end

