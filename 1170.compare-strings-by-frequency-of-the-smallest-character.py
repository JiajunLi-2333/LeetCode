#
# @lc app=leetcode id=1170 lang=python3
#
# [1170] Compare Strings by Frequency of the Smallest Character
#

# @lc code=start
import bisect
class Solution:
    def numSmallerByFrequency(self, queries: list[str], words: list[str]) -> list[int]:
        ans = []
        def f(s: str) -> int:
            return s.count(min(s))
        for i in range(len(words)):
            words[i] = f(words[i])
        words.sort()
        for i in range(len(queries)):
            output = f(queries[i])
            ans.append(len(words) - bisect.bisect_right(words, output))
        return ans
# @lc code=end

