#
# @lc app=leetcode id=2389 lang=python3
#
# [2389] Longest Subsequence With Limited Sum
#

# @lc code=start
import itertools
import bisect
class Solution:
    def answerQueries(self, nums: list[int], queries: list[int]) -> list[int]:
        #In this method, the 0 is redundant, so we can just remove it
        # nums.sort()
        # ans = []
        # prefix = [0] + list(itertools.accumulate(nums))
        # for i in range(len(queries)):
        #     index = bisect.bisect_right(prefix, queries[i])
        #     ans.append(index -1)
        # return ans

        #todo A more concise method is
        A = list(itertools.accumulate(sorted(nums)))
        return [bisect.bisect_right(A, q) for q in queries]



# @lc code=end

