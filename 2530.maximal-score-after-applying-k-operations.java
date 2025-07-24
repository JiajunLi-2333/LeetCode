/*
 * @lc app=leetcode id=2530 lang=java
 *
 * [2530] Maximal Score After Applying K Operations
 */
// import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long maxKelements(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // for(int num : nums){
        //     pq.offer(num);
        // } 
        // long score = 0;
        // while(k-- > 0){
        //     int max = pq.poll();
        //     score += max;
        //     pq.offer((int) Math.ceil(max / 3.0));
        // }
        // return score;
        heapify(nums);
        long score = 0;
        while(k-- > 0){
            int max = nums[0];
            score += max;
            nums[0] = (int) Math.ceil(max / 3.0);
            sink(nums, 0);
        }
        return score;
    }
    //! 手动实现堆的操作
    //原地堆化最大堆
    private void heapify(int[] nums){
        //i >= nums.length / 2 都是叶子节点不需要进行堆化
        for(int i = nums.length / 2 -1; i >= 0; i--){
            sink(nums, i);
        }
    }
    private void sink(int[] nums, int i){
        int n = nums.length;
        while(2 * i  +1 < n){
            int j = 2 * i + 1;
            if(j + 1 < n && nums[j] < nums[j + 1]){
                j++;
            }
            if(nums[j] <= nums[i]){
                break;
            }
            swap(nums, i, j);
            i = j;
        }

    } 
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

