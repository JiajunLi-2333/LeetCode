#
# @lc app=leetcode id=2107 lang=python3
#
# [2107] Number of Unique Flavors After Sharing K Candies
#
import collections
# @lc code=start
class Solution:
    def shareCandies(self, candies:list[int], k: int) -> int:
        count = collections.Counter(candies)
        ans = 0
        #This is the edge case where we can take all the candies
        if k == 0:
            return len(count)

        for i, c in enumerate(candies):
            count[c] -= 1
            if count[c] == 0:
                del count[c]
            if i < k - 1:
                continue
            ans = max(ans, len(count))

            count[candies[i - k  + 1]] += 1 
        return ans




        
# @lc code=end

