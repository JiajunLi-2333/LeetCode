/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        //767 相似题型 重点在于贪心策略

        //统计个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int n = barcodes.length;
        int[] ans = new int[n];
        int i = 0;

        for(int barcode : barcodes){
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        //构建大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(Integer key: map.keySet()){
            pq.offer(new int[] {key, map.get(key)});
        }


        //开始构建新的数组
        while(!pq.isEmpty()){
            int[] a = pq.poll();

            int num = a[0];

            if(i > 0 && ans[i - 1] == num){
                int[] b = pq.poll();
                ans[i++] = b[0];
                b[1]--;
                if(b[1] > 0) pq.offer(new int[] {b[0], b[1]});
                pq.offer(a);
            }
            else{
                ans[i++] = num;
                a[1]--;
                if (a[1] > 0) pq.offer(new int[] {a[0], a[1]});
            }
        }
        return ans;


    }
}
// @lc code=end

