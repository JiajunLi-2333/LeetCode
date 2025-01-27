#
# @lc app=leetcode id=904 lang=python3
#
# [904] Fruit Into Baskets
#

# @lc code=start
from collections import Counter
class Solution:
    def totalFruit(self, fruits: list[int]) -> int:
        #! My way is too slow and inefficient
        # count = 0
        # left = 0
        # genre = Counter()
        # ans = []
        # for i in range(len(fruits)):
        #     genre[fruits[i]] += 1
        #     count += 1
        #     if len(genre)> 2:
        #         while left < i - 1:
        #             genre[fruits[left]] -= 1
        #             if genre[fruits[left]] == 0:
        #                 del genre[fruits[left]]
        #             count -= 1
        #             left += 1
        #             if len(genre) == 2:
        #                 break
        #     ans.append(count)
        # return max(ans)
        #todo This is a more efficient way of solving this
        count, i = {}, 0
        for j, v in enumerate(fruits):
            #This because we are using a dictionary but not a counter object, the get method is used to get the value of the key, if the key is not present, it returns 0
            count[v] = count.get(v, 0) + 1
            if len(count) > 2:
                count[fruits[i]] -= 1
                if count[fruits[i]] == 0: del count[fruits[i]]
                i += 1
        return j - i + 1
            
            

        
# @lc code=end

