/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
 */
import java.util.*;
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        //算法策略 => 预处理 => 前缀和
        //数据结构：链表 linkedlist + 哈希HashMap => 利用链表的删除操作特性 用哈希来记录前缀和与节点之间的映射关系
        //总结考点： 预处理 | 链表操作技巧（dummy + 删节点）
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy; //从伪节点开始遍历

        int preSum = 0;
        int removePreSum = 0;//要移除的前缀和

        while(node != null){
            preSum += node.val;
            if(map.containsKey(preSum)){//当前缀和已经存在 => 说明找到了和为0的子数组  
                //在map中移除子数组的所有映射 
                removePreSum = preSum;
                for(ListNode removeNode = map.get(preSum).next; removeNode != node; removeNode = removeNode.next){
                    removePreSum += removeNode.val;
                    map.remove(removePreSum);

                }
                map.get(preSum).next = node.next;

            }else{
                map.put(preSum, node);
            }
            node = node.next;
        }
        return dummy.next;

    }
}
// @lc code=end

